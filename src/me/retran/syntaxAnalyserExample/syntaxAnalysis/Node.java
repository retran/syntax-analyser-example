package me.retran.syntaxAnalyserExample.syntaxAnalysis;

public abstract class Node {
    private int index = 1;

    public int getIndex() {
        return index;
    }

    public void applyIndex(int index) {
        this.index *= index;
    }
}

