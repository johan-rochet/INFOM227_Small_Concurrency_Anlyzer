package com.SmallConcurrency.cfg.graph;

import com.SmallConcurrency.cfg.elements.arithm.Variable;

import java.util.List;

public class FuncCallAssignment extends Block{

    private Variable variable;

    private Function function;

    public FuncCallAssignment(Variable variable, Function function) {
        this.variable = variable;
        this.function = function;
    }

    public FuncCallAssignment(List<Block> children, Variable variable, Function function) {
        super(children);
        this.variable = variable;
        this.function = function;
    }

    @Override
    public FuncCallAssignment cloneBlock()
    {
        FuncCallAssignment clone = null;
        try{
            clone = new FuncCallAssignment(this.cloneChildren(), this.variable.clone(), this.function.cloneBlock());
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }

    @Override
    public String toString() {
        String result = this.getClass() + "\n";

        for (Block child : children) {
            result += child.toString();
        }

        result += this.function.toString();

        return result;
    }

    @Override
    public Block getLastBlock(){
        return this.function.getLastBlock();
    }
}
