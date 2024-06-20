package eapli.base.machinemanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Type implements ValueObject {

    private final String type;

    protected Type(){this.type = "";}

    public Type(String type){
        Preconditions.noneNull(type);
        this.type = type;
    }

    public String type(){return type;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type1 = (Type) o;
        return Objects.equals(type, type1.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return "Machine Type{" +
                "Machine Type='" + type + '\'' +
                '}';
    }
}
