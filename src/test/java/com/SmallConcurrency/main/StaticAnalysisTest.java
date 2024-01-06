package com.SmallConcurrency.main;

import org.junit.jupiter.api.Test;

import java.util.List;

public class StaticAnalysisTest {

    private static void checkRaceConditions(List<String> raceConditionsVariable, String varName) {
        assert raceConditionsVariable.contains(varName);
    }
    @Test
    public void NoRC1() {
        List<String> raceConditionsVariable = CompileTest.launchAnalysis("/NoRC1.smallConcurrent");
        assert raceConditionsVariable.size() == 0;
    }

    @Test
    public void NoRC2() {
        List<String> raceConditionsVariable = CompileTest.launchAnalysis("/NoRC2.smallConcurrent");
        assert raceConditionsVariable.size() == 0;
    }

    @Test
    public void NoRC3() {
        List<String> raceConditionsVariable = CompileTest.launchAnalysis("/NoRC3.smallConcurrent");
        assert raceConditionsVariable.size() == 0;
    }

    @Test
    public void RC1(){
        List<String> raceConditionsVariable = CompileTest.launchAnalysis("/RC1.smallConcurrent");
        assert raceConditionsVariable.size() == 1;
        checkRaceConditions(raceConditionsVariable, "y");
    }

    @Test
    public void RC2(){
        List<String> raceConditionsVariable = CompileTest.launchAnalysis("/RC2.smallConcurrent");
        assert raceConditionsVariable.size() == 1;
        checkRaceConditions(raceConditionsVariable, "x");
    }

    @Test
    public void RC3(){
        List<String> raceConditionsVariable = CompileTest.launchAnalysis("/RC3.smallConcurrent");
        assert raceConditionsVariable.size() == 1;
        checkRaceConditions(raceConditionsVariable, "y");
    }

    @Test
    public void RC4(){
        List<String> raceConditionsVariable = CompileTest.launchAnalysis("/RC4.smallConcurrent");
        assert raceConditionsVariable.size() == 2;
        checkRaceConditions(raceConditionsVariable, "y");
        checkRaceConditions(raceConditionsVariable, "x");
    }

    @Test
    public void Complete () {
        List<String> raceConditionsVariable = CompileTest.launchAnalysis("/Complete.smallConcurrent");
        assert raceConditionsVariable.size() == 1;
        checkRaceConditions(raceConditionsVariable, "x");

    }

}
