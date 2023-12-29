package com.SmallConcurrency.cfg.elements.bool;

public abstract class BoolValueRepresentation extends BoolExpr{

    @Override
    public BoolValueRepresentation clone() throws CloneNotSupportedException {
        return (BoolValueRepresentation) super.clone();
    }
}
