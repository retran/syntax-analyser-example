package me.retran.syntaxAnalyserExample.syntaxAnalysis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class ExpressionNode extends Node {
    private final List<Node> children;

    public ExpressionNode() {
        children = new ArrayList<>();
    }

    public void add(Node node) {
        children.add(node);
    }

    public Collection<Node> getChildren() {
        return children;
    }
}
