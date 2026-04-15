package org.fogl.automat;

import org.fogl.constants.DEAColors;
import org.fogl.constants.DEAStates;
import org.fogl.constants.DEATransition;

public class DEAAutomat {

    public static boolean DEA(String input) {
        input = input.replaceAll("\\s+", ""); //Leerzeichen behandeln

        //Leerwort wird nicht akzeptier, Prüfung:
        if (input == null || input.isBlank()) {
            System.out.println(DEAColors.ANSI_YELLOW + "Leerwort" + DEAColors.ANSI_RESET);
            return false;
        }

        //Startpunkt setzen
        char state = DEAStates.STATE_START;

        for (char c : input.toCharArray()) {
            switch (state) {
                //State Start S
                case DEAStates.STATE_START -> {
                    //Wenn 0-9 -> A
                    if (DEATransition.isNumber(c)) {
                        state = DEAStates.STATE_A;
                        //Wenn ( -> C
                    } else if (c == DEATransition.INPUT_OPEN_PARENTHESIS) {
                        state = DEAStates.STATE_C;
                    } else return false;
                }

                case DEAStates.STATE_A -> {
                    //0-9 -> A
                    if (DEATransition.isNumber(c)) {
                        state = DEAStates.STATE_A;
                    }
                    //= -> B
                    else if (c == DEATransition.INPUT_EQUAL) {
                        state = DEAStates.STATE_B;
                    }
                    //+ - * / -> S
                    else if (DEATransition.isOperator(c)) {
                        state = DEAStates.STATE_S;

                    } else return false;
                }
                case DEAStates.STATE_B -> {
                    //0-9 -> Z
                    if (DEATransition.isNumber(c)) {
                        state = DEAStates.STATE_Z;
                    } else return false;
                }
                case DEAStates.STATE_Z -> {
                    //0-9 -> Z
                    if (DEATransition.isNumber(c)) {
                        state = DEAStates.STATE_Z;
                    } else return false;
                }
                case DEAStates.STATE_C -> {
                    //0-9 -> D
                    if (DEATransition.isNumber(c)) {
                        state = DEAStates.STATE_D;
                    } else return false;
                }

                case DEAStates.STATE_D -> {
                    //0-9 -> D
                    if (DEATransition.isNumber(c)) {
                        state = DEAStates.STATE_D;
                    }
                    //+ - * / -> E
                    else if (DEATransition.isOperator(c)) {
                        state = DEAStates.STATE_E;
                    }
                    // ) -> G
                    else if (c == DEATransition.INPUT_CLOSE_PARENTHESIS) {
                        state = DEAStates.STATE_G;
                    } else return false;
                }
                case DEAStates.STATE_E -> {
                    //0-9 -> F
                    if (DEATransition.isNumber(c)) {
                        state = DEAStates.STATE_F;
                    } else return false;
                }
                case DEAStates.STATE_F -> {
                    // 0-9 -> F
                    if (DEATransition.isNumber(c)) {
                        state = DEAStates.STATE_F;
                    }
                    //+ - * / -> C
                    else if (DEATransition.isOperator(c)) {
                        state = DEAStates.STATE_C;
                    }
                    // ) -> G
                    else if (c == DEATransition.INPUT_CLOSE_PARENTHESIS) {
                        state = DEAStates.STATE_G;
                    } else return false;
                }
                case DEAStates.STATE_G -> {
                    //+ - * / -> S
                    if (DEATransition.isOperator(c)) {
                        state = DEAStates.STATE_S;
                    }
                    //= -> B
                    else if (c == DEATransition.INPUT_EQUAL) {
                        state = DEAStates.STATE_B;
                    } else return false;
                }
            }

        }
        if (state == DEAStates.STATE_END) {
            System.out.println(DEAColors.ANSI_GREEN + "Ausdruck ist korrekt: " + input + DEAColors.ANSI_RESET);
        } else {
            System.out.println(DEAColors.ANSI_RED + "Ausdruck ist falsch: " + input + DEAColors.ANSI_RESET);
        }
        return state == DEAStates.STATE_END;


    }
}
