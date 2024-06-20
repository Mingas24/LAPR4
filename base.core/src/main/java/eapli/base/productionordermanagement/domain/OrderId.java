package eapli.base.productionordermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class OrderId implements ValueObject {

    private final String orderID;

    protected OrderId(){this.orderID="";}

    public OrderId(String orderID) {
        Preconditions.noneNull(orderID);
        Preconditions.nonEmpty(orderID);
        this.orderID = orderID;
    }

    public String orderID() {
        return orderID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderId orderId = (OrderId) o;
        return orderID.equals(orderId.orderID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID);
    }

    @Override
    public String toString() {
        return "OrderId{" +
                "orderID='" + orderID + '\'' +
                '}';
    }
}
