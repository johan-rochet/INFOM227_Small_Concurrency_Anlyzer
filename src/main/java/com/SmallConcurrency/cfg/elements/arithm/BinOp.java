package com.SmallConcurrency.cfg.elements.arithm;

public class BinOp extends ArithmExp {

    private NumValueRepresentation left;
    private NumValueRepresentation right;

    private Op op;

    public BinOp(NumValueRepresentation left, NumValueRepresentation right, Op op) {
        this.left = left;
        this.right = right;
        this.op = op;
    }


    public NumValueRepresentation getLeft() {
        return left;
    }

    public NumValueRepresentation getRight() {
        return right;
    }

    @Override
    public BinOp clone() throws CloneNotSupportedException {
        return new BinOp(
                this.left.clone(),
                this.right.clone(),
                this.op
        );

    }


}
