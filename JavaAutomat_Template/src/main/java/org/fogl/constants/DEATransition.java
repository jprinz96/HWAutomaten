package org.fogl.constants;

public class DEATransition {
    public static final String INPUT_EMPTY = "";
    public static final char INPUT_EQUAL = '=';
    public static final char INPUT_OPEN_PARENTHESIS = '(';
    public static final char INPUT_CLOSED_PARENTHESIS = ')';
    public static final char INPUT_PLUS = '+';
    public static final char INPUT_MINUS = '-';
    public static final char INPUT_MULTIPLY = '*';
    public static final char INPUT_DIVIDE = '/';


    //Konstruktor damit kein Objekt erstellt werden kann
    private DEATransition(){}

    //Prüft ob eingabe eine Zahl ist
    public static boolean isNumber(char c){
        return Character.isDigit(c);
    }

    //Prüft ob eingabe ein Operator ist
    public static boolean isOperator(char c){
        return c == INPUT_PLUS
                || c == INPUT_MINUS
                || c == INPUT_MULTIPLY 
                || c == INPUT_DIVIDE;
    }




}
