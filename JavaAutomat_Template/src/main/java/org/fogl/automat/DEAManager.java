package org.fogl.automat;

import org.fogl.constants.DEAColors;
import org.fogl.constants.DEAStates;
import org.fogl.file.TXTFileReader;

import java.util.Scanner;

public class DEAManager {

    private static final Scanner scan = new Scanner(System.in);

    public static void start() {
        welcome();
        while (true) {
            printMenu();
            String choice = scan.nextLine().trim();

            switch (choice) {
                case "1" -> handleManuelInput();
                case "2" -> handleFileInput();
                case "0" -> {
                    System.out.println(DEAColors.ANSI_YELLOW + "[INFO] Vielen Dank für die Nutzung des DEA, auf Wiedersehen!" + DEAColors.ANSI_RESET);
                    return;
                }
                default ->
                        System.out.println(DEAColors.ANSI_RED + "[ERROR] Ungültige Eingabe, bitte versuche es erneut." + DEAColors.ANSI_RESET);
            }

        }
    }

    public static void welcome() {
        System.out.println(DEAColors.ANSI_YELLOW + "[INFO] Willokmmen zum DEA, um Gleichungen zu prüfen!");
    }

    public static void printMenu() {
        System.out.printf(DEAColors.ANSI_YELLOW + """
                [INFO] Bitte wähle eine der folgenden Optionen:
                1 - Manuelle Eingabe
                2 - Lesen aus Datei
                0 - Beenden                
                """ + DEAColors.ANSI_RESET);
    }

    public static void handleManuelInput() {
        System.out.println(DEAColors.ANSI_YELLOW + "[INFO] Bitte gib die Gleichung ein, die geprüft werden soll:" + DEAColors.ANSI_RESET);
        String equation = scan.nextLine();

        // Leerwort behandeln
        if (equation == null) {
            System.out.println(DEAColors.ANSI_RED + "[ERROR] Leerwort wird nicht akzeptiert" + DEAColors.ANSI_RESET);
            return;
        }

        //Leerzeichen entfernen
        equation = equation.replaceAll("\\s+", "");

        if (equation.isBlank()) {
            System.out.println(DEAColors.ANSI_RED + "[ERROR] Leerwort wird nicht akzeptiert" + DEAColors.ANSI_RESET);
            return;
        }
        validEqution(equation);


    }

    public static void handleFileInput() {
        System.out.println(DEAColors.ANSI_YELLOW + "[INFO] Geben Sie den Dateinamen ein (z.B. gleichungen.txt): " + DEAColors.ANSI_RESET);
        String filename = scan.nextLine().trim();

        if (filename.isEmpty()) {
            System.out.println(DEAColors.ANSI_RED + "[ERROR] Dateiname darf nicht leer sein." + DEAColors.ANSI_RESET);
            return;
        }
        TXTFileReader.readTXTFile(filename);
    }

    public static void validEqution(String equation) {
        boolean result = DEAAutomat.DEA(equation);
        if (result) {
            System.out.println(DEAColors.ANSI_GREEN + "[SUCCESS] Der Ausdruck ist korrekt: " + equation + DEAColors.ANSI_RESET);
        } else {
            System.out.println(DEAColors.ANSI_RED + "[ERROR] Der Ausdruck ist nicht korrekt: " + equation + DEAColors.ANSI_RESET);
        }
    }


}
