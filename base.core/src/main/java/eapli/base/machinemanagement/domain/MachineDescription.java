package eapli.base.machinemanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class MachineDescription implements ValueObject {

    private final String desc;

    protected MachineDescription() { this.desc = "";}

    public MachineDescription(String desc){
        Preconditions.noneNull(desc);
        this.desc = desc;
    }

    public String machineDescription(){ return desc;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MachineDescription that = (MachineDescription) o;
        return Objects.equals(desc, that.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(desc);
    }

    @Override
    public String toString() {
        return "MachineDescription{" +
                "MachineDescription='" + desc + '\'' +
                '}';
    }
}
