package eapli.base.productmanagement.application;

import eapli.base.productmanagement.dto.ProductDTO;

import java.util.LinkedList;
import java.util.List;

public class ListProductsWithoutProductionFileController {

    private ListProductsService lps = new ListProductsService();

    public List<ProductDTO> allProductsWithoutProductionSheet(){
        List<ProductDTO> products = lps.findProductsWithoutProductionSheet();
        return products;
    }
}
