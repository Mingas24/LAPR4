package eapli.base.persistence.impl.jpa;

import eapli.base.errornotificationmanagement.domain.ErrorNotification;
import eapli.base.errornotificationmanagement.domain.NotificationCode;
import eapli.base.errornotificationmanagement.domain.NotificationState;
import eapli.base.errornotificationmanagement.repositories.ErrorNotificationRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaErrorNotificationRepository extends BasepaRepositoryBase<ErrorNotification, Long, Long>
        implements ErrorNotificationRepository {

    public JpaErrorNotificationRepository() {
        super("id");
    }

    @Override
    public Iterable<ErrorNotification> findErrorNotificationsByState(NotificationState state) {
        final Map<String, Object> params = new HashMap<>();
        params.put("State", state);
        return match("e.state LIKE: State", params);
    }
}
