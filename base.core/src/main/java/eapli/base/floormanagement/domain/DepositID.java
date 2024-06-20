package eapli.base.floormanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class DepositID implements ValueObject {

    private final String depositId;

    protected DepositID(){
        this.depositId = "";
    }

    public DepositID(String depositId) {
        Preconditions.noneNull(depositId);
        Preconditions.ensure((depositId.length())<=10);
        this.depositId = depositId;
    }

    public String depositId() {return depositId;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepositID depositID = (DepositID) o;
        return Objects.equals(depositId, depositID.depositId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(depositId);
    }

    @Override
    public String toString() {
        return "DepositID{" +
                "depositId='" + depositId + '\'' +
                '}';
    }
}
