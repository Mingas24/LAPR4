package eapli.base.productmanagement.domain;

import eapli.framework.validations.Preconditions;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ShortDescription implements ValueObject {
    private final String shortDesc;

    protected ShortDescription(){
        this.shortDesc = "";
    }

    public ShortDescription(String shortDesc){
        Preconditions.noneNull(shortDesc);
        Preconditions.ensure(shortDesc.length()<=50);
        this.shortDesc=shortDesc;
    }

    public String shortDesc() {
        return shortDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShortDescription shortDesc = (ShortDescription) o;
        return Objects.equals(shortDesc, shortDesc.shortDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shortDesc);
    }

    @Override
    public String toString() {
        return "Short Description{" +
                "shortDesc ='" + shortDesc + '\'' +
                '}';
    }
}
