package eapli.base.errornotificationmanagement.application;

import eapli.base.errornotificationmanagement.domain.NotificationState;
import eapli.base.errornotificationmanagement.dto.ErrorNotificationDTO;
import eapli.framework.application.UseCaseController;

import java.util.List;

@UseCaseController
public class ListUnhandledErrorNotificationsController {

    private ListErrorNotificationsService svc = new ListErrorNotificationsService();

    public List<ErrorNotificationDTO> listUnhandledErrorNotifications (){
        return svc.findErrorNotificationsByState(NotificationState.UNHANDLED.name());
    }
}
