package com.SmallConcurrency.staticAnalysis;

public class VariableAccess {

    private AbstractValues value = AbstractValues.NA;

    private AbstractValues concurrentValue = AbstractValues.NA;



    public AbstractValues getValue() {
        return value;
    }


    public void setConcurrentValue(AbstractValues concurrentValue) {
        this.concurrentValue = concurrentValue;
    }

    public AbstractValues getConcurrentValue() {
        return concurrentValue;
    }

    public void setValue(AbstractValues value) {
        this.value = value;
    }

    public VariableAccess() {
    }

    public VariableAccess(AbstractValues value , AbstractValues concurrentValue) {
        this.value = value;
        this.concurrentValue = concurrentValue;
    }

    @Override
    public String toString() {
        return "VariableAccess{" +
                "value=" + value +
                ", concurrentValue=" + concurrentValue +
                '}';
    }
}
