package eapli.base.rawmaterial.domain;


import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class RawMaterialTechSheet implements ValueObject {

    private final String rawMaterialTechSheet;

    public RawMaterialTechSheet(String rawMaterialDescription) {
        Preconditions.noneNull(rawMaterialDescription);
        this.rawMaterialTechSheet = rawMaterialDescription;
    }

    protected RawMaterialTechSheet() {
        this.rawMaterialTechSheet = "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RawMaterialTechSheet that = (RawMaterialTechSheet) o;
        return Objects.equals(rawMaterialTechSheet, that.rawMaterialTechSheet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rawMaterialTechSheet);
    }

    @Override
    public String toString() {
        return this.rawMaterialTechSheet;
    }
}
