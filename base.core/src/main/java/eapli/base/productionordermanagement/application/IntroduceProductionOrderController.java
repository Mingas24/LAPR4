package eapli.base.productionordermanagement.application;


import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productionordermanagement.repository.ProductionOrderRepository;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.application.UseCaseController;

import java.util.Date;
import java.util.List;

@UseCaseController
public class IntroduceProductionOrderController {

    ProductionOrderService svc = new ProductionOrderService();
    ProductionOrderRepository repository = PersistenceContext.repositories().productionOrder();

    public boolean createProductionOrder(String productionOrderID, Date emissionDate, Date expectedExecutionDate,
                                         String prodUniqueFabCode, int quantity, String unity, List<String> orderIds) {

            return svc.createProductionOrder(productionOrderID, emissionDate, expectedExecutionDate,
                    prodUniqueFabCode, quantity, unity, orderIds);
    }

    public boolean validateProductionOrderID(String productionOrderID){
        return !repository.findProductionOrderByProductionOrderId(productionOrderID).isPresent();
    }

    public boolean validateExpectedExecutionDate(Date emissionDate, Date expectedExecutionDate){
        return !expectedExecutionDate.before(emissionDate);
    }

    public boolean checkProduct(String prodUniFabCode){
        Product product = svc.checkProduct(prodUniFabCode);
        if(product != null){
            return true;
        }
        return false;
    }

    public boolean checkProductionSheet(String prodUniFabCode){
        return svc.checkProduct(prodUniFabCode).prodSheet().isEmpty();
    }

    public boolean validateUnity(String unity){
        if(unity.trim().equalsIgnoreCase("UN") || unity.trim().equalsIgnoreCase("KG")
        || unity.trim().equalsIgnoreCase("L") || unity.trim().equalsIgnoreCase("METERS")){
            return true;
        }
        return false;
    }

}
