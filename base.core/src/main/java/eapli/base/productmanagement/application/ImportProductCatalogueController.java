package eapli.base.productmanagement.application;

import eapli.base.util.ImportFile;
import eapli.base.productmanagement.domain.ImportProductCatalogue;
import eapli.framework.application.UseCaseController;

import java.util.List;

@UseCaseController
public class ImportProductCatalogueController {

    private final ImportProductCatalogue ipc = new ImportProductCatalogue();
    private final ImportFile imp = new ImportFile();

    public boolean importProductCatalogueFromCSVFile(String fileName) {
        List<String> fileLines = imp.fileToList(fileName);
        boolean load = ipc.loadProductsFromCSV(fileLines);
        return load;
    }
}
