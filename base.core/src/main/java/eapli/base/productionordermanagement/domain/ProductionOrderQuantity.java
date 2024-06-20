package eapli.base.productionordermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ProductionOrderQuantity implements ValueObject {

    private final int quantity;

    protected ProductionOrderQuantity(){this.quantity=0;}

    public ProductionOrderQuantity(int quantity) {
        Preconditions.noneNull(quantity);
        Preconditions.isPositive(quantity);
        this.quantity = quantity;
    }

    public int quantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductionOrderQuantity that = (ProductionOrderQuantity) o;
        return quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }

    @Override
    public String toString() {
        return "ProductionOrderQuantity{" +
                "quantity=" + quantity +
                '}';
    }
}
