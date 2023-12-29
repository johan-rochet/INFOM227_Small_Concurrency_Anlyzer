package com.SmallConcurrency.cfg.elements.bool;

public class RelOp extends BoolValueRepresentation {

    private BoolValueRepresentation left;

    private BoolValueRepresentation right;

    private ROp rop;

    public RelOp(BoolValueRepresentation left, BoolValueRepresentation right, ROp rop) {
        this.left = left;
        this.right = right;
        this.rop = rop;
    }

    @Override
    public RelOp clone() throws CloneNotSupportedException {
        return new RelOp(
                this.left.clone(),
                this.right.clone(),
                this.rop
        );
    }



}
