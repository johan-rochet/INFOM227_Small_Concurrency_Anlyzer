package com.SmallConcurrency.cfg.graph;

import java.util.List;

public class EndThread extends Block{



    public EndThread() {}

    public EndThread(List<Block> children) {
        super(children);

    }


    @Override
    public EndThread cloneBlock() {
        EndThread clone = null;
        try {
            clone = new EndThread(this.cloneChildren());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return clone;

    }

}
