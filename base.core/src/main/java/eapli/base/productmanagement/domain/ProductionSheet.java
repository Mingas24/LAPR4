package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.DomainEntity;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.*;

@Embeddable
public class ProductionSheet implements ValueObject {


    //private final Set<Quantity> setQ  = new HashSet();
    private double quant;

    private String prodID;

    private String rwID;

    protected ProductionSheet() {
    }

    public ProductionSheet(double quant,String prodID, String rwID){
        //Preconditions.nonEmpty(quantList,prodList,rwList);
        this.quant = quant;
        this.prodID = prodID;
        this.rwID = rwID;
    }

    public double quantity() {
        return quant;
    }

    public String productID() {
        return prodID;
    }

    public String rawMaterialID() {
        return rwID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductionSheet that = (ProductionSheet) o;
        return Double.compare(that.quant, quant) == 0 &&
                Objects.equals(prodID, that.prodID) &&
                Objects.equals(rwID, that.rwID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quant, prodID, rwID);
    }

    @Override
    public String toString() {
        return "ProductionSheet{" +
                "quant=" + quant +
                ", prodID='" + prodID + '\'' +
                ", rwID='" + rwID + '\'' +
                '}';
    }
}
