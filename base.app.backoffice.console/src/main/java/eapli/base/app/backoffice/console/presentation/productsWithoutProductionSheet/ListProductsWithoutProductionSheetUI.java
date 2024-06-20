package eapli.base.app.backoffice.console.presentation.productsWithoutProductionSheet;

import eapli.base.productmanagement.application.ListProductsWithoutProductionFileController;
import eapli.base.productmanagement.dto.ProductDTO;
import eapli.framework.presentation.console.AbstractUI;

public class ListProductsWithoutProductionSheetUI extends AbstractUI {

    private final ListProductsWithoutProductionFileController lpwpfc = new ListProductsWithoutProductionFileController();

    @Override
    protected boolean doShow() {
        for (ProductDTO product : lpwpfc.allProductsWithoutProductionSheet()) {
            System.out.println(product.toString());
        }
        return true;
    }

    @Override
    public String headline() {
        return "\n List of Products Without Production Sheet";
    }
}