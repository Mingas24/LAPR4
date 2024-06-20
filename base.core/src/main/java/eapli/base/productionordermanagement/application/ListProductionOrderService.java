package eapli.base.productionordermanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productionordermanagement.DTO.ProductionOrderDTO;
import eapli.base.productionordermanagement.domain.OrderId;
import eapli.base.productionordermanagement.domain.ProductionOrder;
import eapli.base.productionordermanagement.repository.ProductionOrderRepository;


import java.util.ArrayList;
import java.util.List;

public class ListProductionOrderService {

    //Object of class ProductionOrderRepository
    private final ProductionOrderRepository repo = PersistenceContext.repositories().productionOrder();


    public List<ProductionOrderDTO> findByState(String state) {

        //list that contains every production order
        Iterable<ProductionOrder> listProductionOrder = repo.findByState(state);

        //List that stores every production order dto
        List<ProductionOrderDTO> poDTO = new ArrayList<>();


        //Convert do DTO
        //for each production order that's on the repository returned iterable
        for (ProductionOrder p : listProductionOrder) {

            //Create an object of ProductionOrderDTO
            ProductionOrderDTO po = new ProductionOrderDTO(p.OrderIds(), p.ProductionOrderID().productOrderId(), p.unState().name());

            //Add to the returning list, every production order at the required state
            if (po.productionOrderState.equals(state)) {
                poDTO.add(po);
            }

        }

        if (poDTO.isEmpty()) {
            throw new NullPointerException();
        } else return poDTO;
    }


    public List<ProductionOrder> findAllProdOrderByID(String orderID) {

        List<ProductionOrder> productionOrderList = new ArrayList<>();
        Iterable<ProductionOrder> productionOrders = repo.findAll();

        for (ProductionOrder po : productionOrders) {
            if(po.OrderIds().contains(new OrderId(orderID))){
                productionOrderList.add(po);
            }
        }
        return productionOrderList;
    }
}
