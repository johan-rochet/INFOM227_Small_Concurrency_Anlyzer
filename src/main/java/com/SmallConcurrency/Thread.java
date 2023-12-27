package com.SmallConcurrency;

import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Thread {

    private List<List<ParseTree>> instructions_set;
    private List<Map<String, Integer>> local_scopes;
    private List<String> locked_variables;

    public Thread() {
        instructions_set = new ArrayList<List<ParseTree>>();
        local_scopes = new ArrayList<Map<String, Integer>>();
        local_scopes.add(new HashMap<String, Integer>());
        locked_variables = new ArrayList<String>();
    }

    public List<Map<String, Integer>> getLocal_scopes() {
        return local_scopes;
    }

    public List<String> getLocked_variables() {
        return locked_variables;
    }

    public List<List<ParseTree>> getInstructions_set() {
        return instructions_set;
    }

    public void setInstructions_set(List<List<ParseTree>> instructions_set) {
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
}
