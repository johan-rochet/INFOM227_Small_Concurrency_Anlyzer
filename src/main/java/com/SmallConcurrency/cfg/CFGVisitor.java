package com.SmallConcurrency.cfg;

import com.SmallConcurrency.SmallConcurrencyGrammarBaseVisitor;
import com.SmallConcurrency.SmallConcurrencyGrammarParser;
import com.SmallConcurrency.cfg.elements.arithm.*;
import com.SmallConcurrency.cfg.elements.bool.*;
import com.SmallConcurrency.cfg.graph.*;
import com.SmallConcurrency.cfg.graph.Thread;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.SmallConcurrency.main.Utils.getIfAndElseBlock;
import static com.SmallConcurrency.main.Utils.getParserRuleContextFromParseTree;

public class CFGVisitor extends SmallConcurrencyGrammarBaseVisitor<Object> {

    private Map<String, Function> functions = new HashMap<>();


    private Block CFG ;
    private Block currentBlock = new EntryBlock();
    private EndBlock endBlock = new EndBlock();

    public Block getCFG() {
        return CFG;
    }

    public Map<String, Function> getFunctions() {
        return functions;
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
        if (list_result!= null && list_result.size() == 1){
            return list_result.get(0);
        }
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
        if (nextResult instanceof List) {
            result.addAll((List<Object>) nextResult);
        }
        else
        {
            result.add(nextResult);
        }

        return result ;

    }
    @Override
    public Object visitRoot(SmallConcurrencyGrammarParser.RootContext ctx) {


        CFG = currentBlock;
        visitChildren(ctx);
        currentBlock.addChild(endBlock);
        System.out.println(CFG);

        return CFG;

    }

    @Override
    public Object visitOp(SmallConcurrencyGrammarParser.OpContext ctx) {
        switch ((ctx.children.get(0).toString())) {
            case "+":
                return Op.PLUS;
            case "-":
                return Op.MINUS;
            case "*":
                return Op.MULTIPLY;
            case "/":
                return Op.SLASH;

            default:
                return null;
        }
    }

    @Override
    public Object visitBop(SmallConcurrencyGrammarParser.BopContext ctx) {
        switch ((ctx.children.get(0).toString())) {
            case "==":
                return BOp.EQUAL;
            case "!=":
                return BOp.DIFFERENT;
            case ">":
                return BOp.GREATER;
            case "<":
                return BOp.LESS;
            case ">=":
                return BOp.GREATER_EQUAL;
            case "<=":
                return BOp.LESS_EQUAL;
            default:
                return null;
        }
    }

    @Override
    public Object visitRop(SmallConcurrencyGrammarParser.RopContext ctx) {
        switch ((ctx.children.get(0).toString())) {
            case "&&":
                return ROp.AND;
            case "||":
                return ROp.OR;
            default:
                return null;
        }
    }

    @Override
    public Object visitNOprnd(SmallConcurrencyGrammarParser.NOprndContext ctx) {
        if (ctx.ID() != null){
            return new Variable(ctx.ID().getText());
        }
        return new Num(Integer.parseInt(ctx.NUM().getText()));
    }

    @Override
    public Object visitBOprnd(SmallConcurrencyGrammarParser.BOprndContext ctx) {

        if (ctx.TRUE() != null) {
            return new True();
        }
        if (ctx.FALSE() != null) {
            return new False();
        }

        List<Object> children = (List<Object>) visitChildren(ctx);

        if (children.get(0) instanceof Variable) {
            if (children.get(2) instanceof Variable)
                return new BoolOp((Variable) children.get(0), (Variable) children.get(2), (BOp) children.get(1));
            else
                return new BoolOp((Variable) children.get(0), (Num) children.get(2), (BOp) children.get(1));

        }
        if (children.get(2) instanceof Variable)
            return new BoolOp((Variable) children.get(0), (Variable) children.get(2), (BOp) children.get(1));

        return new BoolOp((Variable) children.get(0), (Num) children.get(2), (BOp) children.get(1));

    }

    @Override
    public Object visitBinOP(SmallConcurrencyGrammarParser.BinOPContext ctx) {
        List<Object> children = (List<Object>) visitChildren(ctx);

        if (children.get(0) instanceof Variable) {
            if (children.get(2) instanceof Variable)
                return new BinOp((Variable) children.get(0), (Variable) children.get(2), (Op) children.get(1));
            else
                return new BinOp((Variable) children.get(0), (Num) children.get(2), (Op) children.get(1));

        }
        if (children.get(2) instanceof Variable)
            return new BinOp((Variable) children.get(0), (Variable) children.get(2), (Op) children.get(1));

        return new BinOp((Variable) children.get(0), (Num) children.get(2), (Op) children.get(1));

    }

