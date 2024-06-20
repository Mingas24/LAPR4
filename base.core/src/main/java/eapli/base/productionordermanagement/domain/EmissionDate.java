package eapli.base.productionordermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class EmissionDate implements ValueObject {

    private final Date emissionDate;

    protected EmissionDate(){this.emissionDate = null;}

    public EmissionDate(Date emissionDate) {
        Preconditions.noneNull(emissionDate);
        Preconditions.nonEmpty(emissionDate.toString());
        this.emissionDate = emissionDate;
    }

    public Date emissionDate() {
        return emissionDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmissionDate that = (EmissionDate) o;
        return emissionDate.equals(that.emissionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emissionDate);
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(emissionDate);
    }
}
