package com.SmallConcurrency.cfg.graph;

public class Thread extends Block {

    public Thread() {
    }
    @Override
    public Thread cloneBlock() {
        return new Thread();
    }


}
