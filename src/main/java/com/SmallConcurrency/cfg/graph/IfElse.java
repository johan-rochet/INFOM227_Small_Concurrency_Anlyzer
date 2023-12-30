package com.SmallConcurrency.cfg.graph;

import com.SmallConcurrency.cfg.elements.bool.BoolExpr;
import com.SmallConcurrency.staticAnalysis.StaticAnalysisVisitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class IfElse extends Block {

    private BoolExpr condition;
    private EndIf endIf = null;

    public IfElse( BoolExpr condition){

        this.condition = condition;
    }

    public IfElse(List<Block> children,  BoolExpr condition, EndIf endIf){
        super(children);
        this.condition = condition;
        this.endIf = endIf;
    }

    public BoolExpr getCondition() {
        return condition;
    }

    public EndIf getEndIf() {
        return endIf;
    }

    public void setEndIf(EndIf endIf) {
        this.endIf = endIf;
    }

    @Override
    public IfElse cloneBlock() {

        IfElse clone = null;
        try {
             clone = new IfElse(this.cloneChildren(), this.condition.clone(), this.endIf.cloneBlock());
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;

    }

    @Override
    public String toString(){
        String result = this.getClass() + "\n";

        for (Block child : children) {
            result += child.toString();

        }

        result += endIf.toString();

        return result;
    }

    @Override
    public Block getLastBlock(){
        if (this.endIf == null){
            return this;
        }
        else{
            return this.endIf.getLastBlock();
        }

    }

}
