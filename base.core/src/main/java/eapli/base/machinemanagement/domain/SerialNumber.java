package eapli.base.machinemanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class SerialNumber implements ValueObject {

    private final String num;

    protected SerialNumber(){this.num="";}

    public SerialNumber(String num){
        Preconditions.noneNull(num);
        Preconditions.ensure((num.length())>6);
        Preconditions.ensure((num.length())<20);
        this.num = num;
    }

    public String serialNumber() {return num;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SerialNumber that = (SerialNumber) o;
        return Objects.equals(num, that.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    @Override
    public String toString() {
        return "Serial Number{" +
                "Serial Number='" + num + '\'' +
                '}';
    }
}
