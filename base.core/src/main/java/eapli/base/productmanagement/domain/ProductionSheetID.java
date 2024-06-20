package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ProductionSheetID implements ValueObject {

    private final String prodSheetID;

    protected ProductionSheetID(){ this.prodSheetID = "";
    }

    public ProductionSheetID(String prodSheetID){
        Preconditions.noneNull(prodSheetID);
        this.prodSheetID=prodSheetID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductionSheetID that = (ProductionSheetID) o;
        return Objects.equals(prodSheetID, that.prodSheetID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodSheetID);
    }

    @Override
    public String toString() {
        return "ProductionSheetID{" +
                "prodSheetID='" + prodSheetID + '\'' +
                '}';
    }
}
