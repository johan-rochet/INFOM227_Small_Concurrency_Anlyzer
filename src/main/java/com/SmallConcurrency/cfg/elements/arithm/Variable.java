package com.SmallConcurrency.cfg.elements.arithm;

public class Variable extends   NumValueRepresentation {

    private String name ;

    public Variable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Variable clone() throws CloneNotSupportedException {
        return (Variable) super.clone();
    }




}
