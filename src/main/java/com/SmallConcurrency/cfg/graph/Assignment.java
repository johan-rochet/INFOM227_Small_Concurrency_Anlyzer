package com.SmallConcurrency.cfg.graph;

import com.SmallConcurrency.cfg.elements.arithm.ArithmExp;
import com.SmallConcurrency.cfg.elements.arithm.Variable;

import java.util.List;

public class Assignment extends Block {

    private Variable variable_write;

    private ArithmExp variable_read;

    public Assignment( Variable variable_write, ArithmExp variable_read){

        this.variable_write = variable_write;
        this.variable_read = variable_read;
    }

    public Assignment( List<Block> children,  Variable variable_write, ArithmExp variable_read){

        super(children);
        this.variable_write = variable_write;
        this.variable_read = variable_read;
    }

    @Override
    public Assignment cloneBlock() {
        Assignment clone = null;
        try {
             clone = new Assignment(this.cloneChildren(), this.variable_write.clone(), this.variable_read.clone());
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;

    }
}
