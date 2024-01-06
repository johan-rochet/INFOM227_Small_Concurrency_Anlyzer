package com.SmallConcurrency.cfg.graph;

import com.SmallConcurrency.cfg.elements.arithm.Variable;

import java.util.List;

public class VarDecl extends Block{

    private Variable variable;

    public VarDecl( Variable variable, int line){

        this.variable = variable;
        this.line = line;
    }

    private VarDecl( List<Block> children,  Variable variable, int line){

        super(children);
        this.variable = variable;
    }

    @Override
    public VarDecl cloneBlock() {
        VarDecl clone = null;
        try {
            clone = new VarDecl(this.cloneChildren(), this.variable.clone(),this.line);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;

    }


}
