package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class CompleteDescription implements ValueObject {
    private final String compDesc;

    protected CompleteDescription(){
        this.compDesc = "";
    }

    public CompleteDescription(String compDesc){
        Preconditions.noneNull(compDesc);
        Preconditions.ensure(compDesc.length()<=50);
        this.compDesc=compDesc;
    }

    public String compDesc() {
        return compDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompleteDescription compDesc = (CompleteDescription) o;
        return Objects.equals(compDesc, compDesc.compDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(compDesc);
    }

    @Override
    public String toString() {
        return "Completed Description{" +
                "compDesc ='" + compDesc + '\'' +
                '}';
    }
}
