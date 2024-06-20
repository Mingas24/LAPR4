package eapli.base.productmanagement.domain;

import eapli.base.productmanagement.application.AddProductController;

import java.util.List;

public class ImportProductCatalogue {
    private static final String csvSplitBy = ";";

    private final AddProductController apc = new AddProductController();

    public boolean loadProductsFromCSV(List<String> fileLines) {
        for (String line : fileLines.subList(1, fileLines.size())) { //skips header
                String[] product = line.split(csvSplitBy);
                apc.newProduct(product[0], product[1], product[2], product[3], product[4], product[5]);
        }
        return true;
    }
}
