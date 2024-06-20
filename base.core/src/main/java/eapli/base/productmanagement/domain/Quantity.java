package eapli.base.productmanagement.domain;

import eapli.base.rawmaterial.domain.RawMaterial;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Embeddable
public class Quantity implements ValueObject {
    private final int q;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(nullable = true)
    private final Product product;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(nullable = true)
    private final RawMaterial rw;

    protected Quantity() {
        this.q = 0;
        this.product = null;
        this.rw = null;
    }

    public Quantity(int q, Product p) {
        Preconditions.noneNull(q, p);
        Preconditions.isPositive(q);
        this.q = q;
        this.product = p;
        this.rw=null;
    }

    public Quantity(int q, RawMaterial rw) {
        Preconditions.noneNull(q, rw);
        Preconditions.isPositive(q);
        this.q = q;
        this.product = null;
        this.rw=rw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity quantity = (Quantity) o;
        return q == quantity.q;
    }

    @Override
    public int hashCode() {
        return Objects.hash(q);
    }

    @Override
    public String toString() {
        return "Quantity{" +
                "q=" + q +
                '}';
    }
}
