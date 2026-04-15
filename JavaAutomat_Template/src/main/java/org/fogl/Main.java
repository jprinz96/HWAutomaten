package org.fogl;

import org.fogl.automat.DEAAutomat;
import org.fogl.constants.DEAColors;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DEAAutomat.DEA("1+4=8");
        DEAAutomat.DEA("1(+4=8");

    }
}
