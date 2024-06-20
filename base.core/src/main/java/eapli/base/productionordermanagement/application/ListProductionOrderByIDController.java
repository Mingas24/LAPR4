package eapli.base.productionordermanagement.application;

import eapli.base.productionordermanagement.domain.ProductionOrder;

import java.util.List;


public class ListProductionOrderByIDController {

    private ListProductionOrderService lprs = new ListProductionOrderService();

    public List<ProductionOrder> findProductionOrderByID(String orderID) {
        List<ProductionOrder> poList = lprs.findAllProdOrderByID(orderID);
        if (poList.isEmpty()) {
            System.out.println("Nenhuma ordem de produção encontrada");
            return poList;
        } else {
            return poList;
        }
    }
}