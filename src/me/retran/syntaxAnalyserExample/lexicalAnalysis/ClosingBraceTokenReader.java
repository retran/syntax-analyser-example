package me.retran.syntaxAnalyserExample.lexicalAnalysis;

import me.retran.syntaxAnalyserExample.misc.TextReader;

public final class ClosingBraceTokenReader extends BraceTokenReader {
    public ClosingBraceTokenReader(TextReader textReader) {
        super(textReader, new char[]{'}', ']', ')'});
    }

    public IToken readToken() {
        char character = textReader.getCurrentCharacter();
        textReader.moveNext();
        return new ClosingBraceToken(String.valueOf((character)));
    }
}
