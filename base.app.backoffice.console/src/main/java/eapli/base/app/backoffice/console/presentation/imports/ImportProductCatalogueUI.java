package eapli.base.app.backoffice.console.presentation.imports;

import eapli.base.productmanagement.application.ImportProductCatalogueController;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.util.Console;

public class ImportProductCatalogueUI extends AbstractUI {

    private final ImportProductCatalogueController ipcc = new ImportProductCatalogueController();

    @Override
    protected boolean doShow(){
        String fileName = Console.readLine("Insert a file name:");
        try{
            ipcc.importProductCatalogueFromCSVFile(fileName);
            System.out.println("\nImported successfully!");
        }catch (final IntegrityViolationException e){
            System.out.println("ERROR");
        }
        return false;
    }

    @Override
    public String headline(){
        return "\nImport Product Catalogue";
    }

}
