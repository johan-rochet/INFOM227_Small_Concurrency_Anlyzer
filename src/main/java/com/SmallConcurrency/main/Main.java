
package com.SmallConcurrency.main;

import com.SmallConcurrency.staticAnalysis.VariableAccess;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.SmallConcurrency.cfg.CFGVisitor;
import com.SmallConcurrency.cfg.graph.Block;
import com.SmallConcurrency.cfg.graph.Function;
import com.SmallConcurrency.cfg.graph.GlobalVarDecl;
import com.SmallConcurrency.semantic.SemanticVisitor;
import com.SmallConcurrency.SmallConcurrencyGrammarParser;
import com.SmallConcurrency.SmallConcurrencyGrammarLexer;
import com.SmallConcurrency.staticAnalysis.AbstractValues;
import com.SmallConcurrency.staticAnalysis.StaticAnalysisVisitor;
import org.antlr.v4.runtime.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static com.SmallConcurrency.main.Utils.mergeOperator;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        String input = "/semantic/test.smallConcurrent";

        try {
            analyse(new File(Main.class.getResource(input).toURI()));
        }
        catch (URISyntaxException e) {
            logger.error("Error while launching file" + input + ": URISyntaxException");
        }
        catch (IOException e) {
            logger.error("Error while launching file" + input + ": IOException");
        }
    }

    public static List<String> analyse(File inputFile) throws  IOException {



        CharStream tokens = CharStreams.fromPath(inputFile.toPath());

        SmallConcurrencyGrammarLexer lexer = new SmallConcurrencyGrammarLexer(tokens);

        CommonTokenStream lexerTokenStream = new CommonTokenStream(lexer);

        SmallConcurrencyGrammarParser parser = new SmallConcurrencyGrammarParser(lexerTokenStream);

        SmallConcurrencyGrammarParser.RootContext tree;


        try {
            tree = parser.root();

        } catch (RecognitionException e) {
            throw new IllegalArgumentException("Error while retrieving parsing tree!", e);
        }

        if (parser.getNumberOfSyntaxErrors() > 0) {
            logger.error("Syntax error detected!");
            System.exit(-1);
        }


        SemanticVisitor visitor = new SemanticVisitor();


        tree.accept(visitor);

        System.out.println("Finished analyzing file: " + inputFile.getName());

        System.out.println("The program is semantically correct!");

        System.out.println("Starting cfg generation...");

        CFGVisitor cfgVisitor = new CFGVisitor();
        tree.accept(cfgVisitor);

        System.out.println("Finished cfg generation!");

        StaticAnalysisVisitor staticAnalysisVisitor = new StaticAnalysisVisitor();
        cfgVisitor.getCFG().accept(staticAnalysisVisitor);

        Map<String, VariableAccess> globalVarValues = staticAnalysisVisitor.getGlobalVarValues();

        List<String> raceConditions = new ArrayList<>();

        for (String varName : globalVarValues.keySet()) {

            AbstractValues value = mergeOperator(globalVarValues.get(varName).getValue(), globalVarValues.get(varName).getConcurrentValue());
            if (value == AbstractValues.RC) {
                raceConditions.add(varName);
                logger.warn("Race condition detected on variable " + varName + "!");
            }
        }

        return raceConditions;







    }

}