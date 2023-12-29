package com.SmallConcurrency.cfg.graph;

import com.SmallConcurrency.cfg.elements.arithm.Variable;

import java.util.List;

public class VarDecl extends Block{

    private Variable variable;

    public VarDecl( Variable variable){

        this.variable = variable;
    }

    public VarDecl( List<Block> children,  Variable variable){

        super(children);
        this.variable = variable;
    }

    @Override
    public VarDecl cloneBlock() {
        VarDecl clone = null;
        try {
            clone = new VarDecl(this.cloneChildren(), this.variable.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;

    }


}
