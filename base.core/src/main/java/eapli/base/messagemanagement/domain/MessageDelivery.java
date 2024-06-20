package eapli.base.messagemanagement.domain;

import eapli.base.floormanagement.domain.DepositID;
import eapli.base.machinemanagement.domain.ID;
import eapli.base.productmanagement.domain.UniqueFabricationCode;
import eapli.base.rawmaterial.domain.RawMaterialInternalCode;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Calendar;

@Entity
@DiscriminatorValue("C9")
public class MessageDelivery extends Message {


    @Column
    private UniqueFabricationCode product;
    private int quantity;
    private DepositID deposit;

    public MessageDelivery(ID id, Calendar date, UniqueFabricationCode product, int quantity, DepositID deposit) {
        super(id, date);
        this.product = product;
        this.quantity = quantity;
        this.deposit = deposit;
    }


    public UniqueFabricationCode getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public DepositID getDeposit() {
        return deposit;
    }

    public MessageDelivery() {
    }
}
