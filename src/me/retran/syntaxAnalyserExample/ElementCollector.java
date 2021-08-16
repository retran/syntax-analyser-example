package me.retran.syntaxAnalyserExample;

import me.retran.syntaxAnalyserExample.syntaxAnalysis.ElementNode;
import me.retran.syntaxAnalyserExample.syntaxAnalysis.ExpressionNode;
import me.retran.syntaxAnalyserExample.syntaxAnalysis.Node;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ElementCollector {
    private final ExpressionNode root;
    private final Map<String, Integer> elements;

    public ElementCollector(ExpressionNode root) {
        this.root = root;
        elements = new LinkedHashMap<>(); // using LinkedHashMap to preserve insertion order
    }

    public String collect() {
        doCollect(root, root.getIndex());
        return "{" + elements.keySet().stream().map(key -> String.format("%s: %d", key, elements.get(key)))
                .collect(Collectors.joining(", ")) + "}";
    }

    private void doCollect(ExpressionNode node, int multiplier) {
        for (Node child : node.getChildren()) {
            if (child instanceof ElementNode) {
                ElementNode elementNode = (ElementNode) child;
                Integer index = elements.computeIfAbsent(elementNode.getName(), (k) -> 0);
                index += elementNode.getIndex() * multiplier;
                elements.put(elementNode.getName(), index);
            } else {
                ExpressionNode expressionNode = (ExpressionNode) child;
                doCollect(expressionNode, expressionNode.getIndex() * multiplier);
            }
        }
    }
}
