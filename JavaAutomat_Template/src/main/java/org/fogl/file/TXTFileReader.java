package org.fogl.file;


import org.fogl.automat.DEAAutomat;
import org.fogl.automat.DEAManager;
import org.fogl.constants.DEAColors;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;


public class TXTFileReader {
    public static void readTXTFile(String filename) {
        try {
            InputStream is = TXTFileReader.class.getResourceAsStream("/" + filename);
            if (is == null) {
                System.out.println(DEAColors.ANSI_RED + "[ERROR] Datei nicht gefunden: " + filename + DEAColors.ANSI_RESET);
                return;
            }
            List<String> lines = new BufferedReader(new InputStreamReader(is)).lines().toList();

            for (String line : lines) {
                line = line.trim();

                // Leerzeichen entfernen
                line = DEAAutomat.removeSpaces(line);

                //Auf leere Zeilen prüfen
                if (line.isEmpty()) {
                    continue;
                }
                DEAManager.validateEqution(line);
            }

        } catch (Exception e) {
            System.out.println(DEAColors.ANSI_RED + "[ERROR] Fehler beim Lesen der Datei: " + filename + DEAColors.ANSI_RESET);
        }
    }

}
