package com.SmallConcurrency.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class CompileTest {

    private static final Logger logger = LogManager.getLogger(CompileTest.class);
    public static List<String> launchAnalysis(String input) {
        try {
            return Main.analyse(new File(CompileTest.class.getResource(input).toURI()));
        }
        catch (URISyntaxException e) {
            logger.error("Error while launching file" + input + ": URISyntaxException");
        }
        catch(IOException e) {
            logger.error("Error while launching file" + input + ": IOException");
        }
        return null;
    }
}
