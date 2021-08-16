package me.retran.syntaxAnalyserExample.lexicalAnalysis;

import me.retran.syntaxAnalyserExample.misc.TextReader;

public final class ElementTokenReader implements ITokenReader {
    protected TextReader textReader;

    public ElementTokenReader(TextReader textReader) {
        this.textReader = textReader;
    }

    public boolean isApplicable() {
        boolean character = Character.isLetter(textReader.getCurrentCharacter())
                && Character.isUpperCase(textReader.getCurrentCharacter());
        return character;
    }

    public IToken readToken() {
        StringBuilder sb = new StringBuilder();

        // todo validate
        sb.append(textReader.getCurrentCharacter());
        textReader.moveNext();

        while (!textReader.isEndOfText()
                && Character.isLetter(textReader.getCurrentCharacter())
                && Character.isLowerCase(textReader.getCurrentCharacter())) {
            sb.append(textReader.getCurrentCharacter());
            textReader.moveNext();
        }

        return new ElementToken(sb.toString());
    }
}
