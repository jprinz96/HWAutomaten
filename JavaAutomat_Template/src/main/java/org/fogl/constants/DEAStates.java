package org.fogl.constants;

public class DEAStates {

    public  static final char STATE_A = 'A';
    public  static final char STATE_B = 'B';
    public  static final char STATE_C = 'C';
    public  static final char STATE_D = 'D';
    public  static final char STATE_E = 'E';
    public  static final char STATE_F = 'F';
    public  static final char STATE_G = 'G';
    public  static final char STATE_S = 'S';
    public  static final char STATE_Z = 'Z';

    public static final char STATE_START = STATE_S;
    public static final char STATE_END = STATE_Z;
    public static final char STATE_INVALID = 'X';

    //private Konstruktor damit kein Objekt erstellt werden kann
    private DEAStates() {
    }
}