    @Override
    public Object visitRelOp(SmallConcurrencyGrammarParser.RelOpContext ctx) {

        List<Object> children = (List<Object>) visitChildren(ctx);

        if (children.get(0) instanceof True ) {
            if (children.get(2) instanceof True)
                return new RelOp((True) children.get(0), (True) children.get(2), (ROp) children.get(1));
            else if (children.get(2) instanceof False)
                return new RelOp((True) children.get(0), (False) children.get(2), (ROp) children.get(1));
            else
                return new RelOp((True) children.get(0), (BoolOp) children.get(2), (ROp) children.get(1));
        }
        if (children.get(0) instanceof False ) {
            if (children.get(2) instanceof True)
                return new RelOp((False) children.get(0), (True) children.get(2), (ROp) children.get(1));
            else if (children.get(2) instanceof False)
                return new RelOp((False) children.get(0), (False) children.get(2), (ROp) children.get(1));
            else
                return new RelOp((False) children.get(0), (BoolOp) children.get(2), (ROp) children.get(1));
        }
        if (children.get(2) instanceof True)
            return new RelOp((BoolOp) children.get(0), (True) children.get(2), (ROp) children.get(1));
        if (children.get(2) instanceof False)
            return new RelOp((BoolOp) children.get(0), (False) children.get(2), (ROp) children.get(1));
        return new RelOp((BoolOp) children.get(0), (BoolOp) children.get(2), (ROp) children.get(1));

    }

    @Override
    public Object visitArithmExp(SmallConcurrencyGrammarParser.ArithmExpContext ctx) {
        return super.visitArithmExp(ctx);
    }

    @Override
    public Object visitBoolExp(SmallConcurrencyGrammarParser.BoolExpContext ctx) {
        return super.visitBoolExp(ctx);
    }

    @Override
    public Object visitExpr(SmallConcurrencyGrammarParser.ExprContext ctx) {
        return super.visitExpr(ctx);
    }

    @Override
    public Object visitReturnStatement(SmallConcurrencyGrammarParser.ReturnStatementContext ctx) {

        ArithmExp arithm_exp = (ArithmExp) visitArithmExp(ctx.arithmExp());
        Return returnBlock = null;
        if (arithm_exp instanceof Num) {
            Num num = (Num) arithm_exp;
            returnBlock = new Return(num, ctx.getStart().getLine());
        }
        else if (arithm_exp instanceof Variable){
            Variable variable = (Variable) arithm_exp;
            returnBlock = new Return(variable, ctx.getStart().getLine());
        }
        else {
            BinOp binOp = (BinOp) arithm_exp;
            returnBlock = new Return(binOp, ctx.getStart().getLine());
        }

        currentBlock.addChild(returnBlock);
        currentBlock = returnBlock;
        return null;
    }

    @Override
    public Object visitExprList(SmallConcurrencyGrammarParser.ExprListContext ctx) {
        return super.visitExprList(ctx);
    }

    @Override
    public Object visitFuncCall(SmallConcurrencyGrammarParser.FuncCallContext ctx) {

        String functionName = ctx.ID().getText();
        Function functionCalled = null;
        for (Function function : functions.values()) {
            if (function.getName().equals(functionName)) {
                functionCalled = function;
                break;

            }
        }
        List<ArithmExp> args = new ArrayList<ArithmExp>();
        if (ctx.exprList() != null) {
            args = (List<ArithmExp>) visitExprList(ctx.exprList());
        }

        Function functionClone= (Function) functionCalled.cloneBlock();
        functionClone.setArgs(args);
        return functionClone;

    }

    @Override
    public Object visitAssignStatement(SmallConcurrencyGrammarParser.AssignStatementContext ctx) {
        Variable variable= new Variable(ctx.ID().getText());


        ArithmExp arithm_exp = null;
        if (ctx.arithmExp() != null) {
            arithm_exp = (ArithmExp) visitArithmExp(ctx.arithmExp());
            Assignment assignment = new Assignment(variable, arithm_exp, ctx.getStart().getLine());

            currentBlock.addChild(assignment);
            currentBlock = assignment;

        }
        else {
            Function function = (Function) visitFuncCall(ctx.funcCall());
            FuncCallAssignment funcCallAssignment = new FuncCallAssignment(variable, function, ctx.getStart().getLine());

            currentBlock.addChild(funcCallAssignment);
            currentBlock = funcCallAssignment.getLastBlock();
        }


        return null;



    }

    @Override
    public Object visitStatement(SmallConcurrencyGrammarParser.StatementContext ctx) {
        return super.visitStatement(ctx);
    }

