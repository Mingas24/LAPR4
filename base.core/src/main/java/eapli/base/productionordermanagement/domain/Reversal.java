package eapli.base.productionordermanagement.domain;

import eapli.base.rawmaterial.domain.RawMaterial;
import eapli.framework.domain.model.ValueObject;

public class Reversal implements ValueObject {

    private RawMaterial rawMaterial;
    private int quantity;

    public Reversal(RawMaterial rawMaterial, int quantity) {
        this.rawMaterial = rawMaterial;
        this.quantity = quantity;
    }

    public RawMaterial rawMaterial() {
        return rawMaterial;
    }

    public int quantity() {
        return quantity;
    }
}
