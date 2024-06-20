package eapli.base.errornotificationmanagement.repositories;

import eapli.base.errornotificationmanagement.domain.ErrorNotification;
import eapli.base.errornotificationmanagement.domain.NotificationCode;
import eapli.base.errornotificationmanagement.domain.NotificationState;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface ErrorNotificationRepository extends DomainRepository<Long, ErrorNotification> {

    Iterable<ErrorNotification> findErrorNotificationsByState(NotificationState state);
}
