package eapli.base.messagemanagement.domain;

import eapli.base.machinemanagement.domain.ID;
import eapli.base.productionordermanagement.domain.ProductionOrder;
import eapli.base.productionordermanagement.domain.ProductionOrderId;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Calendar;

@Entity
@DiscriminatorValue("S0")
public class MessageBegginning extends Message  {

    private ProductionOrderId poid;

    public MessageBegginning() {
    }

    public ProductionOrderId getId() {
        return poid;
    }

    public void setId(ProductionOrderId id) {
        this.poid=id;
    }

    public MessageBegginning(ID id, Calendar date, ProductionOrderId po) {
        super(id, date);
        this.poid = po;
    }

    public ProductionOrderId productionOrderId(){
        return this.poid;
    }
}
