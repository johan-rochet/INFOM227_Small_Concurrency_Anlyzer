
package com.SmallConcurrency.main;


import com.SmallConcurrency.cfg.CFGVisitor;
import com.SmallConcurrency.cfg.graph.Block;
import com.SmallConcurrency.cfg.graph.Function;
import com.SmallConcurrency.semantic.SemanticVisitor;
import com.SmallConcurrency.SmallConcurrencyGrammarParser;
import com.SmallConcurrency.SmallConcurrencyGrammarLexer;
import org.antlr.v4.runtime.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    private static File inputFile;

    public static void main(String[] args) {

        try {
            analyse("/semantic/test.smallConcurrent");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static void analyse(String input) throws URISyntaxException, IOException {

        inputFile = new File(Main.class.getResource(input).toURI());

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

        SemanticVisitor visitor = new SemanticVisitor();


        tree.accept(visitor);

        System.out.println("Finished analyzing file: " + inputFile.getName());

        System.out.println("The program is semantically correct!");

        System.out.println("Starting cfg generation...");

        CFGVisitor cfgVisitor = new CFGVisitor();
        tree.accept(cfgVisitor);

        for (Block block : cfgVisitor.getCFGList()) {
            System.out.println("Thread :");
            System.out.println(block.toString());
        }
        System.out.println("Functions :");
        for (Function function : cfgVisitor.getFunctions().values()) {

            System.out.println(function.toString());
        }

        System.out.println("Finished cfg generation!");

    }

}