package eapli.base.rawmaterial.domain;


import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class RawMaterialInternalCode implements ValueObject, Comparable<RawMaterialInternalCode> {

    private final String rawMaterialInternalCode;

    public RawMaterialInternalCode(String rawMaterialInternalCode) {
        Preconditions.noneNull(rawMaterialInternalCode);
        this.rawMaterialInternalCode = rawMaterialInternalCode;
    }


    protected RawMaterialInternalCode() {
        this.rawMaterialInternalCode = "";

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RawMaterialInternalCode that = (RawMaterialInternalCode) o;
        return Objects.equals(rawMaterialInternalCode, that.rawMaterialInternalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rawMaterialInternalCode);
    }


    @Override
    public String toString() {
        return this.rawMaterialInternalCode;
    }

    @Override
    public int compareTo(RawMaterialInternalCode o) {
        return rawMaterialInternalCode.compareTo(o.rawMaterialInternalCode);
    }
}
