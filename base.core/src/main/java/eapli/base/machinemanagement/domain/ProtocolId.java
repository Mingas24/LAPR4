package eapli.base.machinemanagement.domain;


import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ProtocolId implements ValueObject, Comparable<ProtocolId> {

    private int protId;

    protected ProtocolId(){}

    public ProtocolId (int protId){
        Preconditions.noneNull(protId);
        this.protId = protId;
    }

    public int protocolId(){return protId;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProtocolId that = (ProtocolId) o;
        return protId == that.protId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(protId);
    }

    @Override
    public String toString() {
        return "ProtocolId{" +
                "id=" + protId +
                '}';
    }

    @Override
    public int compareTo(ProtocolId o) {
        return 0;
    }
}
