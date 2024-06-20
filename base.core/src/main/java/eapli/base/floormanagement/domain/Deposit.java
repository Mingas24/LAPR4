package eapli.base.floormanagement.domain;

import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.domain.Quantity;
import eapli.base.rawmaterial.domain.RawMaterial;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;


@Entity
public class Deposit implements AggregateRoot<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    @Version
    private Long version;

    @Column(unique = true, nullable = false)
    private DepositID depositId;

    @Enumerated(EnumType.STRING)
    private DepositType typeDeposit;

    @Column(nullable = false)
    private DescriptDeposit descriptDeposit;

    protected Deposit() {

    }

    public Deposit(DepositID depositId, DepositType typeDeposit, DescriptDeposit descriptDeposit) {
        Preconditions.noneNull(depositId, typeDeposit, descriptDeposit);
        this.depositId = depositId;
        this.typeDeposit = typeDeposit;
        this.descriptDeposit = descriptDeposit;
    }


    public DepositID depositId() {
        return this.depositId;
    }

    public DepositType typeDeposit() {
        return this.typeDeposit;
    }

    public DescriptDeposit descriptDeposit() {
        return descriptDeposit;
    }

    @Override
    public boolean equals(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(java.lang.Object other) {
        if (!(other instanceof Deposit)) {
            return false;
        }

        final Deposit that = (Deposit) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }

    @Override
    public Long identity() {
        return id;
    }

}
