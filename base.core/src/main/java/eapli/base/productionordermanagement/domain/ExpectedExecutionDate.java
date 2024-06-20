package eapli.base.productionordermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class ExpectedExecutionDate implements ValueObject {

    private final Date expectedExecutionDate;

    protected ExpectedExecutionDate(){this.expectedExecutionDate = null;}

    public ExpectedExecutionDate(Date expectedExecutionDate) {
        Preconditions.noneNull(expectedExecutionDate);
        Preconditions.nonEmpty(expectedExecutionDate.toString());
        this.expectedExecutionDate = expectedExecutionDate;
    }

    public Date expectedExecutionDate() {
        return expectedExecutionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpectedExecutionDate that = (ExpectedExecutionDate) o;
        return expectedExecutionDate.equals(that.expectedExecutionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expectedExecutionDate);
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(expectedExecutionDate);
    }
}
