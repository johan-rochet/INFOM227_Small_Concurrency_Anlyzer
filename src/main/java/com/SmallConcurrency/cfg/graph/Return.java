package com.SmallConcurrency.cfg.graph;

import com.SmallConcurrency.cfg.elements.arithm.ArithmExp;
import com.SmallConcurrency.cfg.elements.arithm.NumValueRepresentation;
import com.SmallConcurrency.cfg.elements.arithm.Variable;

import java.util.List;

public class Return extends Block{

    private ArithmExp returnVar;

    public Return(ArithmExp returnVar, int line){
        this.returnVar = returnVar;
        this.line = line;
    }

    private Return(List<Block> children, ArithmExp returnVar, int line){
        super(children);
        this.returnVar = returnVar;
        this.line = line;
    }

    public ArithmExp getReturnVar() {
        return returnVar;
    }


    public Return cloneBlock(){
        Return clone = null;
        try {
            clone = new Return(this.cloneChildren(), this.returnVar.clone(), this.line);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;


    }
}
