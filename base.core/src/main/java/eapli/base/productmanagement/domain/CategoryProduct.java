package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class CategoryProduct {

    private final String cp;

    protected CategoryProduct(){this.cp = "";}

    public CategoryProduct(String cp){
        Preconditions.noneNull(cp);
        this.cp=cp;
    }

    public String category() {
        return cp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryProduct that = (CategoryProduct) o;
        return Objects.equals(cp, that.cp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cp);
    }

    @Override
    public String toString() {
        return "CategoryProduct{" +
                "cp='" + cp + '\'' +
                '}';
    }

}
