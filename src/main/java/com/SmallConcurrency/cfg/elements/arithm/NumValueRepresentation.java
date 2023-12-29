package com.SmallConcurrency.cfg.elements.arithm;

public abstract class NumValueRepresentation extends ArithmExp {

    @Override
    public NumValueRepresentation clone() throws CloneNotSupportedException {
        return (NumValueRepresentation) super.clone();
    }
}
