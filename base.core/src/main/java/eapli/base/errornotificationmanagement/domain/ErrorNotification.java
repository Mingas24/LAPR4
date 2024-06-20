package eapli.base.errornotificationmanagement.domain;

import eapli.base.machinemanagement.domain.Machine;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;


@Entity
public class ErrorNotification implements AggregateRoot<Long> {

    @Id
    @GeneratedValue
    private Long id;
    @Version
    private Long version;

    @Temporal(TemporalType.DATE)
    private NotificationDate notificationDate;

    @Enumerated(EnumType.STRING)
    private ErrorType errorType;

    @Enumerated(EnumType.STRING)
    private NotificationState state;

    @ManyToOne()
    private Machine machine;

    protected ErrorNotification(){

    }



    public ErrorNotification(NotificationDate notificationDate, ErrorType errorType) {
        super();
        this.notificationDate = notificationDate;
        this.errorType = errorType;
        this.state = NotificationState.UNHANDLED;
    }


    public NotificationDate notificationDate() {
        return notificationDate;
    }

    public ErrorType errorType() {
        return errorType;
    }

    public Machine machine() {
        return machine;
    }

    public void changeMachine(Machine machine) {
        this.machine = machine;
    }

    public void changeState(NotificationState state) {
        this.state = state;
    }

    public NotificationState state() {
        return state;
    }

    @Override
    public boolean equals(Object other) {
        return DomainEntities.areEqual(this,other);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }


    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof ErrorNotification)) {
            return false;
        }

        final ErrorNotification that = (ErrorNotification) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }

    @Override
    public Long identity() {return id;}


    @Override
    public String toString() {
        return "ErrorNotification{" +
                "id=" + id +
                ", version=" + version +
                ", notificationDate=" + notificationDate +
                ", errorType=" + errorType +
                ", state=" + state +
                ", machine=" + machine +
                '}';
    }
}
