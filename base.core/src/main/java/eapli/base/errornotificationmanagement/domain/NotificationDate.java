package eapli.base.errornotificationmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class NotificationDate implements ValueObject {

    private final Date notificationDate;

    protected NotificationDate (){this.notificationDate = null;}

    public NotificationDate(Date notificationDate) {
        this.notificationDate = notificationDate;
    }

    public Date notificationDate() {
        return notificationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationDate that = (NotificationDate) o;
        return notificationDate.equals(that.notificationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notificationDate);
    }

    @Override
    public String toString() {
        return "NotificationDate{" +
                "notificationDate=" + notificationDate +
                '}';
    }
}
