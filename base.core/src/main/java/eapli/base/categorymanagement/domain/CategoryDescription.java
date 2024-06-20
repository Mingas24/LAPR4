package eapli.base.categorymanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;


@Embeddable
public class CategoryDescription implements ValueObject {

    private final String categoryDescription;


    public CategoryDescription(String description) {
        Preconditions.noneNull(description);
        this.categoryDescription = description;
    }

    protected CategoryDescription(){
        this.categoryDescription = "";
    }

    public String description() {
        return categoryDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDescription that = (CategoryDescription) o;
        return Objects.equals(categoryDescription, that.categoryDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryDescription);
    }

    @Override
    public String toString() {
        return "CategoryDescription{" +
                "description='" + categoryDescription + '\'' +
                '}';
    }
}
