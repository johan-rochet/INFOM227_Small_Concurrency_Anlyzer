package com.SmallConcurrency.cfg.graph;

import java.util.ArrayList;
import java.util.List;

public  abstract  class Block {

    protected List<Block> children = new ArrayList<Block>();
    public Block(){}
    public Block(List<Block> children){
        this.children = children;

    }

    public Block(Block child){
        this.children = new ArrayList<Block>();
        this.children.add(child);
    }


    public void addChild(Block child){
        this.children.add(child);
    }

    public List<Block> getChildren(){
        return this.children;
    }

    public String toString(){
        String result = this.getClass() + "\n";

        for (Block child : children) {
            result += child.toString();
        }
        return result;
    }

    public Block getLastBlock(){
        if (this.children.size() == 0){
            return this;
        }
        else{
            return this.children.get(this.children.size()-1).getLastBlock();
        }

    }

    public abstract  <T extends Block> T cloneBlock() ;

    public List<Block> cloneChildren(){
        List<Block> children = new ArrayList<Block>();
        for (Block child : this.children) {

            children.add(child.cloneBlock());
        }
        return children;
    }



}
