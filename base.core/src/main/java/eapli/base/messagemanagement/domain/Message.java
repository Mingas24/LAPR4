package eapli.base.messagemanagement.domain;

import eapli.base.machinemanagement.domain.ID;
import eapli.base.machinemanagement.domain.ProductionLine;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
public abstract class Message implements AggregateRoot<Long> {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private Long pk;

    @AttributeOverride(name = "idMac", column = @Column(name = "Criar"))
    private ID idMac;
    @Column
    private Calendar date;
    private MessageStatus status;

    @ManyToOne
    private ProductionLine productionLine;


    public Message() {
    }

    public Message(ID idMac, Calendar date) {
        this.idMac = idMac;
        this.date = date;
        this.status = MessageStatus.NOTPROCESSED;
    }

    public void changeStatus() {
        this.status = MessageStatus.PROCESSED;
    }

    public ID idMac() {
        return this.idMac;
    }

    public Calendar date(){
        return this.date;
    }

    public void setProductionLine(ProductionLine productionLine) {
        this.productionLine = productionLine;
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
        return false;
    }

    @Override
    public Long identity() {
        return pk;
    }
}
