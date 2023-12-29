package com.SmallConcurrency.cfg.graph;

import com.SmallConcurrency.cfg.elements.bool.BoolExpr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class IfElse extends Block {

    private BoolExpr condition;

    public IfElse( BoolExpr condition){

        this.condition = condition;
    }

    public IfElse(List<Block> children,  BoolExpr condition){
        super(children);
        this.condition = condition;
    }


    @Override
    public IfElse cloneBlock() {

        IfElse clone = null;
        try {
             clone = new IfElse(this.cloneChildren(), this.condition.clone());
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;

    }

}
