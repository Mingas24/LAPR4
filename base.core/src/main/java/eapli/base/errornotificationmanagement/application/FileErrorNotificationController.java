package eapli.base.errornotificationmanagement.application;

import eapli.base.errornotificationmanagement.domain.ErrorNotification;
import eapli.base.errornotificationmanagement.domain.NotificationState;
import eapli.base.errornotificationmanagement.dto.ErrorNotificationDTO;
import eapli.base.errornotificationmanagement.repositories.ErrorNotificationRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;

@UseCaseController
public class FileErrorNotificationController {

    private final ErrorNotificationRepository repository = PersistenceContext.repositories().errorNotifications();

    public boolean fileErrorNotification(ErrorNotificationDTO errorNotificationDTO){

        if(repository.containsOfIdentity(errorNotificationDTO.notificationID)){
            ErrorNotification errorNotification = repository.ofIdentity(errorNotificationDTO.notificationID).get();
            errorNotification.changeState(NotificationState.FILED);
            repository.save(errorNotification);
            return true;
        }
        return false;
    }

}
