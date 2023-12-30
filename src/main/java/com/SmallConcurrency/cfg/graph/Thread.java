package com.SmallConcurrency.cfg.graph;

import java.util.List;

public class Thread extends Block {

    public Thread() {
    }

    public Thread(List<Block> children) {
        super(children);
    }
    @Override
    public Thread cloneBlock() {
        Thread clone = null;
        try {
            clone = new Thread(this.cloneChildren());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return clone;
    }

}