    @Override
    public Object visitIfStatement(SmallConcurrencyGrammarParser.IfStatementContext ctx) {

        BoolExpr boolExpr = (BoolExpr) visitBoolExp(ctx.boolExp());

        List<ParseTree> children = getIfAndElseBlock(ctx.children);
        ParseTree block1 = children.get(0);
        ParseTree block2 = children.get(1);

        IfElse ifElse = new IfElse(boolExpr, ctx.getStart().getLine());
        ifElse.setLine(ctx.getStart().getLine());
        currentBlock.addChild(ifElse);
        currentBlock = ifElse;
        block1.accept(this);

        currentBlock = ifElse;
        block2.accept(this);


        EndIf endIfBlock = new EndIf();
        ifElse.setEndIf(endIfBlock);

        currentBlock = endIfBlock;

        return null;
    }

    @Override
    public Object visitWhileStatement(SmallConcurrencyGrammarParser.WhileStatementContext ctx) {

            BoolExpr boolExpr = (BoolExpr) visitBoolExp(ctx.boolExp());

            While whileBlock = new While(boolExpr, ctx.getStart().getLine());
            whileBlock.setLine(ctx.getStart().getLine());
            currentBlock.addChild(whileBlock);

            currentBlock = whileBlock;
            if (ctx.sequence() != null) {
                ctx.sequence().accept(this);
            }
            else {
                ctx.statement().accept(this);
            }
            EndWhile endWhileBlock = new EndWhile();
            whileBlock.setEndWhile(endWhileBlock);
            currentBlock = endWhileBlock;

            return null;
    }

    @Override
    public Object visitSequence(SmallConcurrencyGrammarParser.SequenceContext ctx) {
        return super.visitSequence(ctx);
    }

    @Override
    public Object visitParamList(SmallConcurrencyGrammarParser.ParamListContext ctx) {
        List<Variable> result = new ArrayList<Variable>();

        Variable variable = new Variable(ctx.ID().getText());
        result.add(variable) ;
        if (getParserRuleContextFromParseTree(ctx.children).size() == 0) {
            return result;
        }
        result.addAll((List<Variable>)visitParamList(ctx.paramList()));

        return result;
    }

    @Override
    public Object visitFuncDef(SmallConcurrencyGrammarParser.FuncDefContext ctx) {

        String functionName = ctx.ID().getText();

        List<Variable> functionParameters = new ArrayList<Variable>();
        if (ctx.paramList() != null ) {

            functionParameters = (List<Variable>)visitParamList(ctx.paramList());
        }

        Function functionBlock = new Function(functionName, functionParameters, ctx.getStart().getLine());
        functionBlock.setLine(ctx.getStart().getLine());
        functions.put(functionName, functionBlock);
        Block previousBlock = currentBlock;
        currentBlock = functionBlock;
        ctx.sequence().accept(this);
        currentBlock.addChild(new EndFunction());

        if ((ctx.ID().getText().equals("main"))) {
            Function functionClone= (Function) functionBlock.cloneBlock();
            previousBlock.addChild(functionClone);
            currentBlock = functionClone.getLastBlock();
        }
        else {
            currentBlock = previousBlock;
        }

        return null;





    }

    @Override
    public Object visitVarDecl(SmallConcurrencyGrammarParser.VarDeclContext ctx) {
        Variable variable = new Variable(ctx.ID().getText());
        VarDecl varDecl = new VarDecl(variable, ctx.getStart().getLine());
        currentBlock.addChild(varDecl);
        currentBlock = varDecl;
        return null;
    }

    @Override
    public Object visitGlobalVarDecl(SmallConcurrencyGrammarParser.GlobalVarDeclContext ctx) {

        Variable variable = new Variable(ctx.ID().getText());
        GlobalVarDecl globalVarDecl = new GlobalVarDecl(variable, ctx.getStart().getLine());
        currentBlock.addChild(globalVarDecl);
        currentBlock = globalVarDecl;
        return null;

    }

    @Override
    public Object visitThreadDecl(SmallConcurrencyGrammarParser.ThreadDeclContext ctx) {

            Thread thread = new Thread(ctx.getStart().getLine());
            currentBlock.addChild(thread);
            currentBlock = thread;



            ctx.sequence().accept(this);
            EndThread endThread = new EndThread();
            currentBlock.addChild(endThread);
            currentBlock = endThread;

            return null;

    }

    @Override
    public Object visitLockVarDecl(SmallConcurrencyGrammarParser.LockVarDeclContext ctx) {

        Variable variable = new Variable(ctx.ID().getText());
        LockVarDecl lockVarDecl = new LockVarDecl(variable, ctx.getStart().getLine());
        currentBlock.addChild(lockVarDecl);
        currentBlock = lockVarDecl;
        return null;

    }

    @Override
    public Object visitUnlockVarDecl(SmallConcurrencyGrammarParser.UnlockVarDeclContext ctx) {

            Variable variable = new Variable(ctx.ID().getText());
            UnlockVarDecl unlockVarDecl = new UnlockVarDecl(variable, ctx.getStart().getLine());
            currentBlock.addChild(unlockVarDecl);
            currentBlock = unlockVarDecl;
            return null;
    }
}
