package me.retran.syntaxAnalyserExample.lexicalAnalysis;

public final class ClosingBraceToken extends Token<String> {
    private final String text;

    public ClosingBraceToken(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public String getValue() {
        return text;
    }
}
