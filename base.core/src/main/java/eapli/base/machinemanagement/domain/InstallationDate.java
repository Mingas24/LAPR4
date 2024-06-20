package eapli.base.machinemanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class InstallationDate implements ValueObject {

    private final LocalDate date;

    protected InstallationDate(){this.date=null;}

    public InstallationDate(LocalDate date){
        Preconditions.noneNull(date);
        Preconditions.ensure(date.isBefore(LocalDate.now()));
        this.date = date;
    }

    public LocalDate date(){return date;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstallationDate that = (InstallationDate) o;
        return Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }

    @Override
    public String toString() {
        return date.toString();
    }
}
