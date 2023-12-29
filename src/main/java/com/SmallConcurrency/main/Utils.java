package com.SmallConcurrency.main;

import com.SmallConcurrency.SmallConcurrencyGrammarParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {


    public static List<ParserRuleContext> getParserRuleContextFromParseTree(List<ParseTree> parseTrees) {
        List<ParserRuleContext> instructions = new ArrayList<ParserRuleContext>();
        for (ParseTree child : parseTrees) {
            if (child instanceof ParserRuleContext) {
                instructions.add((ParserRuleContext) child);
            }
        }
        return instructions;
    }

    public static List<ParseTree> getIfAndElseBlock(List<ParseTree> children) {

        ParseTree block1 = null;
        ParseTree block2 = null;

        for(ParseTree child :children) {

            if (child instanceof SmallConcurrencyGrammarParser.SequenceContext && block1 == null) {
                block1 = child;
            } else if (child instanceof SmallConcurrencyGrammarParser.SequenceContext && block1 != null) {
                block2 = child;
            } else if (child instanceof SmallConcurrencyGrammarParser.StatementContext && block1 == null) {
                block1 = child;
            } else if (child instanceof SmallConcurrencyGrammarParser.StatementContext && block1 != null) {
                block2 = child;
            }
        }
        return Arrays.asList(block1, block2);


    }
}
