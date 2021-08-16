package me.retran.syntaxAnalyserExample.lexicalAnalysis;

import me.retran.syntaxAnalyserExample.misc.TextReader;

import java.util.Collection;
import java.util.List;

public final class LexicalAnalyser {
    private final TextReader textReader;
    private final Collection<ITokenReader> tokenReaders;

    public LexicalAnalyser(TextReader textReader) {
        this.textReader = textReader;
        this.tokenReaders = List.of(
                new OpeningBraceTokenReader(textReader),
                new ClosingBraceTokenReader(textReader),
                new ElementTokenReader(textReader),
                new IndexTokenReader(textReader)
        );
    }

    public boolean isEndOfText() {
        return textReader.isEndOfText();
    }

    public IToken readNextToken() {
        if (isEndOfText()) {
            throw new RuntimeException("end of text");
        }

        for (ITokenReader tokenReader : tokenReaders) {
            if (tokenReader.isApplicable()) {
                return tokenReader.readToken();
            }
        }

        throw new RuntimeException("unknown token");
    }
}
