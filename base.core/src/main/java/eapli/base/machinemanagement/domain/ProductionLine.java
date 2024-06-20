package eapli.base.machinemanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
public class ProductionLine implements AggregateRoot<ProductionLineID> {

    @Id
    @Column(unique = true, nullable = false)
    private ProductionLineID plID;
    @OneToMany
    @OrderColumn
    private List<Machine> order = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private ProductionLineProcessingState state;

    private Calendar lastMessageProcessing;

    protected ProductionLine() {

    }

    public ProductionLine(ProductionLineID plID) {
        Preconditions.noneNull(plID);
        this.plID = plID;
        this.order = new ArrayList<>();
        this.state = ProductionLineProcessingState.DEACTIVATED;
    }

    public ProductionLineID plID() {
        return this.plID;
    }

    public ProductionLineProcessingState state() {
        return state;
    }

    public void changeState(ProductionLineProcessingState state) {
        this.state = state;
    }

    public Calendar lastMessageProcessing() {
        return lastMessageProcessing;
    }

    public void changeLastMessageProcessing(Calendar lastMessageProcessing) {
        this.lastMessageProcessing = lastMessageProcessing;
    }

    public boolean AddMachineToDefault(Machine machine) {
        this.order.add(machine);
        return true;
    }

    public boolean AddMachineSpecific(Machine machine, int pos) {
        this.order.add(pos, machine);
        return true;
    }

    public List<Machine> order() {
        return this.order;
    }

    @Override
    public boolean equals(Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Machine)) {
            return false;
        }
        final ProductionLine that = (ProductionLine) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }

    @Override
    public ProductionLineID identity() {
        return plID;
    }
}
