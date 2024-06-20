package eapli.base.messagemanagement.application;

import eapli.base.util.ImportFile;

import java.text.ParseException;
import java.util.List;

public class ImportService implements Runnable {
    Interperter interperter = new Interperter();
    String filename;
    ImportFile importer = new ImportFile();

    public ImportService(String filename) {
        this.filename = filename;
    }

    @Override
    public void run() {
        try {
            List<String> file = importer.fileToList(filename);
            for (String line : file) {
                interperter.checkType(line);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
