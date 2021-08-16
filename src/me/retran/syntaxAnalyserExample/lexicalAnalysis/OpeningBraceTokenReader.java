package me.retran.syntaxAnalyserExample.lexicalAnalysis;

import me.retran.syntaxAnalyserExample.misc.TextReader;

public final class OpeningBraceTokenReader extends BraceTokenReader {
    public OpeningBraceTokenReader(TextReader textReader) {
        super(textReader, new char[]{'{', '[', '('});
    }

    public IToken readToken() {
        char character = textReader.getCurrentCharacter();
        textReader.moveNext();
        return new OpeningBraceToken(String.valueOf((character)));
    }
}

