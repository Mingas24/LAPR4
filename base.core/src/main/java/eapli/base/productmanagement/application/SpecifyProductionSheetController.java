package eapli.base.productmanagement.application;

import eapli.base.categorymanagement.application.CategoryController;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.domain.*;
import eapli.base.productmanagement.dto.ProductDTO;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.framework.application.UseCaseController;


import java.util.ArrayList;
import java.util.List;

@UseCaseController
public class SpecifyProductionSheetController {

    private final ListProductsService lps = new ListProductsService();

    public List<ProductDTO> listAllProducts (){
        return lps.findAllProducts();
    }

    public ProductionSheet createProductionSheet(double quant,String prodID, String rwID){
        return new ProductionSheet(quant,prodID,rwID);
    }
    public boolean specifyProdutionSheet(ProductDTO pDTO, List<ProductionSheet>psl){
        return lps.specifyProdutionSheet(pDTO,psl);
    }
}
