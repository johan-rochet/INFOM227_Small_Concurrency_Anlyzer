package com.SmallConcurrency.cfg.graph;

import com.SmallConcurrency.cfg.elements.arithm.Variable;

import java.util.List;

public class UnlockVarDecl extends Block{

    private Variable variable;

    public UnlockVarDecl(  Variable variable){

        this.variable = variable;
    }

    public UnlockVarDecl( List<Block> children,   Variable variable){

        super(children);
        this.variable = variable;
    }

    @Override
    public UnlockVarDecl cloneBlock() {

        UnlockVarDecl clone = null;
        try {
            clone = new UnlockVarDecl(this.cloneChildren(), this.variable.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}
