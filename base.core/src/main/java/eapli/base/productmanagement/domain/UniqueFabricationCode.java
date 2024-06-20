package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;


@Embeddable
public class UniqueFabricationCode implements ValueObject {

    private final String unFabCode;

    protected UniqueFabricationCode() {
        this.unFabCode = "";
    }
    public UniqueFabricationCode(String unFabCode){
        Preconditions.noneNull(unFabCode);
        this.unFabCode=unFabCode;
    }

    public String unFabCode() {
        return unFabCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniqueFabricationCode unFabCode = (UniqueFabricationCode) o;
        return Objects.equals(unFabCode, unFabCode.unFabCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unFabCode);
    }

    @Override
    public String toString() {
        return "Unique Fabrication Code{" +
                "unFabCode ='" + unFabCode + '\'' +
                '}';
    }
}
