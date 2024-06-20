package eapli.base.rawmaterial.domain;


import eapli.base.categorymanagement.domain.Category;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RawMaterial implements AggregateRoot<RawMaterialInternalCode> {


    @Id
    @Column(unique = true, nullable = false)
    private RawMaterialInternalCode internalCodeRawMaterial;

    @Column(nullable = false)
    private RawMaterialDescription descriptionRawMaterial;

    @Column(nullable = false)
    private RawMaterialTechSheet techSheetRawMaterial;

    @ManyToOne
    private Category categoryRawMaterial;

    protected RawMaterial() {

    }


    public RawMaterial(RawMaterialInternalCode internalCodeRawMaterial, RawMaterialDescription descriptionRawMaterial,
                       RawMaterialTechSheet techSheetRawMaterial, Category cat) {

        this.internalCodeRawMaterial = internalCodeRawMaterial;
        this.descriptionRawMaterial = descriptionRawMaterial;
        this.techSheetRawMaterial = techSheetRawMaterial;
        this.categoryRawMaterial = cat;
    }

    public RawMaterialDescription description() { return this.descriptionRawMaterial; }

    public RawMaterialTechSheet techSheet() { return this.techSheetRawMaterial; }

    public Category categoryRawMaterial() { return this.categoryRawMaterial; }

    public RawMaterialInternalCode rawMaterialInternalCode(){ return this.internalCodeRawMaterial; }

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
        if (!(other instanceof RawMaterial)) {
            return false;
        }

        final RawMaterial that = (RawMaterial) other;
        if (this == that) {
            return true;

        }

        return identity().equals(that.identity());


    }

    @Override
    public RawMaterialInternalCode identity() {
        return internalCodeRawMaterial;
    }
}