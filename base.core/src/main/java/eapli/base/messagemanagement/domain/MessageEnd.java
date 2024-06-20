package eapli.base.messagemanagement.domain;

import eapli.base.machinemanagement.domain.ID;
import eapli.base.productionordermanagement.domain.ProductionOrderId;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Calendar;

@Entity
@DiscriminatorValue("S9")
public class MessageEnd extends Message {


    @Column
    private  ProductionOrderId productionOrder;

    public MessageEnd(ID id,  Calendar date, ProductionOrderId productionOrder) {
        super(id, date);
        this.productionOrder = productionOrder;
    }

    public MessageEnd() {
    }

    public ProductionOrderId getProductionOrder() {
        return productionOrder;
    }
}
