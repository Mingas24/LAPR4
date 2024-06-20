package eapli.base.messagemanagement.domain;

import eapli.base.floormanagement.domain.DepositID;
import eapli.base.machinemanagement.domain.ID;
import eapli.base.productmanagement.domain.UniqueFabricationCode;
import eapli.base.rawmaterial.domain.RawMaterialInternalCode;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Calendar;

@Entity
@DiscriminatorValue("P2")
public class MessageReversal extends Message {


    @Column
    private RawMaterialInternalCode rawMaterial;
    private int quantity;
    private DepositID deposit;

    public MessageReversal(ID id, Calendar date, RawMaterialInternalCode rawMaterial, int quantity, DepositID deposit) {
        super(id, date);
        this.rawMaterial = rawMaterial;
        this.quantity = quantity;
        this.deposit = deposit;
    }

    public RawMaterialInternalCode getRawMaterial() {
        return rawMaterial;
    }

    public int getQuantity() {
        return quantity;
    }

    public DepositID getDeposit() {
        return deposit;
    }

    public MessageReversal() {
    }
}
