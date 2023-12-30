package com.SmallConcurrency.cfg.elements.bool;

import com.SmallConcurrency.cfg.elements.arithm.NumValueRepresentation;

public class BoolOp extends BoolValueRepresentation{

    private NumValueRepresentation left;

    private NumValueRepresentation right;

    private BOp boolOp;

    public BoolOp(NumValueRepresentation left, NumValueRepresentation right, BOp boolOp) {
        this.left = left;
        this.right = right;
        this.boolOp = boolOp;
    }

    @Override
    public BoolOp clone() throws CloneNotSupportedException {
        return new BoolOp(
                this.left.clone(),
                this.right.clone(),
                this.boolOp
        );
    }

    public NumValueRepresentation getLeft() {
        return left;
    }

    public NumValueRepresentation getRight() {
        return right;
    }
}
