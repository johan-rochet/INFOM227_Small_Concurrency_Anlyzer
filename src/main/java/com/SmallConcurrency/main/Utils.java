package com.SmallConcurrency.main;

import com.SmallConcurrency.SmallConcurrencyGrammarParser;
import com.SmallConcurrency.cfg.elements.bool.BoolExpr;
import com.SmallConcurrency.cfg.elements.bool.BoolOp;
import com.SmallConcurrency.staticAnalysis.AbstractValues;
import com.SmallConcurrency.staticAnalysis.VariableAccess;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Utils {

    private static final Logger logger = LogManager.getLogger(Utils.class);


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

        for (ParseTree child : children) {

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

    public static Map<String, VariableAccess> mergeGlobalValues (Map<String, VariableAccess> globalVarValues1, Map<String, VariableAccess> globalVarValues2) {

        Map <String, VariableAccess> mergedGlobalVarValues = new HashMap<>();

        for (String varName : globalVarValues2.keySet()) {
            AbstractValues conccurrentValue = mergeOperator(globalVarValues2.get(varName).getValue(), globalVarValues2.get(varName).getConcurrentValue());

            mergedGlobalVarValues.put(varName, new VariableAccess(globalVarValues1.get(varName).getValue(), conccurrentValue));

        }

        return mergedGlobalVarValues;
    }

    public static AbstractValues mergeOperator(AbstractValues v1, AbstractValues v2){

        switch (v1) {
            case NA:
                return v2;
            case WA:
                switch (v2) {
                    case RC:
                        return v2;
                    default:
                        return v1;
                }
            case RA:
                switch (v2) {
                    case NA:
                        return v1;
                    default:
                        return v2;
                }
        }

        return v1;



    }
}
