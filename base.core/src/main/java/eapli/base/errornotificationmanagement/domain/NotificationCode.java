package eapli.base.errornotificationmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.general.domain.model.Designation;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class NotificationCode implements ValueObject, Comparable<NotificationCode> {

    private final String notificationCode;

    protected NotificationCode (){notificationCode = "";}

    public NotificationCode(String notificationCode) {
        this.notificationCode = notificationCode;
    }

    public String notificationCode() {
        return notificationCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationCode that = (NotificationCode) o;
        return notificationCode.equals(that.notificationCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notificationCode);
    }

    @Override
    public String toString() {
        return "NotificationCode{" +
                "notificationCode='" + notificationCode + '\'' +
                '}';
    }

    @Override
    public int compareTo(NotificationCode o) {
        return this.notificationCode.compareTo(o.notificationCode);
    }

}
