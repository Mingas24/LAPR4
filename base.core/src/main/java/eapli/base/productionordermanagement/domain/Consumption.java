package eapli.base.productionordermanagement.domain;

import eapli.base.productmanagement.domain.Product;
import eapli.base.rawmaterial.domain.RawMaterial;
import eapli.framework.domain.model.ValueObject;


public class Consumption implements ValueObject {

    private RawMaterial rawMaterial;
    private Product product;

    private int quantity;

    public Consumption(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Consumption(RawMaterial rawMaterial, int quantity) {
        this.rawMaterial = rawMaterial;
        this.quantity = quantity;
    }

    public int quantity() {
        return this.quantity;
    }

    public Product product() {
        return this.product;
    }

    public RawMaterial rawMaterial() {
        return this.rawMaterial;
    }
}
