package eapli.base.machinemanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ID implements ValueObject, Comparable<ID> {

    private String id;

    protected ID(){}

    public ID (String id){
        Preconditions.noneNull(id);

        this.id = id;
    }

    public String id(){return id;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ID id1 = (ID) o;
        return id == id1.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Id{" +
                "Id='" + id + '\'' +
                '}';
    }

    @Override
    public int compareTo(ID other) {
        return other.id.compareTo(id);
    }
}
