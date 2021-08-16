package me.retran.syntaxAnalyserExample.lexicalAnalysis;

public final class IndexToken extends Token<Integer> {
    private final int value;
    private final String text;

    public IndexToken(String text) {
        this.text = text;
        this.value = Integer.parseInt(text);
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
