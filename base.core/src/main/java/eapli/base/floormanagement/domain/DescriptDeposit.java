package eapli.base.floormanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class DescriptDeposit implements ValueObject {

    private final String description;

    public DescriptDeposit(final String description) {
        Preconditions.noneNull(description);
        Preconditions.ensure((description.length())<50);
        this.description = description;
    }

    protected DescriptDeposit(){
        this.description="";
    }

    public String description() { return this.description; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DescriptDeposit that = (DescriptDeposit) o;
        return description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    @Override
    public String toString() {
        return "DescriptDeposit{" +
                "description='" + description + '\'' +
                '}';
    }
}
