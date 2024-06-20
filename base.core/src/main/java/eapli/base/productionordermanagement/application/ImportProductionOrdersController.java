package eapli.base.productionordermanagement.application;

import eapli.base.productionordermanagement.domain.ImportProductionOrders;
import eapli.base.util.ImportFile;
import eapli.framework.application.UseCaseController;

import java.util.List;

@UseCaseController
public class ImportProductionOrdersController {
    private final ImportProductionOrders ipo = new ImportProductionOrders();
    private final ImportFile imp = new ImportFile();

    public boolean importProductionOrdersFromCSVFile(String filename) {
        List<String> fileLines = imp.fileToList(filename);
        boolean load = ipo.loadProductionOrdersFromCSV(fileLines);
        return load;
    }
}
