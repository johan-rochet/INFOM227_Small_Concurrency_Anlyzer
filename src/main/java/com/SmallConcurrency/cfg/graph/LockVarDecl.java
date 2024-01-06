package com.SmallConcurrency.cfg.graph;

import com.SmallConcurrency.cfg.elements.arithm.Variable;

import java.util.List;

public class LockVarDecl extends Block{

    private Variable variable;

    public LockVarDecl( Variable variable, int line){

        this.variable = variable;
    }

    private LockVarDecl( List<Block> children,  Variable variable, int line){

        super(children);
        this.variable = variable;
        this.line = line;
    }

    public Variable getVariable() {
        return variable;
    }

    @Override
    public LockVarDecl cloneBlock() {

        LockVarDecl clone = null;
        try {
            clone = new LockVarDecl(this.cloneChildren(), this.variable.clone(), this.line);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }


}
