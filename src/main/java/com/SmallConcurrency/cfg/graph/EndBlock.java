package com.SmallConcurrency.cfg.graph;

public class EndBlock extends Block {

    public EndBlock() {

    }

    @Override
    public EndBlock cloneBlock() {
        return new EndBlock();
    }
}
