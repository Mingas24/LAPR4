package eapli.base.machinemanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class MachineExecutionTime implements ValueObject {

    @ManyToOne
    private Machine machine;

    @Column(nullable = false)
    private Date begin;

    private Date end;

    protected MachineExecutionTime() {

    }

    public MachineExecutionTime(Machine machine, Date begin) {
        this.machine = machine;
        this.begin = begin;
    }

    public Date end() {
        return end;
    }

    public Date begin() {
        return begin;
    }

    public Machine machine() {
        return machine;
    }

    public void changeEnd(Date end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MachineExecutionTime that = (MachineExecutionTime) o;
        return Objects.equals(machine, that.machine) &&
                Objects.equals(begin, that.begin) &&
                Objects.equals(end, that.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(machine, begin, end);
    }

    @Override
    public String toString() {
        return "MachineExecutionTime{" +
                "machine=" + machine +
                ", begin=" + begin +
                ", end=" + end +
                '}';
    }
}
