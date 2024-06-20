package eapli.base.machinemanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Brand implements ValueObject {

    private final String brand;

    protected Brand(){this.brand="";}

    public Brand(String brand){
        Preconditions.noneNull(brand);
        this.brand = brand;
    }

    public String brand(){return brand;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand1 = (Brand) o;
        return Objects.equals(brand, brand1.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand);
    }

    @Override
    public String toString(){
        return "Brand{" +
                "Brand='" + brand + '\'' +
                '}';
    }
}
