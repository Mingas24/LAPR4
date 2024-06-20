package eapli.base.productionordermanagement.domain;

import eapli.base.floormanagement.domain.Deposit;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.domain.model.ValueObject;

public class Production implements ValueObject {
    private Product product;
    private int quantity;
    private Deposit deposit;

    public Production(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product product() {
        return product;
    }

    public int quantity() {
        return quantity;
    }

    public Deposit getDeposit() {
        return this.deposit;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }
}
