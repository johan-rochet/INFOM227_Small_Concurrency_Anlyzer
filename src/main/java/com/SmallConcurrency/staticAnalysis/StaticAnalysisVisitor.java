package com.SmallConcurrency.staticAnalysis;

import com.SmallConcurrency.cfg.elements.arithm.ArithmExp;
import com.SmallConcurrency.cfg.elements.arithm.BinOp;
import com.SmallConcurrency.cfg.elements.arithm.NumValueRepresentation;
import com.SmallConcurrency.cfg.elements.arithm.Variable;
import com.SmallConcurrency.cfg.elements.bool.*;
import com.SmallConcurrency.cfg.graph.*;
import com.SmallConcurrency.cfg.graph.Thread;

import java.util.*;

public class StaticAnalysisVisitor {

    private Map<String , AbstractValues> globalVarValues = new HashMap<>();

    private List<String> lockVarValues = new ArrayList<>();
    private Boolean noConcurrentThread = true;


    public StaticAnalysisVisitor() {
    }
    public StaticAnalysisVisitor(Set<String> globalVarValues) {
        this.noConcurrentThread = false;
        for (String globalVarValue : globalVarValues) {
            this.globalVarValues.put(globalVarValue, AbstractValues.NA);
        }
    }

    public Map<String, AbstractValues> getGlobalVarValues() {
        return globalVarValues;
    }

    public void readGlobalVarValues(String varName) {
        if (lockVarValues.contains(varName)) {
            return;
        }
        if (globalVarValues.containsKey(varName)) {
            if (globalVarValues.get(varName) == AbstractValues.WA) {
                globalVarValues.put(varName, AbstractValues.WRA);
            }
            else if (globalVarValues.get(varName) == AbstractValues.NA) {
                globalVarValues.put(varName, AbstractValues.RA);
            }

        }
    }

    public void writeGlobalVarValues(String varName) {

        if (lockVarValues.contains(varName)) {
            return;
        }
        if (globalVarValues.containsKey(varName)) {
            if (globalVarValues.get(varName) == AbstractValues.RA) {
                globalVarValues.put(varName, AbstractValues.WRA);
            }
            else if (globalVarValues.get(varName) == AbstractValues.NA) {
                globalVarValues.put(varName, AbstractValues.WA);
            }

        }
    }

    public void checkCondition(BoolExpr condition) {

        System.out.println("Hello");
        if (!(condition instanceof True || condition instanceof False)) {

            if (condition instanceof BoolOp) {

                checkForVariableInBoolOp((BoolOp) condition);
            }

            else if (condition instanceof RelOp) {

                BoolValueRepresentation left = ((RelOp) condition).getLeft();

                BoolValueRepresentation right = ((RelOp) condition).getRight();

                if (left instanceof BoolOp) {
                    checkForVariableInBoolOp((BoolOp) left);
                }
                if (right instanceof BoolOp) {
                    checkForVariableInBoolOp((BoolOp) right);
                }
            }

        }
    }
    public void checkForVariableInBoolOp(BoolOp condition) {
        NumValueRepresentation left = ((BoolOp) condition).getLeft();
        NumValueRepresentation right = ((BoolOp) condition).getRight();

        if (left instanceof Variable) {
            readGlobalVarValues(((Variable) left).getName());
        }

        if (right instanceof Variable) {
            readGlobalVarValues(((Variable) right).getName());
        }

    }

    public void checkForVariableInArithmExp(ArithmExp arithmExp) {
        if (arithmExp instanceof Variable) {
            readGlobalVarValues(((Variable) arithmExp).getName());
        }
        else if (arithmExp instanceof BinOp) {
            ArithmExp left = ((BinOp) arithmExp).getLeft();
            ArithmExp right = ((BinOp) arithmExp).getRight();

            if (left instanceof Variable) {
                readGlobalVarValues(((Variable) left).getName());
            }
            if (right instanceof Variable) {
                readGlobalVarValues(((Variable) right).getName());
            }
        }
    }


