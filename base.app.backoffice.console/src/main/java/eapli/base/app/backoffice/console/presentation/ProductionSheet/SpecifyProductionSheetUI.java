package eapli.base.app.backoffice.console.presentation.ProductionSheet;

import eapli.base.app.backoffice.console.presentation.Product.ProductPrinter;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.application.ListProductsWithoutProductionFileController;
import eapli.base.productmanagement.application.SpecifyProductionSheetController;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.domain.ProductionSheet;
import eapli.base.productmanagement.dto.ProductDTO;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import eapli.framework.util.Console;

import java.util.ArrayList;
import java.util.List;

public class SpecifyProductionSheetUI extends AbstractUI {
    List<ProductionSheet> psl = new ArrayList<>();
    SpecifyProductionSheetController spsc = new SpecifyProductionSheetController();
    Product p;
    ProductRepository pr = PersistenceContext.repositories().product();

    @Override
    protected boolean doShow() {
        final Iterable<ProductDTO> productDTOIterable = this.spsc.listAllProducts();

        final SelectWidget<ProductDTO> selector = new SelectWidget<>
                ("Products: ", productDTOIterable, new ProductPrinter());
        selector.show();

        final ProductDTO theProduct = selector.selectedElement();

        int option = 0;
        while (option != 3) {
            option = Console.readInteger("Press 1 to add Product\nPress 2 to add RawMaterial\nPress 3 to exit");
            if (option == 1) {
                String pUFC = Console.readLine("Insert the Product Unique Fabrication Code");
                int quantity = Console.readInteger("Insert the product quantity needed");
                ProductionSheet ps = spsc.createProductionSheet(quantity, pUFC, "-");
                psl.add(ps);
            }
            if (option == 2) {
                String rwID = Console.readLine("Insert the Raw Material ID");
                int quantity = Console.readInteger("Insert the Raw Material quantity needed");
                ProductionSheet ps = spsc.createProductionSheet(quantity, "-", rwID);
                psl.add(ps);
            }
        }
        return spsc.specifyProdutionSheet(theProduct,psl);
    }

    @Override
    public String headline() {
        return "Specify Production Sheet";
    }
}
