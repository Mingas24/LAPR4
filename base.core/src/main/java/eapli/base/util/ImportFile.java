package eapli.base.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ImportFile {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImportFile.class);

    public List<String> fileToList(String fileName) {
        List<String> fileLines = new LinkedList<>();

        BufferedReader reader;
        String line;

        try {
            reader = new BufferedReader(new FileReader(fileName));
            while ((line = reader.readLine()) != null) {
                fileLines.add(line);
            }
        } catch (IOException e) {
            LOGGER.error("An exeption ocurred during file import-" + e);
        }
        return fileLines;
    }
}
