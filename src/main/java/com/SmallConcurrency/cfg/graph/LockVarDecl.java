package com.SmallConcurrency.cfg.graph;

import com.SmallConcurrency.cfg.elements.arithm.Variable;

import java.util.List;

public class LockVarDecl extends Block{

    private Variable variable;

    public LockVarDecl( Variable variable){

        this.variable = variable;
    }

    public LockVarDecl( List<Block> children,  Variable variable){

        super(children);
        this.variable = variable;
    }

    public Variable getVariable() {
        return variable;
    }

    @Override
    public LockVarDecl cloneBlock() {

        LockVarDecl clone = null;
        try {
            clone = new LockVarDecl(this.cloneChildren(), this.variable.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }


}
