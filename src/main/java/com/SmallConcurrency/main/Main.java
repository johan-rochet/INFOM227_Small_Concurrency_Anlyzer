
package com.SmallConcurrency.main;

import com.SmallConcurrency.staticAnalysis.VariableAccess;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.SmallConcurrency.cfg.CFGVisitor;
import com.SmallConcurrency.semantic.SemanticVisitor;
import com.SmallConcurrency.SmallConcurrencyGrammarParser;
import com.SmallConcurrency.SmallConcurrencyGrammarLexer;
import com.SmallConcurrency.staticAnalysis.AbstractValues;
import com.SmallConcurrency.staticAnalysis.StaticAnalysisVisitor;
import org.antlr.v4.runtime.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import static com.SmallConcurrency.main.Utils.leastUpperBound;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        if (args.length != 1) {
            logger.error("Error while launching file: wrong number of arguments");
            System.exit(-1);
        }
        String inputPath = args[0];
        String inputStr = "";
        try {
            inputStr = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(inputPath)));
        }
        catch (IOException e) {
            logger.error("Error while launching file" + inputPath + ": IOException");
            System.exit(-1);
        }

        ByteArrayInputStream input = new ByteArrayInputStream(inputStr.getBytes());

        try {
            analyse(input);
        }

        catch (IOException e) {
            logger.error("Error while launching file" + input + ": IOException");
        }
    }

    public static List<String> analyse(InputStream inputFile) throws  IOException {



        CharStream tokens = CharStreams.fromStream(inputFile);

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

        System.out.println("Finished analyzing file! ");

        System.out.println("The program is semantically correct!");

        System.out.println("Starting cfg generation...");

        CFGVisitor cfgVisitor = new CFGVisitor();
        tree.accept(cfgVisitor);

        System.out.println("Finished cfg generation!");


        long begin_time = System.currentTimeMillis();
        StaticAnalysisVisitor staticAnalysisVisitor = new StaticAnalysisVisitor();
        cfgVisitor.getCFG().accept(staticAnalysisVisitor);

        Map<String, VariableAccess> globalVarValues = staticAnalysisVisitor.getGlobalVarValues();

        List<String> raceConditions = new ArrayList<>();

        for (String varName : globalVarValues.keySet()) {

            AbstractValues value = leastUpperBound(globalVarValues.get(varName).getValue(), globalVarValues.get(varName).getConcurrentValue());
            if (value == AbstractValues.RC) {
                raceConditions.add(varName);
                logger.warn("Race condition detected on variable " + varName + "!");
            }
        }

        long end_time = System.currentTimeMillis();

        logger.info("Static analysis took " + (end_time - begin_time) + "ms");

        return raceConditions;







    }

}