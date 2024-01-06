package com.SmallConcurrency.semantic;

import com.SmallConcurrency.SmallConcurrencyGrammarBaseVisitor;
import com.SmallConcurrency.SmallConcurrencyGrammarParser;
import org.antlr.v4.runtime.ParserRuleContext;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.SmallConcurrency.main.Utils.getIfAndElseBlock;
import static com.SmallConcurrency.main.Utils.getParserRuleContextFromParseTree;


public class SemanticVisitor extends SmallConcurrencyGrammarBaseVisitor<Object> {

    private static final Logger logger = LogManager.getLogger(SemanticVisitor.class);

    private Map<String, Integer> globalScope;
    private List<Thread> threads;
    private Thread currentThread;
    private List<String> all_locked_variables;
    private List<FunctionInfo> functions;

    private static final String KO = "KO";
    public SemanticVisitor() {
        super();
        globalScope = new HashMap<String, Integer>();
        threads = new ArrayList<Thread>();
        currentThread = null;
        all_locked_variables = new ArrayList<String>();
        functions = new ArrayList<FunctionInfo>();
    }

    private void printInfo () {

        System.out.println("Global variables: ");
        for (Map.Entry<String, Integer> entry : globalScope.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("Threads: ");
        for (Thread thread : threads) {
            System.out.println("Thread instructions: ");
            for (List<ParserRuleContext> instructions : thread.getInstructions_set()) {
                System.out.println(instructions);
            }
            System.out.println("Thread local scopes: ");
            for (Map<String, Integer> local_scope : thread.getLocal_scopes()) {

                for (Map.Entry<String, Integer> entry : local_scope.entrySet()) {
                    System.out.println(entry.getKey() + " : " + entry.getValue());
                }
            }
            System.out.println("Thread locked variables: ");
            for (String locked_variable : thread.getLocked_variables()) {
                System.out.println(locked_variable);
            }
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

    public Object mutliThreading() {


        if (currentThread.getLastInstructionsSet().size() != 0) {
            threads.add(currentThread);
        }
        else if (!(currentThread.getLocked_variables().isEmpty()))
        {
            logger.error("Error: thread does not unlock all the variables");
            System.exit(1);
        }


        // Randomy choose a thread
        if (threads.size() == 0) {
            return null;
        }

        Random random = new Random();
        int random_index = random.nextInt(threads.size());
        currentThread = threads.remove(random_index);


        // If the thread is empty, remove it
        if (currentThread.getInstructions_set().size() == 0) {

            currentThread = null;

        }
        else {
            List<ParserRuleContext> instructionsSet = currentThread.getLastInstructionsSet();

            ParserRuleContext instruction = instructionsSet.remove(0);

            instruction.accept(this);
        }

        return null;
    }

    @Override
    public Object visitRoot(SmallConcurrencyGrammarParser.RootContext ctx) {

        List<ParserRuleContext>instructions = getParserRuleContextFromParseTree(ctx.children);


        List<List<ParserRuleContext>> instructions_set = new ArrayList<List<ParserRuleContext>>();
        instructions_set.add(instructions);

        List<Map<String, Integer>> local_scopes = new ArrayList<Map<String, Integer>>();
        local_scopes.add(new HashMap<String, Integer>());

        List<String> locked_variables = new ArrayList<String>();

        currentThread = new Thread(instructions_set, local_scopes, locked_variables);

        mutliThreading();

        return null;

    }

    @Override
    public Object visitOp(SmallConcurrencyGrammarParser.OpContext ctx) {
        switch ((ctx.children.get(0).toString())) {
            case "+":
                return SmallConcurrencyGrammarParser.PLUS;
            case "-":
                return SmallConcurrencyGrammarParser.MINUS;
            case "*":
                return SmallConcurrencyGrammarParser.MULTIPLY;
            case "/":
                return SmallConcurrencyGrammarParser.SLASH;

            default:
                return null;
        }
    }

    @Override
    public Object visitBop(SmallConcurrencyGrammarParser.BopContext ctx) {
        switch ((ctx.children.get(0).toString())) {
            case "==":
                return SmallConcurrencyGrammarParser.EQUAL;
            case "!=":
                return SmallConcurrencyGrammarParser.DIFFERENT;
            case ">":
                return SmallConcurrencyGrammarParser.GREATER;
            case ">=":
                return SmallConcurrencyGrammarParser.GREATER_EQUAL;
            case "<":
                return SmallConcurrencyGrammarParser.LESS;
            case "<=":
                return SmallConcurrencyGrammarParser.LESS_EQUAL;
            default:
                return null;
        }
    }
    @Override
    public Object visitRop(SmallConcurrencyGrammarParser.RopContext ctx) {
        switch ((ctx.children.get(0).toString())) {
            case "&&":
                return SmallConcurrencyGrammarParser.AND;
            case "||":
                return SmallConcurrencyGrammarParser.OR;
            default:
                return null;
        }
    }

    @Override
    public Object visitNOprnd(SmallConcurrencyGrammarParser.NOprndContext ctx) {

        if (ctx.ID() != null){
            String var_name = ctx.ID().getText();

            if (currentThread.getLastLocalScope().containsKey(var_name)) {
                return currentThread.getLastLocalScope().get(var_name);
            }
            else if ( globalScope.containsKey(var_name) ) {
                if (all_locked_variables.contains(var_name) && !currentThread.getLocked_variables().contains(var_name)) {
                    return KO;
                }
                return globalScope.get(var_name);
            }
            else {
                logger.error("Error: variable " + var_name + " not declared");
                System.exit(1);
            }
        }
        return Integer.parseInt(ctx.NUM().getText());



    }

    @Override
    public Object visitBOprnd(SmallConcurrencyGrammarParser.BOprndContext ctx) {
        if (ctx.TRUE() != null) {
            return true;
        }
        if (ctx.FALSE() != null) {
            return false;
        }
        else {
            List<Object> children = (List<Object>) visitChildren(ctx);
            if (children.get(0).equals(KO) || children.get(2).equals(KO)) {
                return KO;
            }

            switch ((Integer) children.get(1)) {
                case SmallConcurrencyGrammarParser.EQUAL:
                    return (int)children.get(0) == (int)children.get(2);
                case SmallConcurrencyGrammarParser.DIFFERENT:
                    return (int)children.get(0) != (int)children.get(2);
                case SmallConcurrencyGrammarParser.GREATER:
                    return (int)children.get(0) > (int)children.get(2);
                case SmallConcurrencyGrammarParser.GREATER_EQUAL:
                    return (int)children.get(0) >= (int)children.get(2);
                case SmallConcurrencyGrammarParser.LESS:
                    return (int)children.get(0) < (int)children.get(2);
                case SmallConcurrencyGrammarParser.LESS_EQUAL:
                    return (int)children.get(0) <= (int)children.get(2);
                default:
                    return null;
            }
        }
    }

    @Override
    public Object visitBinOP(SmallConcurrencyGrammarParser.BinOPContext ctx) {
        List<Object> children = (List<Object>) visitChildren(ctx);

        if (children.get(0).equals(KO) || children.get(2).equals(KO)) {
            return KO;
        }
        switch ((Integer) children.get(1)) {
            case SmallConcurrencyGrammarParser.PLUS:
                return (int)children.get(0) + (int)children.get(2);
            case SmallConcurrencyGrammarParser.MINUS:
                return (int)children.get(0) - (int)children.get(2);
            case SmallConcurrencyGrammarParser.MULTIPLY:
                return (int)children.get(0) * (int)children.get(2);
            case SmallConcurrencyGrammarParser.SLASH:
                return (int)children.get(0) / (int)children.get(2);
            default:
                return null;
        }

    }

    @Override
    public Object visitRelOp(SmallConcurrencyGrammarParser.RelOpContext ctx) {
        List<Object> children = (List<Object>) visitChildren(ctx);

        if (children.get(0).equals(KO) || children.get(2).equals(KO)) {
            return KO;
        }

        switch ((Integer) children.get(1)) {
            case SmallConcurrencyGrammarParser.AND :
                return (boolean)children.get(0) && (boolean)children.get(2);
            case SmallConcurrencyGrammarParser.OR :
                return (boolean)children.get(0) || (boolean)children.get(2);
            default:
                return null;
        }

    }

    @Override
    public Object visitArithmExp(SmallConcurrencyGrammarParser.ArithmExpContext ctx) {
        return visitChildren(ctx);
    }


    @Override
    public Object visitReturnStatement(SmallConcurrencyGrammarParser.ReturnStatementContext ctx) {

        Integer value = (Integer) ctx.arithmExp().accept(this);
        if (value.equals(KO)) {
            currentThread.addToLastInstructionsSet(ctx);
        }
        else {
            if (currentThread.getInstructions_set().size() == 1) {
                logger.error("Error: return statement in main");
                System.exit(1);
            }
            currentThread.getLocal_scopes().remove(currentThread.getLocal_scopes().size() - 1);
            currentThread.getInstructions_set().remove(currentThread.getInstructions_set().size() - 1);
            currentThread.getLastLocalScope().put(currentThread.popReturnIntoVariable(), value);
        }

        mutliThreading();

        return null;

    }




    @Override
    public Object visitFuncCall(SmallConcurrencyGrammarParser.FuncCallContext ctx) {
                String func_name = ctx.ID().getText();
        FunctionInfo currentFunction = null;
        for (FunctionInfo function : functions) {
            if (function.getName().equals(func_name)) {
                currentFunction = function;
                break;
            }
        }

        if (currentFunction == null) {
            logger.error("Error: function " + func_name + " not declared");
            System.exit(1);
        }

        // Check the parameters number
        List<Object> functionParameters = new ArrayList<Object>();

        if (ctx.exprList() != null ) {
            functionParameters = (List<Object>)ctx.exprList().accept(this);
        }

        if (functionParameters.size() != currentFunction.getParameters().size()) {
            logger.error("Error: function " + func_name + " called with wrong number of parameters");
            System.exit(1);
        }




        Boolean locked = false;
        for (Object parameter : functionParameters) {

            if (parameter.toString().equals(KO)) {

                currentThread.addToLastInstructionsSet(ctx);
                locked = true;
                break;
            }
        }

        if(!locked) {
            // Add the parameters to the local scope
            Map<String, Integer> local_scope = new HashMap<String, Integer>();
            for (int i = 0; i < functionParameters.size(); i++) {
                local_scope.put(currentFunction.getParameters().get(i), Integer.parseInt(functionParameters.get(i).toString()));
            }
            currentThread.getLocal_scopes().add(local_scope);

            // Add the instructions to the thread
            List<ParserRuleContext> instructions = getParserRuleContextFromParseTree(currentFunction.getInstructions_set().children);
            currentThread.getInstructions_set().add(instructions);

        }

        mutliThreading();

        return null;

    }

    @Override
    public Object visitAssignStatement(SmallConcurrencyGrammarParser.AssignStatementContext ctx) {
        String var_name = ctx.ID().getText();

        if (ctx.arithmExp() != null) {
            Integer value = (Integer) ctx.arithmExp().accept(this);
            if (value.equals(KO)) {
                currentThread.addToLastInstructionsSet(ctx);
            }

            else {

                if (currentThread.getLastLocalScope().containsKey(var_name)) {

                    currentThread.getLastLocalScope().put(var_name, value);
                } else if (globalScope.containsKey(var_name)) {

                    if (all_locked_variables.contains(var_name) && !currentThread.getLocked_variables().contains(var_name)) {
                        currentThread.addToLastInstructionsSet(ctx);
                    } else {
                        globalScope.put(var_name, value);
                    }

                } else {
                    logger.error("Error: variable " + var_name + " not declared");
                    System.exit(1);

                }
            }

            mutliThreading();
        }
        else {

            if ((currentThread.getLastLocalScope().containsKey(var_name) || globalScope.containsKey(var_name)))  {
                currentThread.addReturnIntoVariable(var_name);
                currentThread.addToLastInstructionsSet(ctx.funcCall());
            }
            else {
                logger.error("Error: variable " + var_name + " not declared");
                System.exit(1);
            }

            mutliThreading();

        }
        return null;
    }

    @Override
    public Object visitStatement(SmallConcurrencyGrammarParser.StatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitIfStatement(SmallConcurrencyGrammarParser.IfStatementContext ctx) {
        Object condition = ctx.boolExp().accept(this);
        if (condition.equals(KO)) {
            currentThread.addToLastInstructionsSet(ctx);
        }
        else if (
                ! (condition instanceof Boolean)
        ) {
            logger.error("Error: condition must be a boolean");
            System.exit(1);
        }


        else {
            List<ParseTree> children = getIfAndElseBlock(ctx.children);
            ParseTree block1 = children.get(0);
            ParseTree block2 = children.get(1);


            List<ParserRuleContext> instructions = new ArrayList<>() ;

            if ((Boolean) condition) {

                if (block1 instanceof SmallConcurrencyGrammarParser.SequenceContext) {
                    instructions = getParserRuleContextFromParseTree(ctx.sequence(0).children);
                    currentThread.addToLastInstructionsSet(instructions);
                }
                else {
                    instructions.add(ctx.statement(0));
                    currentThread.addToLastInstructionsSet(instructions);
                }

            }
            else {
                if (block2 instanceof SmallConcurrencyGrammarParser.SequenceContext) {
                    instructions = getParserRuleContextFromParseTree(ctx.sequence().get(ctx.sequence().size()-1) .children);
                    currentThread.addToLastInstructionsSet(instructions);
                }
                else {
                    instructions.add(ctx.statement().get(ctx.statement().size()-1));
                    currentThread.addToLastInstructionsSet(instructions);
                }
            }
        }

        mutliThreading();

        return null;
    }

    @Override
    public Object visitWhileStatement(SmallConcurrencyGrammarParser.WhileStatementContext ctx) {


        Object condition = (Boolean) ctx.boolExp().accept(this);
        if (condition.equals(KO)) {
            currentThread.addToLastInstructionsSet(ctx);
        }
        else {
            if ((Boolean) condition) {
                List<ParserRuleContext> instructions = new ArrayList<>() ;
                if (ctx.sequence() != null) {
                    instructions = getParserRuleContextFromParseTree(ctx.sequence().children);
                }
                else {
                    instructions.add(ctx.statement());
                }
                currentThread.addToLastInstructionsSet(ctx);
                currentThread.addToLastInstructionsSet(instructions);


            }

        }



        mutliThreading();

        return null;
    }

    @Override
    public Object visitSequence(SmallConcurrencyGrammarParser.SequenceContext ctx) {

        List<ParserRuleContext> instructions = getParserRuleContextFromParseTree(ctx.children);
        ParserRuleContext instruction = instructions.remove(0);
        instruction.accept(this);
        currentThread.addToLastInstructionsSet(instructions);
        return visitChildren(ctx);
    }

    @Override
    public Object visitParamList(SmallConcurrencyGrammarParser.ParamListContext ctx) {
        List<String> result = new ArrayList<String>();

        result.add(ctx.ID().getText()) ;
        if (getParserRuleContextFromParseTree(ctx.children).size() == 0) {
            return result;
        }
        result.addAll((List<String>)visitParamList(ctx.paramList()));

        return result;
    }

    @Override
    public Object visitFuncDef(SmallConcurrencyGrammarParser.FuncDefContext ctx) {

        String func_name = ctx.ID().getText();

        for (FunctionInfo function : functions) {
            if (function.getName().equals(func_name)) {
                logger.error("Error: function " + func_name + " already declared");
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
            List<ParserRuleContext> instructions = getParserRuleContextFromParseTree(ctx.sequence().children);
            currentThread.addToLastInstructionsSet(instructions);
        }
        mutliThreading();
        return null;
    }

    @Override
    public Object visitVarDecl(SmallConcurrencyGrammarParser.VarDeclContext ctx) {

        String var_name = ctx.ID().getText();

        if (currentThread.getLastLocalScope().containsKey(var_name)) {
            logger.error("Error: variable " + var_name + " already declared");
            System.exit(1);
        }
        if (globalScope.containsKey(var_name)) {
            logger.error("Error: variable " + var_name + " already declared as global");
            System.exit(1);
        }
        currentThread.getLastLocalScope().put(var_name, 0);

        mutliThreading();
        return null;

    }

    @Override public Object visitGlobalVarDecl(SmallConcurrencyGrammarParser.GlobalVarDeclContext ctx) {


        String var_name = ctx.ID().getText();

        if (globalScope.containsKey(var_name)) {
            logger.error("Error: variable " + var_name + " already declared");
            System.exit(1);
        }

        globalScope.put(var_name, 0);

        mutliThreading();
        return null;
    }

    @Override
    public Object visitThreadDecl(SmallConcurrencyGrammarParser.ThreadDeclContext ctx) {

        List<ParserRuleContext> instructions = getParserRuleContextFromParseTree(ctx.sequence().children);

        List<List<ParserRuleContext>> instructions_set = new ArrayList<List<ParserRuleContext>>();
        instructions_set.add(instructions);

        List<Map<String, Integer>> local_scopes = new ArrayList<Map<String, Integer>>();
        local_scopes.add(new HashMap<String, Integer>());

        List<String> locked_variables = new ArrayList<String>();
        if (currentThread.getLastInstructionsSet().size() != 0) {
            threads.add(currentThread);
        }
        currentThread = new Thread(instructions_set, local_scopes, locked_variables);

        mutliThreading();

        return null;
    }

    @Override
    public Object visitLockVarDecl(SmallConcurrencyGrammarParser.LockVarDeclContext ctx) {

        String var_name = ctx.ID().getText();

        if (globalScope.containsKey(var_name)) {
            if (all_locked_variables.contains(var_name)) {
                currentThread.addToLastInstructionsSet(ctx);
            }
            all_locked_variables.add(var_name);
            currentThread.getLocked_variables().add(var_name);
        }
        else if (currentThread.getLastLocalScope().containsKey(var_name)) {
            logger.error("Error: local variable " + var_name + " cannot be locked");
        }
        else {
            logger.error("Error: variable " + var_name + " not declared");
            System.exit(1);
        }

        mutliThreading();
        return null;
    }

    @Override
    public Object visitUnlockVarDecl(SmallConcurrencyGrammarParser.UnlockVarDeclContext ctx) {

            String var_name = ctx.ID().getText();

            if (globalScope.containsKey(var_name)) {
                if (!all_locked_variables.contains(var_name)) {
                    logger.error("Error: variable " + var_name + " not locked");
                    System.exit(1);
                }
                if (!currentThread.getLocked_variables().contains(var_name)) {
                    logger.error("Error: variable " + var_name + " not locked in this thread");
                    System.exit(1);
                }
                all_locked_variables.remove(var_name);
                currentThread.getLocked_variables().remove(var_name);
            }
            else if (currentThread.getLastLocalScope().containsKey(var_name)) {
                logger.error("Error: local variable " + var_name + " cannot be unlocked");
            }
            else {
                logger.error("Error: variable " + var_name + " not declared");
                System.exit(1);
            }

            mutliThreading();
            return null;
    }
}
