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
@DiscriminatorValue("P1")
public class MessageProduction extends Message {

    @Column
    private UniqueFabricationCode product;
    private int quantity;
    private RawMaterialInternalCode rawMaterial;
    @Column
    private String lot;

    public MessageProduction(ID id, Calendar date, UniqueFabricationCode product, int quantity, String lot) {
        super(id, date);
        this.product = product;
        this.rawMaterial = null;
        this.quantity = quantity;
        this.lot = lot;
    }

    public MessageProduction(ID id, Calendar date, RawMaterialInternalCode rawMaterial, int quantity, String lot) {
        super(id, date);
        this.product = null;
        this.rawMaterial = rawMaterial;
        this.quantity = quantity;
        this.lot = lot;
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

    public MessageProduction() {
    }
}
