package com.SmallConcurrency.cfg.graph;

import com.SmallConcurrency.cfg.elements.bool.BoolExpr;

import java.util.Arrays;
import java.util.List;

public class WhileStatement extends Block{

    private BoolExpr condition;

    public WhileStatement(Block trueChild, Block falseChild,  BoolExpr condition){
       super(Arrays.asList(trueChild, falseChild));
         this.condition = condition;
    }

    public WhileStatement(List<Block> children,  BoolExpr condition){
        super(children);
        this.condition = condition;
    }

    @Override
    public WhileStatement cloneBlock() {
        WhileStatement clone = null;
        try {
             clone = new WhileStatement(this.cloneChildren(), this.condition.clone());
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;

    }

}
