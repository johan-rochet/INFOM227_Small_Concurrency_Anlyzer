package com.SmallConcurrency.cfg.graph;

import java.util.List;

public class EndWhile extends Block{



    public EndWhile() {}

    public EndWhile(List<Block> children) {
        super(children);

    }


                    @Override
    public EndWhile cloneBlock() {
        EndWhile clone = null;
        try {
            clone = new EndWhile(this.cloneChildren());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return clone;

    }

}
