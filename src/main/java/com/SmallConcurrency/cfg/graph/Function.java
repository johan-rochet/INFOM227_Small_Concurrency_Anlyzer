package com.SmallConcurrency.cfg.graph;

import com.SmallConcurrency.cfg.elements.arithm.ArithmExp;
import com.SmallConcurrency.cfg.elements.arithm.Variable;

import java.util.ArrayList;
import java.util.List;

public class Function extends Block {

    String name;
    List<Variable> parameters;

    List<ArithmExp> args = new ArrayList<ArithmExp>();
    public Function(String name, List<Variable> parameters, int line) {
        this.name = name;
        this.parameters = parameters;
        this.line = line;
    }

    private Function(List<Block> children, String name, List<Variable> parameters, int line) {
        super(children);
        this.name = name;
        this.parameters = parameters;
        this.line = line;
    }

    public String getName() {
        return name;
    }

    public List<ArithmExp> getArgs() {
        return args;
    }

    @Override
    public Function cloneBlock()
    {
        Function clone = null;

        clone = new Function(this.cloneChildren(), String.valueOf(this.name), this.cloneVariables(), this.line);
        return clone;
    }

    public void setArgs(List<ArithmExp> args) {
        this.args = args;

    }
    private List<Variable> cloneVariables() {
        List<Variable> clone = new ArrayList<Variable>();
        try {
            for (Variable item : this.parameters) clone.add(item.clone());
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }



}
