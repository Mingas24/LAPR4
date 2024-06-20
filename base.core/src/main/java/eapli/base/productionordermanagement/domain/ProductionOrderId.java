package eapli.base.productionordermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ProductionOrderId implements ValueObject {

    private final String productOrderId;

    protected ProductionOrderId(){this.productOrderId = "";}

    public ProductionOrderId(String productOrderId) {
        Preconditions.noneNull(productOrderId);
        Preconditions.nonEmpty(productOrderId);
        this.productOrderId = productOrderId;
    }

    public String productOrderId() {
        return productOrderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductionOrderId that = (ProductionOrderId) o;
        return productOrderId.equals(that.productOrderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productOrderId);
    }

    @Override
    public String toString() {
        return "ProductionOrderId{" +
                "productOrderId='" + productOrderId + '\'' +
                '}';
    }
}
