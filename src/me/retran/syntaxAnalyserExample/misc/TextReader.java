package me.retran.syntaxAnalyserExample.misc;

public class TextReader {
    private final String text;
    private int current;

    public TextReader(String text) {
        this.text = text;
        this.current = 0;
    }

    public char getCurrentCharacter() {
        if (isEndOfText()) {
            throw new RuntimeException("end of text");
        }
        return text.charAt(current);
    }

    public void moveNext() {
        current++;
    }

    public boolean isEndOfText() {
        return current >= text.length();
    }
}
