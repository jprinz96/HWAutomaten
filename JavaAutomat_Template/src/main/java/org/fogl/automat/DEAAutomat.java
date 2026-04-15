package org.fogl.automat;

import org.fogl.constants.DEAColors;
import org.fogl.constants.DEAStates;
import org.fogl.constants.DEATransition;

public class DEAAutomat {

    public static boolean DEA(String input) {
       input = removeSpaces(input);

        // Leerwort behandeln
        if (input == null || input.isBlank()) {
            return false;
        }

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


        return isValid && state == DEAStates.STATE_END;
    }

    public static String removeSpaces(String input) {
        return input.replaceAll("\\s+", "");
    }
}
