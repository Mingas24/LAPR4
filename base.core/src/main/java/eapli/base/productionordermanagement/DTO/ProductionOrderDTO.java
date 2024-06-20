package eapli.base.productionordermanagement.DTO;


import eapli.base.productionordermanagement.domain.OrderId;
import eapli.base.productionordermanagement.domain.ProductionOrderState;
import eapli.framework.representations.dto.DTO;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@DTO
public class ProductionOrderDTO {

    public List<OrderId> orderID;
    public String productionOrderID;
    public String productionOrderState;

    public ProductionOrderDTO (List<OrderId> orderID, String productionOrderID, String productionOrderState){

        this.orderID = new ArrayList<>();
        this.productionOrderID = productionOrderID;
        this.productionOrderState = productionOrderState;
    }

    public List<OrderId> OrderID() {
        return orderID;
    }

    public void changeOrderID(List<OrderId> orderID) {
        this.orderID = orderID;
    }

    public String ProductionOrderID() {
        return productionOrderID;
    }

    public String ProductionOrderState() {
        return productionOrderState;
    }

    @Override
    public String toString() {
        return "ProductionOrderDTO{" +
                "orderID='" + orderID + '\'' +
                ", productionOrderID='" + productionOrderID + '\'' +
                ", productionOrderState='" + productionOrderState + '\'' +
                '}';
    }
}
