package eapli.base.errornotificationmanagement.application;

import eapli.base.errornotificationmanagement.domain.NotificationState;
import eapli.base.errornotificationmanagement.dto.ErrorNotificationDTO;
import eapli.framework.application.UseCaseController;

import java.util.List;

@UseCaseController
public class ListFiledErrorNotificationsController {

    private ListErrorNotificationsService svc = new ListErrorNotificationsService();

    public List<ErrorNotificationDTO> listFiledErrorNotifications(){
        return svc.findErrorNotificationsByState(NotificationState.FILED.name());
    }
}
