package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ComercialCode implements ValueObject {

    private final String comCode;

    protected ComercialCode() {
        this.comCode = "";
    }

    public ComercialCode(String comCode){
        Preconditions.noneNull(comCode);
        this.comCode=comCode;
    }

    public String comCode() {
        return comCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComercialCode comCode = (ComercialCode) o;
        return Objects.equals(comCode, comCode.comCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comCode);
    }

    @Override
    public String toString() {
        return "Comercial Code{" +
                "unFabCode ='" + comCode + '\'' +
                '}';
    }
}
