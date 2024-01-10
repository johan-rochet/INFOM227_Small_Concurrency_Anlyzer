package com.SmallConcurrency.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.List;

public class CompileTest {

    private static final Logger logger = LogManager.getLogger(CompileTest.class);
    public static List<String> launchAnalysis(String input) {
        try {
            return Main.analyse(CompileTest.class.getResourceAsStream(input)) ;
        }

        catch(IOException e) {
            logger.error("Error while launching file" + input + ": IOException");
        }
        return null;
    }
}
