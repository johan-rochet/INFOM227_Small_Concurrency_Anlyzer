package com.SmallConcurrency.cfg.graph;

import com.SmallConcurrency.cfg.elements.arithm.Variable;
import com.SmallConcurrency.staticAnalysis.StaticAnalysisVisitor;

import java.util.List;

public class GlobalVarDecl extends Block{
    private Variable variable;

    public Variable getVariable() {
        return variable;
    }

    public GlobalVarDecl(Variable variable){

        this.variable = variable;
        System.out.println(this.getVariable());
    }

    public GlobalVarDecl( List<Block> children,  Variable variable){

        super(children);
        this.variable = variable;
    }

    @Override
    public GlobalVarDecl cloneBlock() {

        GlobalVarDecl clone = null;
        try {
            clone = new GlobalVarDecl(this.cloneChildren(), this.variable.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;

    }

    public void accept(StaticAnalysisVisitor visitor) {
        visitor.visitGlobalVarDecl(this);
    }

}