    public void visit(Block block) {

        if (block instanceof Assignment) {
            visitAssignment((Assignment) block);
        }
        else if (block instanceof FuncCallAssignment) {
            visitFuncCallAssignment((FuncCallAssignment) block);
        }
        else if (block instanceof Function) {
            visitFunction((Function) block);
        }
        else if (block instanceof GlobalVarDecl) {
            visitGlobalVarDecl((GlobalVarDecl) block);
        }
        else if (block instanceof IfElse) {
            visitIfElse((IfElse) block);
        }
        else if (block instanceof LockVarDecl) {
            visitLockVarDecl((LockVarDecl) block);
        }
        else if (block instanceof Return) {
            visitReturn((Return) block);
        }
        else if (block instanceof Thread) {
            visitThread((Thread) block);
        }
        else if (block instanceof UnlockVarDecl) {
            visitUnlockVarDecl((UnlockVarDecl) block);
        }
        else if (block instanceof VarDecl) {
            visitVarDecl((VarDecl) block);
        }
        else if (block instanceof While) {
            visitWhile((While) block);
        }
        else if (block instanceof EndBlock) {
            visitEndBlock((EndBlock) block);
        }
        else if (block instanceof EndFunction) {
            visitEndFunction((EndFunction) block);
        }
        else if (block instanceof EndIf) {
            EndIf((EndIf) block);
        }
        else if (block instanceof EndWhile) {
            visitEndWhile((EndWhile) block);
        }
        else if (block instanceof EntryBlock) {
            visitEntryBlock((EntryBlock) block);
        }
    }

    public void visitChildren(Block block) {
        for (Block child : block.getChildren()) {
            child.accept(this);
        }
    }

    public void visitAssignment(Assignment assignment) {

        Variable variable = assignment.getVariable();

        ArithmExp arithmExp = assignment.getArithm_exp();

        checkForVariableInArithmExp(arithmExp);

        writeGlobalVarValues(variable.getName());

        visitChildren(assignment);
    }

    public void visitEndBlock(EndBlock block) {
        visitChildren(block);
    }

    public void visitEndFunction(EndFunction block) {
        visitChildren(block);
    }

    public void EndIf(EndIf block) {
        visitChildren(block);
    }

    public void visitEndWhile(EndWhile block) {
        visitChildren(block);
    }

    public void visitEntryBlock(EntryBlock block) {
        visitChildren(block);
    }

    public void visitFuncCallAssignment(FuncCallAssignment funcCallAssignment) {

        Variable variable = funcCallAssignment.getVariable();

        writeGlobalVarValues(variable.getName());

        visitChildren(funcCallAssignment);


    }
    public void visitFunction (Function function) {

        for( ArithmExp arg : function.getArgs()) {
            checkForVariableInArithmExp(arg);
        }

        visitChildren(function);
    }

    public void visitGlobalVarDecl(GlobalVarDecl globalVarDecl) {

        System.out.println(globalVarDecl.getVariable());
        if (noConcurrentThread) {
            globalVarValues.put(globalVarDecl.getVariable().getName(), AbstractValues.NA);
        }

        visitChildren(globalVarDecl);
    }

    public void visitIfElse(IfElse ifElse) {

            BoolExpr condition = ifElse.getCondition() ;

            checkCondition(condition);

            for (Block child : ifElse.getChildren()) {
                child.accept(this);
            }

        ifElse.getEndIf().accept(this);
    }

    public void visitLockVarDecl(LockVarDecl lockVarDecl) {
        this.lockVarValues.add(lockVarDecl.getVariable().getName());
        visitChildren(lockVarDecl);
    }

    public void visitReturn(Return returnBlock) {
        ArithmExp returnVar = returnBlock.getReturnVar() ;

        checkForVariableInArithmExp(returnVar);

        visitChildren(returnBlock);

    }

    public void visitThread(Thread thread) {
        this.noConcurrentThread = false;
        visitChildren(thread);
    }

    public void visitUnlockVarDecl(UnlockVarDecl unlockVarDecl) {
        this.lockVarValues.remove(unlockVarDecl.getVariable().getName());
        visitChildren(unlockVarDecl);

    }

    public void visitVarDecl(VarDecl block) {
        visitChildren(block);
    }

    public void visitWhile(While whileBlock) {

        BoolExpr condition = whileBlock.getCondition() ;

        checkCondition(condition);

        for (Block child : whileBlock.getChildren()) {
            child.accept(this);
        }

        whileBlock.getEndWhile().accept(this);




    }
}
