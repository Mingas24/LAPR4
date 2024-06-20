package eapli.base.messagemanagement.domain;

import eapli.base.floormanagement.domain.DepositID;
import eapli.base.machinemanagement.domain.ID;
import eapli.base.productmanagement.domain.UniqueFabricationCode;
import eapli.base.rawmaterial.domain.RawMaterialInternalCode;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@DiscriminatorValue("C0")
public class MessageConsume extends Message {

    @Column
    private UniqueFabricationCode product;
    private RawMaterialInternalCode rawMaterial;
    private int quantity;
    private DepositID deposit;

    public MessageConsume(ID idasd, Calendar date, UniqueFabricationCode product, int quantity, DepositID deposit) {
        super(idasd, date);
        this.product = product;
        this.rawMaterial = null;
        this.quantity = quantity;
        this.deposit = deposit;
    }

    public MessageConsume(ID id, Calendar date, RawMaterialInternalCode rawMaterial, int quantity, DepositID deposit) {
        super(id, date);
        this.product = null;
        this.rawMaterial = rawMaterial;
        this.quantity = quantity;
        this.deposit = deposit;
    }

    public UniqueFabricationCode getProduct() {
        return product;
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

    public MessageConsume() {
    }
}
