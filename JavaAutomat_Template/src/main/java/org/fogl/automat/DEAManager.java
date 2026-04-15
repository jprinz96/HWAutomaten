package org.fogl.automat;

import java.util.Scanner;

public class DEAManager {

    private static final Scanner scan = new Scanner(System.in);





    public static void printMenu() {
        System.out.printf("""
                Willkommen beim DEA um Gleichungen zu prüfen
                Bitte wähle eine der folgenden Optionen:
                1 - Manuelle Eingabe
                2 - Lesen aus Datei
                0 - Beenden                
                """);


    }


}
