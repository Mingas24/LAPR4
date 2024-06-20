package eapli.base.persistence.impl.inmemory;

import eapli.base.errornotificationmanagement.domain.ErrorNotification;
import eapli.base.errornotificationmanagement.domain.NotificationCode;
import eapli.base.errornotificationmanagement.domain.NotificationState;
import eapli.base.errornotificationmanagement.repositories.ErrorNotificationRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Objects;
import java.util.Optional;

public class InMemoryNotificationErrorRepository extends InMemoryDomainRepository<Long, ErrorNotification>
        implements ErrorNotificationRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<ErrorNotification> findErrorNotificationsByState(NotificationState state) {
        return match(e -> Objects.equals(e.state().name(), state));
    }

}
