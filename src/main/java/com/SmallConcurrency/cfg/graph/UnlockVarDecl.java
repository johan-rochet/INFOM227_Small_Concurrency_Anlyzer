package com.SmallConcurrency.cfg.graph;

import com.SmallConcurrency.cfg.elements.arithm.Variable;

import java.util.List;

public class UnlockVarDecl extends Block{

    private Variable variable;

    public UnlockVarDecl(  Variable variable, int line){

        this.variable = variable;
        this.line = line;
    }

    private UnlockVarDecl( List<Block> children,   Variable variable, int line){

        super(children);
        this.variable = variable;
        this.line = line;
    }

    public Variable getVariable() {
        return variable;
    }
    @Override
    public UnlockVarDecl cloneBlock() {

        UnlockVarDecl clone = null;
        try {
            clone = new UnlockVarDecl(this.cloneChildren(), this.variable.clone(), this.line);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}
