package eapli.base.app.backoffice.console.presentation.imports;

import eapli.base.productionordermanagement.application.ImportProductionOrdersController;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.util.Console;

public class ImportProductionOrdersUI extends AbstractUI {

    private final ImportProductionOrdersController ipoc = new ImportProductionOrdersController();


    @Override
    protected boolean doShow() {
        String fileName = Console.readLine("Insert a file name:");
        try {
            ipoc.importProductionOrdersFromCSVFile(fileName);
            System.out.println("\nImported successfully!");
        } catch (final IntegrityViolationException e) {
            System.out.println("ERROR");
        }
        return false;
    }

    @Override
    public String headline() {
        return "\nImport Production Orders";
    }
}
