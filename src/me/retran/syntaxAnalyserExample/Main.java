package me.retran.syntaxAnalyserExample;

//        на вход подается строка химической формулы: H2O
//        программа должна разбить молекулы на атомы и выдать такой объект:  {H: 2, O: 1}
//        Вариант со скобками (число за скобками увеличивает все молекулы внутри скобок):
//        в случае такой формулы Mg4[ON(SO3)2]2 на выходе: {Mg: 4, O: 14, N: 2, S: 4}
//        p.s. скобки могут быть любые: [ ] , ( ) , { }

import me.retran.syntaxAnalyserExample.lexicalAnalysis.LexicalAnalyser;
import me.retran.syntaxAnalyserExample.misc.TextReader;
import me.retran.syntaxAnalyserExample.syntaxAnalysis.ExpressionNode;
import me.retran.syntaxAnalyserExample.syntaxAnalysis.SyntaxAnalyser;

public class Main {
    public static void main(String[] args) {
        String text = "Mg4[ON(SO3)2]2";

        TextReader reader = new TextReader(text);
        LexicalAnalyser lexicalAnalyser = new LexicalAnalyser(reader);
        SyntaxAnalyser syntaxAnalyser = new SyntaxAnalyser(lexicalAnalyser);
        ExpressionNode node = syntaxAnalyser.parse();
        ElementCollector collector = new ElementCollector(node);

        System.out.println(collector.collect());
    }
}
