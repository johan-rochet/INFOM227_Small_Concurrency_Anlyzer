package com.SmallConcurrency;



import java.util.ArrayList;
import java.util.List;

public class FunctionInfo {
    private String name;
    private List<String> parameters;
    private SmallConcurrencyGrammarParser.SequenceContext instructions_set;
    public FunctionInfo( String name, List<String> parameters, SmallConcurrencyGrammarParser.SequenceContext instructions_set) {
        this.name = name;
        this.parameters = parameters;
        this.instructions_set = instructions_set;

    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }


    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    public SmallConcurrencyGrammarParser.SequenceContext getInstructions_set() {
        return instructions_set;
    }

    public void setInstructions_set(SmallConcurrencyGrammarParser.SequenceContext instructions_set) {
        this.instructions_set = instructions_set;
    }
}
