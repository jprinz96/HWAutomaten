package org.fogl.file;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class TXTFileReader {


    public static void readTXTFile(String filename) {
        Path path = Paths.get("src","main", "resources", filename);
        if (Files.notExists(path)) {
            System.err.println("File " + filename + " does not exist: " + path.toAbsolutePath());
        }

       // try {

       // }
    }

}
