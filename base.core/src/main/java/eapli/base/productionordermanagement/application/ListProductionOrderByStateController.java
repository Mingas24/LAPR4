package eapli.base.productionordermanagement.application;

import eapli.base.productionordermanagement.DTO.ProductionOrderDTO;
import eapli.base.productionordermanagement.domain.ProductionOrderState;

import java.util.List;

public class ListProductionOrderByStateController {

    //Object of class ListProductionOrderService
    private ListProductionOrderService lprs = new ListProductionOrderService();

    /**
     * Method to obtain the list of production orders at given state
     * @param state state for which we want to know the production orders
     * @return list that contains all the production orders at que required state
     */
    public List<ProductionOrderDTO> listProductionOrderAtGivenState(String state){
        //list of production orders at given state (DTO)
        //findByState returns a list
        List<ProductionOrderDTO> productionOrder = lprs.findByState(state);

        return productionOrder;
    }
}
