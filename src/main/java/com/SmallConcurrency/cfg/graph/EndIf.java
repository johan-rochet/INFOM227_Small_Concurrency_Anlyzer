package com.SmallConcurrency.cfg.graph;

import java.util.List;

public class EndIf extends Block{

    public EndIf(){}

    public EndIf(List<Block> children){
        super(children);
    }

    @Override
    public EndIf cloneBlock() {

        EndIf clone = null;
        try {
            clone = new EndIf(this.cloneChildren());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return clone;

    }
}
