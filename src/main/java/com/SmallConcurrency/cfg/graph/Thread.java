package com.SmallConcurrency.cfg.graph;

import java.util.List;

public class Thread extends Block {

    public Thread( int line) {
        this.line = line;
    }

    public Thread(List<Block> children, int line) {
        super(children);
        this.line = line;
    }
    @Override
    public Thread cloneBlock() {
        Thread clone = null;
        try {
            clone = new Thread(this.cloneChildren(), this.line);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return clone;
    }

}
