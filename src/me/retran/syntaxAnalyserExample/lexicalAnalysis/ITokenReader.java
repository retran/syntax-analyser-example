package me.retran.syntaxAnalyserExample.lexicalAnalysis;

public interface ITokenReader {
    boolean isApplicable();

    IToken readToken();
}

