package com.SmallConcurrency.cfg.graph;

import java.util.List;

public class EndFunction extends Block{

    public EndFunction() {
    }
    public EndFunction(List<Block> children) {
        super(children);
    }

    @Override
    public EndFunction cloneBlock() {
        EndFunction clone = null;
        try {
            clone = new EndFunction(this.cloneChildren());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return clone;
    }
}
