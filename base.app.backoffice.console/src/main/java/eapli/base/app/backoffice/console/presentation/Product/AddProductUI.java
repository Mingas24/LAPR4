package eapli.base.app.backoffice.console.presentation.Product;

import eapli.base.productmanagement.application.AddProductController;;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.util.Console;

public class AddProductUI extends AbstractUI {

    AddProductController apc = new AddProductController();


    @Override
    protected boolean doShow() {
        String pID = Console.readLine("Insert the new Product Unique Frabrication Code: ");
        String pCC = Console.readLine("Insert the new Product Comercial Code: ");
        String pCD = Console.readLine("Insert the new Product Completed Description: ");
        String pSD = Console.readLine("Insert the new Product Short Description: ");
        String pU = Console.readLine("Insert the new Product Unity: ");
        String pC = Console.readLine("Insert the new Product Category: ");
        apc.newProduct(pID,pCC,pCD,pSD,pU,pC);
        return true;
    }

    @Override
    public String headline() {
        return "Create Product";
    }
}
