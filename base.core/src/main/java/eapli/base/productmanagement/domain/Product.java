package eapli.base.productmanagement.domain;

import eapli.base.categorymanagement.domain.Category;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product implements AggregateRoot<Long> {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue
    private Long id;
    @Version
    private Long version;

    @Column(unique = true, nullable = false)
    private UniqueFabricationCode unFabCode;

    @Column(unique = true, nullable = false)
    private ComercialCode comCode;

    @Column(nullable = false)
    private CompleteDescription compDesc;

    @Column(nullable = false)
    private ShortDescription shortDesc;

    @Enumerated(EnumType.STRING)
    private Unity unity;

    @Column
    private CategoryProduct category;

    @Column
    @ElementCollection
    private List<ProductionSheet> prodSheet;

    protected Product() {
    }

    public Product(UniqueFabricationCode unFabCode, ComercialCode comCode,
                   ShortDescription shortDesc,CompleteDescription compDesc,Unity unity,CategoryProduct category) {

        Preconditions.noneNull(unFabCode, comCode, compDesc, shortDesc,unity,category);
        this.unFabCode = unFabCode;
        this.comCode = comCode;
        this.compDesc = compDesc;
        this.shortDesc = shortDesc;
        this.unity=unity;
        this.category=category;
        this.prodSheet = new ArrayList<>();
    }

    public UniqueFabricationCode unFabCode() { return this.unFabCode; }

    public ComercialCode comCode() { return this.comCode; }

    public CompleteDescription compDesc() { return compDesc; }

    public ShortDescription shortDesc() { return this.shortDesc; }

    public Unity unity() { return this.unity; }

    public CategoryProduct category() { return this.category; }

    public List<ProductionSheet> prodSheet() { return prodSheet; }

    public void changeProdSheet(List<ProductionSheet> prodSheet) { this.prodSheet = prodSheet;}

    @Override
    public boolean equals(Object other) {
        return DomainEntities.areEqual(this,other);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(java.lang.Object other) {
        if (!(other instanceof Product)) {
            return false;
        }

        final Product that = (Product) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }

    @Override
    public Long identity() {
        return id;
    }

}
