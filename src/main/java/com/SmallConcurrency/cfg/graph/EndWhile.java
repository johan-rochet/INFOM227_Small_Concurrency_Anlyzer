package com.SmallConcurrency.cfg.graph;

public class EndWhile extends Block{

    public EndWhile() {}

    @Override
    public EndWhile cloneBlock() {
        return new EndWhile();

    }
}
