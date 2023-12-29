package com.SmallConcurrency.cfg.elements.arithm;

public class Num extends    NumValueRepresentation{

    private int value ;

    public Num(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public Num clone() throws CloneNotSupportedException {
        return (Num) super.clone();
    }
}
