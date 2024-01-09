package com.SmallConcurrency.cfg.graph;

import com.SmallConcurrency.cfg.elements.arithm.Variable;

import java.util.List;

public class FuncCallAssignment extends Block{

    private Variable variable;

    private Function function;

    public FuncCallAssignment(Variable variable, Function function, int line) {
        this.variable = variable;
        this.function = function;
        this.line = line;
    }

    private FuncCallAssignment(List<Block> children, Variable variable, Function function, int line) {
        super(children);
        this.variable = variable;
        this.function = function;
        this.line = line;
    }

    @Override
    public FuncCallAssignment cloneBlock()
    {
        FuncCallAssignment clone = null;
        try{
            clone = new FuncCallAssignment(this.cloneChildren(), this.variable.clone(), this.function.cloneBlock(), this.line);
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }

    public Variable getVariable() {
        return variable;
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

    public Function getFunction() {
        return function;
    }
}
