package me.retran.syntaxAnalyserExample.lexicalAnalysis;

public abstract class Token<TValue> implements IToken {
    public abstract String getText();

    public abstract TValue getValue();
}

