package org.fogl.automat;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAutomat {
    @Test
    public void testSimpleEquation() {
        assertTrue(DEAAutomat.DEA("5=7"));
    }
    @Test
    public void testEquationWithBrackets() {
        assertTrue(DEAAutomat.DEA("(3*4)+2=14"));
    }
    @Test
    public void testEquationWithSpace() {
        assertTrue(DEAAutomat.DEA(" ( 3 * 4 ) + 2 = 14 "));
    }
    @Test
    public void testEmptyInput() {
        assertFalse(DEAAutomat.DEA(""));
    }

    @Test
    public void testInvalidCharacter() {
        Assertions.assertFalse(DEAAutomat.DEA("09a*8=1"));
    }

    @Test
    public void testMissingRightSide(){
        assertFalse(DEAAutomat.DEA("3*4+2="));
    }


}
