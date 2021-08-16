package me.retran.syntaxAnalyserExample.syntaxAnalysis;

public final class ElementNode extends Node {
    private final String name;

    public ElementNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
