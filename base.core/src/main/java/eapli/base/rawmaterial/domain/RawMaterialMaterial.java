package eapli.base.rawmaterial.domain;


import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class RawMaterialMaterial implements ValueObject {

    private final String rawMaterialMaterial;

    public RawMaterialMaterial(String rawMaterialMaterial) {
        Preconditions.noneNull(rawMaterialMaterial);
        this.rawMaterialMaterial = rawMaterialMaterial;
    }

    protected RawMaterialMaterial() {
        this.rawMaterialMaterial = "";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RawMaterialMaterial that = (RawMaterialMaterial) o;
        return Objects.equals(rawMaterialMaterial, that.rawMaterialMaterial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rawMaterialMaterial);
    }

    @Override
    public String toString() {
        return "RawMaterialMaterial{" +
                "rawMaterialMaterial='" + rawMaterialMaterial + '\'' +
                '}';
    }
}
