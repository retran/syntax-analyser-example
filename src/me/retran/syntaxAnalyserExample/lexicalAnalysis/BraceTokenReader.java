package me.retran.syntaxAnalyserExample.lexicalAnalysis;

import me.retran.syntaxAnalyserExample.misc.TextReader;

public abstract class BraceTokenReader implements ITokenReader {
    protected TextReader textReader;
    private final char[] allowedCharacters;

    protected BraceTokenReader(TextReader textReader, char[] allowedCharacters) {
        this.textReader = textReader;
        this.allowedCharacters = allowedCharacters;
    }

    public boolean isApplicable() {
        char character = textReader.getCurrentCharacter();
        for (char allowedCharacter : allowedCharacters) {
            if (character == allowedCharacter) {
                return true;
            }
        }

        return false;
    }

    public abstract IToken readToken();
}

