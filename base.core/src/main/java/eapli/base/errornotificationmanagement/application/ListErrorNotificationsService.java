package eapli.base.errornotificationmanagement.application;

import eapli.base.errornotificationmanagement.domain.ErrorNotification;
import eapli.base.errornotificationmanagement.domain.ErrorType;
import eapli.base.errornotificationmanagement.domain.NotificationState;
import eapli.base.errornotificationmanagement.dto.ErrorNotificationDTO;
import eapli.base.errornotificationmanagement.repositories.ErrorNotificationRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListErrorNotificationsService {

    private final ErrorNotificationRepository repository = PersistenceContext.repositories().errorNotifications();

    public List<ErrorNotificationDTO> findErrorNotificationsByState (String state){

        Iterable<ErrorNotification> listErrorNotifs= repository.findErrorNotificationsByState(NotificationState.valueOf(state));

        List<ErrorNotificationDTO> listErrorNotifsDTO = new ArrayList<>();

        for(ErrorNotification errNot : listErrorNotifs){
            Long notificationId = errNot.identity();
            Date notificationDate = errNot.notificationDate().notificationDate();
            String errorType = errNot.errorType().name();
            String notificationState = errNot.state().name();
            String machineId = errNot.machine().machineId().id();
            ErrorNotificationDTO dto = new ErrorNotificationDTO(notificationId, notificationDate, errorType, notificationState, machineId);
            listErrorNotifsDTO.add(dto);
        }

        return listErrorNotifsDTO;
    }
}
