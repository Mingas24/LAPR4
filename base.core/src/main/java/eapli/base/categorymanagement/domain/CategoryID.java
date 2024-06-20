package eapli.base.categorymanagement.domain;


import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class CategoryID implements Comparable<CategoryID>, ValueObject {

    private final String idCategory;


    public CategoryID(String idCategory) {
        Preconditions.noneNull(idCategory);
        Preconditions.ensure(idCategory.length()<=10);
        this.idCategory = idCategory;
    }

    protected CategoryID()  {
        this.idCategory = "";
    }

    public String categoryID()  {return idCategory;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryID that = (CategoryID) o;
        return Objects.equals(idCategory, that.idCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategory);
    }

    @Override
    public String toString() {
        return "CategoryID{" +
                "idCategory='" + idCategory + '\'' +
                '}';
    }

    @Override
    public int compareTo(CategoryID o) {
        return idCategory.compareTo(o.idCategory);
    }
}
