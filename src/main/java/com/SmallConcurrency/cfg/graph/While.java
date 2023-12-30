package com.SmallConcurrency.cfg.graph;

import com.SmallConcurrency.cfg.elements.bool.BoolExpr;

import java.util.Arrays;
import java.util.List;

public class While extends Block{

    private BoolExpr condition;
    private EndWhile endWhile;

    public While( BoolExpr condition){

        this.condition = condition;
    }

    public While(List<Block> children, BoolExpr condition, EndWhile endWhile){
        super(children);
        this.condition = condition;
        this.endWhile = endWhile;
    }

    public void setEndWhile(EndWhile endWhile) {
        this.endWhile = endWhile;
    }

    @Override
    public While cloneBlock() {
        While clone = null;
        try {
             clone = new While(this.cloneChildren(), this.condition.clone(), this.endWhile.cloneBlock());
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

        result += endWhile.toString();

        return result;
    }

    @Override
    public Block getLastBlock(){
        if (this.endWhile == null){
            return this;
        }
        else{
            return this.endWhile.getLastBlock();
        }
    }

}
