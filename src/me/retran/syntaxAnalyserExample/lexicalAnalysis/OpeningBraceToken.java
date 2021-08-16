package me.retran.syntaxAnalyserExample.lexicalAnalysis;

public final class OpeningBraceToken extends Token<String> {
    private final String text;

    public OpeningBraceToken(String text) {
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

