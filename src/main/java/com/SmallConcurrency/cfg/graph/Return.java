package com.SmallConcurrency.cfg.graph;

import com.SmallConcurrency.cfg.elements.arithm.ArithmExp;
import com.SmallConcurrency.cfg.elements.arithm.NumValueRepresentation;
import com.SmallConcurrency.cfg.elements.arithm.Variable;

import java.util.List;

public class Return extends Block{

    private ArithmExp returnVar;

    public Return(ArithmExp returnVar){
        this.returnVar = returnVar;
    }

    public Return(List<Block> children, ArithmExp returnVar){
        super(children);
        this.returnVar = returnVar;
    }


    public Return cloneBlock(){
        Return clone = null;
        try {
            clone = new Return(this.cloneChildren(), this.returnVar.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;


    }
}
