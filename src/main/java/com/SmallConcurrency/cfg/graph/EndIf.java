package com.SmallConcurrency.cfg.graph;

public class EndIf extends Block{

    public EndIf(){}

    @Override
    public EndIf cloneBlock() {
        return new EndIf();
    }
}
