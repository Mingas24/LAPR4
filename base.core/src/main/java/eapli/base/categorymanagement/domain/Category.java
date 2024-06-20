package eapli.base.categorymanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class Category implements AggregateRoot<Long> {


    @Id
    @GeneratedValue
    private Long id;
    @Version
    private Long version;

    @Column(unique = true, nullable = false)
    private CategoryID idCategory;

    @Column(nullable = false)
    private CategoryDescription descriptionCategory;


    protected Category() {

    }

    public Category(CategoryDescription descriptionCategory, CategoryID idCategory) {
        Preconditions.noneNull(descriptionCategory, idCategory);
        this.descriptionCategory = descriptionCategory;
        this.idCategory = idCategory;
    }


    public CategoryID iDCategory() {
        return idCategory;
    }

    public CategoryDescription descriptionCategory() {
        return descriptionCategory;
    }

    @Override
    public boolean equals(Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Category)) {
            return false;
        }

        final Category that = (Category) other;
        if (this == that) {
            return true;

        }

        return identity().equals(that.identity());


    }

    @Override
    public String toString() {
        return "Category{" +
                "idCategory=" + idCategory +
                ", descriptionCategory=" + descriptionCategory +
                '}';
    }


    @Override
    public Long identity() {
        return id;
    }


}
