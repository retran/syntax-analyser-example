package me.retran.syntaxAnalyserExample.syntaxAnalysis;

import me.retran.syntaxAnalyserExample.lexicalAnalysis.*;

// Grammar
// Index : IndexToken
// Element : ElementToken | ElementToken Index
// ExpressionItem : Element | BracedExpression
// BracedExpression : OpeningBrace Expression ClosingBrace Index
// Expression : ExpressionItem | ExpressionItem Expression

public class SyntaxAnalyser {
    private final LexicalAnalyser lexicalAnalyser;

    private IToken currentToken;

    public SyntaxAnalyser(LexicalAnalyser lexicalAnalyser) {
        this.lexicalAnalyser = lexicalAnalyser;
    }

    public ExpressionNode parse() {
        // read initial token
        moveNext();

        return expression();
    }

    private ExpressionNode expression() {
        ExpressionNode node = new ExpressionNode();
        while (currentToken instanceof ElementToken || currentToken instanceof OpeningBraceToken) {
            node.add(expressionItem());
        }

        return node;
    }

    private Node expressionItem() {
        if (currentToken instanceof ElementToken) {
            return element();
        }

        if (currentToken instanceof OpeningBraceToken) {
            return bracedExpression();
        }

        throw new RuntimeException("syntax error");
    }

    private ExpressionNode bracedExpression() {
        if (!(currentToken instanceof OpeningBraceToken)) {
            throw new RuntimeException("syntax error");
        }
        moveNext();

        ExpressionNode node = expression();

        if (!(currentToken instanceof ClosingBraceToken)) {
            throw new RuntimeException("syntax error");
        }
        moveNext();

        // TODO validate: opening brace type should be same as closing brace type

        node.applyIndex(index());
        return node;
    }

    private ElementNode element() {
        ElementToken elementToken = (ElementToken) currentToken;
        ElementNode node = new ElementNode(elementToken.getValue());

        moveNext();

        if (currentToken instanceof IndexToken) {
            node.applyIndex(index());
        }

        return node;
    }

    private Integer index() {
        IndexToken token = (IndexToken) currentToken;
        moveNext();
        return token.getValue();
    }

    private void moveNext() {
        if (lexicalAnalyser.isEndOfText()) {
            currentToken = null;
        } else {
            currentToken = lexicalAnalyser.readNextToken();
        }
    }
}
