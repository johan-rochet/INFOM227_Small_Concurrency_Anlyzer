package com.SmallConcurrency.cfg.elements.arithm;

public abstract class ArithmExp  implements Cloneable  {

    @Override
    public ArithmExp clone() throws CloneNotSupportedException {
        return (ArithmExp) super.clone();
    }


}
