package eapli.base.machinemanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ProductionLineID implements ValueObject, Comparable<ProductionLineID> {

    private final String plID;

    protected ProductionLineID() {this.plID="";}

    public ProductionLineID(String plID){
        Preconditions.noneNull(plID);
        this.plID = plID;
    }

    public String productionLineID() { return plID;}

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductionLineID plID = (ProductionLineID) o;
        return Objects.equals(plID, plID.productionLineID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(plID);
    }

    @Override
    public String toString() {
        return "ProductionLineID{" +
                "productionLineID='" + plID + '\'' +
                '}';
    }

    @Override
    public int compareTo(ProductionLineID o) {
        return plID.compareTo(o.plID);
    }
}
