package com.SmallConcurrency.cfg.graph;

import com.SmallConcurrency.cfg.elements.arithm.ArithmExp;
import com.SmallConcurrency.cfg.elements.arithm.Variable;

import java.util.List;

public class Assignment extends Block {

    private Variable variable;

    private ArithmExp arithm_exp;

    public Assignment( Variable variable, ArithmExp arithm_exp){

        this.variable = variable;
        this.arithm_exp = arithm_exp;
    }

    public Assignment( List<Block> children,  Variable variable, ArithmExp arithm_exp){

        super(children);
        this.variable = variable;
        this.arithm_exp = arithm_exp;
    }

    public Variable getVariable() {
        return variable;
    }

    public ArithmExp getArithm_exp() {
        return arithm_exp;
    }
    @Override
    public Assignment cloneBlock() {
        Assignment clone = null;
        try {
             clone = new Assignment(this.cloneChildren(), this.variable.clone(), this.arithm_exp.clone());
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;

    }
}
