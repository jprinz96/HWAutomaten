package org.fogl.file;

import org.fogl.automat.DEAAutomat;
import org.fogl.constants.DEAColors;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class TXTFileReader {
    public static void readTXTFile(String filename) {
        try {
           Path path = Path.of("src", "main", "resources", filename);
            List<String> lines = Files.readAllLines(path);

            for (String line : lines) {
                line = line.trim();

                //Auf leere Zeilen prüfen
                if (line.isEmpty()) {
                    continue;
                }
                DEAAutomat.DEA(line);
            }

        } catch (IOException e) {
            throw new RuntimeException("Fehler beim Lesen der Datei: " + filename, e);
        }
    }

}
