package com.SmallConcurrency.semantic;


import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Thread {

    private List<List<ParserRuleContext>> instructions_set;
    private List<Map<String, Integer>> local_scopes;
    private List<String> locked_variables;

    private List<String> return_into_variables = new ArrayList<String>();



    public Thread(List<List<ParserRuleContext>> instructions_set, List<Map<String, Integer>> local_scopes, List<String> locked_variables) {
        this.instructions_set = instructions_set;
        this.local_scopes = local_scopes;
        this.locked_variables = locked_variables;
        this.return_into_variables = new ArrayList<String>();
    }

    public List<Map<String, Integer>> getLocal_scopes() {
        return local_scopes;
    }

    public List<String> getLocked_variables() {
        return locked_variables;
    }

    public List<List<ParserRuleContext>> getInstructions_set() {
        return instructions_set;
    }

    public void setInstructions_set(List<List<ParserRuleContext>> instructions_set) {
        this.instructions_set = instructions_set;
    }

    public void setLocal_scopes(List<Map<String, Integer>> local_scopes) {
        this.local_scopes = local_scopes;
    }

    public void setLocked_variables(List<String> locked_variables) {
        this.locked_variables = locked_variables;
    }

    public Map<String, Integer> getLastLocalScope() {

        return local_scopes.get(local_scopes.size() - 1);
    }

    public List<ParserRuleContext> getLastInstructionsSet() {

        return instructions_set.get(instructions_set.size() - 1);
    }

    public void addToLastInstructionsSet(ParserRuleContext instruction) {

        instructions_set.get(instructions_set.size() - 1).add(0, instruction);
    }

    public void addToLastInstructionsSet(List<ParserRuleContext> instructions) {

        instructions_set.get(instructions_set.size() - 1).addAll(0, instructions);
    }

    public void addReturnIntoVariable(String variable) {
        return_into_variables.add(variable);
    }

    public String popReturnIntoVariable() {
        return return_into_variables.remove(return_into_variables.size() - 1);
    }
}
