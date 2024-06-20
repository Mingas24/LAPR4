package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class StandardQuantity implements ValueObject {

    private final int sq;

    protected StandardQuantity() {
        this.sq = 0;
    }

    public StandardQuantity(int sq) {
        Preconditions.noneNull(sq);
        Preconditions.ensure(sq > 0);
        this.sq = sq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StandardQuantity that = (StandardQuantity) o;
        return sq == that.sq;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sq);
    }

    @Override
    public String toString() {
        return "StandardQuantity{" +
                "sq=" + sq +
                '}';
    }
}
