package org.fogl.automat;

import org.fogl.constants.DEAColors;
import org.fogl.constants.DEAStates;
import org.fogl.constants.DEATransition;

public class DEAAutomat {

    public static boolean DEA(String input) {
        // Leerwort behandeln
        if (input == null || input.replaceAll("\\s+", "").isBlank()) {
            System.out.println(DEAColors.ANSI_RED + "Leerwort" + DEAColors.ANSI_RESET);
            return false;
        }

        input = input.replaceAll("\\s+", "");

        // Startpunkt setzen
        char state = DEAStates.STATE_START;
        boolean isValid = true;

        for (char c : input.toCharArray()) {
            if (!isValid) break;
            switch (state) {
                case DEAStates.STATE_START -> {
                    if (DEATransition.isNumber(c)) {
                        state = DEAStates.STATE_A;
                    } else if (c == DEATransition.INPUT_OPEN_PARENTHESIS) {
                        state = DEAStates.STATE_C;
                    } else {
                        isValid = false;
                    }
                }
                case DEAStates.STATE_A -> {
                    if (DEATransition.isNumber(c)) {
                        state = DEAStates.STATE_A;
                    } else if (c == DEATransition.INPUT_EQUAL) {
                        state = DEAStates.STATE_B;
                    } else if (DEATransition.isOperator(c)) {
                        state = DEAStates.STATE_S;
                    } else {
                        isValid = false;
                    }
                }
                case DEAStates.STATE_B -> {
                    if (DEATransition.isNumber(c)) {
                        state = DEAStates.STATE_Z;
                    } else {
                        isValid = false;
                    }
                }
                case DEAStates.STATE_Z -> {
                    if (DEATransition.isNumber(c)) {
                        state = DEAStates.STATE_Z;
                    } else {
                        isValid = false;
                    }
                }
                case DEAStates.STATE_C -> {
                    if (DEATransition.isNumber(c)) {
                        state = DEAStates.STATE_D;
                    } else {
                        isValid = false;
                    }
                }
                case DEAStates.STATE_D -> {
                    if (DEATransition.isNumber(c)) {
                        state = DEAStates.STATE_D;
                    } else if (DEATransition.isOperator(c)) {
                        state = DEAStates.STATE_E;
                    } else if (c == DEATransition.INPUT_CLOSE_PARENTHESIS) {
                        state = DEAStates.STATE_G;
                    } else {
                        isValid = false;
                    }
                }
                case DEAStates.STATE_E -> {
                    if (DEATransition.isNumber(c)) {
                        state = DEAStates.STATE_F;
                    } else {
                        isValid = false;
                    }
                }
                case DEAStates.STATE_F -> {
                    if (DEATransition.isNumber(c)) {
                        state = DEAStates.STATE_F;
                    } else if (DEATransition.isOperator(c)) {
                        state = DEAStates.STATE_C;
                    } else if (c == DEATransition.INPUT_CLOSE_PARENTHESIS) {
                        state = DEAStates.STATE_G;
                    } else {
                        isValid = false;
                    }
                }
                case DEAStates.STATE_G -> {
                    if (DEATransition.isOperator(c)) {
                        state = DEAStates.STATE_S;
                    } else if (c == DEATransition.INPUT_EQUAL) {
                        state = DEAStates.STATE_B;
                    } else {
                        isValid = false;
                    }
                }
                default -> isValid = false;
            }
        }

        if (isValid && state == DEAStates.STATE_END) {
            System.out.println(DEAColors.ANSI_GREEN + "Der Ausdruck ist korrekt: " + input + DEAColors.ANSI_RESET);
        } else {
            System.out.println(DEAColors.ANSI_RED + "Der Ausdruck ist nicht korrekt: " + input + DEAColors.ANSI_RESET);
        }

        return isValid && state == DEAStates.STATE_END;
    }
}
