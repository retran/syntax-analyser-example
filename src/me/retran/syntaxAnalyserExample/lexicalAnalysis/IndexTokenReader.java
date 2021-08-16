package me.retran.syntaxAnalyserExample.lexicalAnalysis;

import me.retran.syntaxAnalyserExample.misc.TextReader;

public final class IndexTokenReader implements ITokenReader {
    protected TextReader textReader;

    public IndexTokenReader(TextReader textReader) {
        this.textReader = textReader;
    }

    public boolean isApplicable() {
        return Character.isDigit(textReader.getCurrentCharacter());
    }

    public IToken readToken() {
        StringBuilder sb = new StringBuilder();
        while (!textReader.isEndOfText() && Character.isDigit(textReader.getCurrentCharacter())) {
            sb.append(textReader.getCurrentCharacter());
            textReader.moveNext();
        }
        return new IndexToken(sb.toString());
    }
}

