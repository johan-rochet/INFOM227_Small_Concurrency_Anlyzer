package com.SmallConcurrency;


import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class SemanticVisitor extends SmallConcurrencyGrammarBaseVisitor<Object> {

    private Map<String, Integer> globalScope;
    private List<Thread> threads;
    private Thread currentThread;
    private List<String> all_locked_variables;
    private List<FunctionInfo> functions;
    public SemanticVisitor() {
        super();
        globalScope = new HashMap<String, Integer>();
        threads = new ArrayList<Thread>();
        currentThread = new Thread();
        all_locked_variables = new ArrayList<String>();
        functions = new ArrayList<FunctionInfo>();
    }

    public void printInfo () {

        System.out.println("Global variables: ");
        for (Map.Entry<String, Integer> entry : globalScope.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("Functions: ");
        for (FunctionInfo function : functions) {
            System.out.println("Function name: " + function.getName());
            System.out.println("Function parameters: ");
            for (String parameter : function.getParameters()) {
                System.out.println(parameter);
            }
            System.out.println("Function instructions: ");
            System.out.println(function.getInstructions_set().getText());

        }

    }

    @Override
    public Object visitChildren(RuleNode node) {
        Object result = defaultResult();
        int n = node.getChildCount();
        for (int i=0; i<n; i++) {
            if (!shouldVisitNextChild(node, result)) {
                break;
            }

            ParseTree c = node.getChild(i);
            Object childResult = c.accept(this);
            result = aggregateResult(result, childResult);
        }
        List<Object> list_result = (List<Object>) result ;
        return result;
    }

    @Override
    protected Object aggregateResult(Object aggregate, Object nextResult) {

        if (nextResult == null){
            return aggregate ;
        }

        List<Object> result = new ArrayList<>();

        if (aggregate != null) {
            result = (List<Object>) aggregate;
        }
        result.add(nextResult);

        return result ;

    }
    @Override
    public Object visitRoot(SmallConcurrencyGrammarParser.RootContext ctx) {

        for (SmallConcurrencyGrammarParser.GlobalVarDeclContext globalVarDeclContext : ctx.globalVarDecl()) {
            visitGlobalVarDecl(globalVarDeclContext);
        }

        for (SmallConcurrencyGrammarParser.FuncDefContext funcDefContext : ctx.funcDef()) {
            visitFuncDef(funcDefContext);
        }

        return null;

    }

    @Override
    public Object visitOp(SmallConcurrencyGrammarParser.OpContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitRop(SmallConcurrencyGrammarParser.RopContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitNOprnd(SmallConcurrencyGrammarParser.NOprndContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitBOprnd(SmallConcurrencyGrammarParser.BOprndContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitBinOP(SmallConcurrencyGrammarParser.BinOPContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitRelOp(SmallConcurrencyGrammarParser.RelOpContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitArithmExp(SmallConcurrencyGrammarParser.ArithmExpContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitBoolExp(SmallConcurrencyGrammarParser.BoolExpContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitExpr(SmallConcurrencyGrammarParser.ExprContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitReturnStatement(SmallConcurrencyGrammarParser.ReturnStatementContext ctx) {
        return  visitChildren(ctx);
    }

    @Override
    public Object visitExprList(SmallConcurrencyGrammarParser.ExprListContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitFuncCall(SmallConcurrencyGrammarParser.FuncCallContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitAssignStatement(SmallConcurrencyGrammarParser.AssignStatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitStatement(SmallConcurrencyGrammarParser.StatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitIfStatement(SmallConcurrencyGrammarParser.IfStatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitWhileStatement(SmallConcurrencyGrammarParser.WhileStatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitSequence(SmallConcurrencyGrammarParser.SequenceContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitParamList(SmallConcurrencyGrammarParser.ParamListContext ctx) {

        if (ctx.getChildCount() == 0) {
            List<String> result = new ArrayList<String>();

            return result.add(ctx.ID().getText()) ;
        }
        return aggregateResult(ctx.ID().getText(), visitParamList(ctx.paramList()));
    }

    @Override
    public Object visitFuncDef(SmallConcurrencyGrammarParser.FuncDefContext ctx) {

        String func_name = ctx.ID().getText();

        for (FunctionInfo function : functions) {
            if (function.getName().equals(func_name)) {
                System.out.println("Error: function " + func_name + " already declared");
                System.exit(1);
            }
        }

        List<String> functionParameters = new ArrayList<String>();

        if (ctx.paramList() != null ) {
            functionParameters = (List<String>)visitParamList(ctx.paramList());
        }

        functions.add(new FunctionInfo(func_name, functionParameters, ctx.sequence()));

        // IF it's main, visit the sequence
        if (func_name.equals("main")) {
            visitSequence(ctx.sequence());
        }

        return null;
    }

    @Override
    public Object visitVarDecl(SmallConcurrencyGrammarParser.VarDeclContext ctx) {

        String var_name = ctx.ID().getText();

        if (currentThread.getLastLocalScope().containsKey(var_name)) {
            System.out.println("Error: variable " + var_name + " already declared");
            System.exit(1);
        }
        if (globalScope.containsKey(var_name)) {
            System.out.println("Error: variable " + var_name + " already declared as global");
            System.exit(1);
        }
        currentThread.getLastLocalScope().put(var_name, 0);

        return null;

    }

    @Override public Object visitGlobalVarDecl(SmallConcurrencyGrammarParser.GlobalVarDeclContext ctx) {

        System.out.println("Global variable declaration");
        String var_name = ctx.ID().getText();

        if (globalScope.containsKey(var_name)) {
            System.out.println("Error: variable " + var_name + " already declared");
            System.exit(1);
        }
        System.out.println("Global variable add " + var_name);
        globalScope.put(var_name, 0);

        return null;
    }



}
