package eapli.base.rawmaterial.domain;


import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class RawMaterialDescription implements ValueObject {

    private final String rawMaterialDescription;


    public RawMaterialDescription(String description) {
        Preconditions.noneNull(description);
        this.rawMaterialDescription = description;
    }

    protected RawMaterialDescription() {
        this.rawMaterialDescription = "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RawMaterialDescription that = (RawMaterialDescription) o;
        return Objects.equals(rawMaterialDescription, that.rawMaterialDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rawMaterialDescription);
    }

    @Override
    public String toString() {
        return this.rawMaterialDescription;
    }
}
