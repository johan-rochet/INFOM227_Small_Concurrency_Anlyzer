package com.SmallConcurrency;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class Utils {


    public static List<ParserRuleContext> getParserRuleContextFromParseTree(List<ParseTree> parseTrees) {
        List<ParserRuleContext> instructions = new ArrayList<ParserRuleContext>();
        for (ParseTree child : parseTrees) {
            if (child instanceof ParserRuleContext) {
                instructions.add((ParserRuleContext)child);
            }
        }
        return instructions;
    }
}
