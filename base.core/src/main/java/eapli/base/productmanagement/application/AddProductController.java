package eapli.base.productmanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.domain.*;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.framework.application.UseCaseController;


@UseCaseController
public class AddProductController {

    private final ProductRepository pr = PersistenceContext.repositories().product();

    public Product newProduct(String unFabCode, String comCode, String compDesc,
                              String shortDesc,String unity,String cat){
        UniqueFabricationCode ufc = new UniqueFabricationCode(unFabCode);
        ComercialCode cc = new ComercialCode(comCode);
        CompleteDescription cd = new CompleteDescription(compDesc);
        ShortDescription sd = new ShortDescription(shortDesc);
        CategoryProduct c = new CategoryProduct(cat);
        if(unity.trim().equalsIgnoreCase("UN")) {
            Product p = new Product(ufc,cc,sd,cd, Unity.UN,c);
            return pr.save(p);
        }else if(unity.trim().equalsIgnoreCase("L")) {
            Product p = new Product(ufc,cc,sd,cd, Unity.L,c);
            return pr.save(p);
        }else if(unity.trim().equalsIgnoreCase("KG")) {
            Product p = new Product(ufc,cc,sd,cd, Unity.KG,c);
            return pr.save(p);
        }else if(unity.trim().equalsIgnoreCase("METERS")) {
            Product p = new Product(ufc,cc,sd,cd, Unity.METERS,c);
            return pr.save(p);
        }
        return null;
    }


}
