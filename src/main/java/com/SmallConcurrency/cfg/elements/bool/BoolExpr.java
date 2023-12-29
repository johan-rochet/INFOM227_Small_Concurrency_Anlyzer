package com.SmallConcurrency.cfg.elements.bool;

public abstract class BoolExpr implements Cloneable {

    @Override
    public BoolExpr clone() throws CloneNotSupportedException {
        return (BoolExpr) super.clone();
    }

}
