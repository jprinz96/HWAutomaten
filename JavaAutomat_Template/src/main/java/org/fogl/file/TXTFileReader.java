package org.fogl.file;


import org.fogl.automat.DEAAutomat;
import org.fogl.automat.DEAManager;
import org.fogl.constants.DEAColors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class TXTFileReader {
    public static void readTXTFile(String filename) {
        try {
           Path path = Path.of("src", "main", "resources", filename);
            List<String> lines = Files.readAllLines(path);

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

        } catch (IOException e) {
            System.out.println(DEAColors.ANSI_RED + "[ERROR] Datei nicht gefunden: " + filename + DEAColors.ANSI_RESET);
        }
    }

}
