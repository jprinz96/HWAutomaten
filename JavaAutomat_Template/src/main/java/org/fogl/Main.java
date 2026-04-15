package org.fogl;

import org.fogl.automat.DEAAutomat;
import org.fogl.file.TXTFileReader;

public class Main {
    public static void main(String[] args) {



        DEAAutomat.DEA("1+4=5");
        DEAAutomat.DEA("1(+4=5");

    }
}
