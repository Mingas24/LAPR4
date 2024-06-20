package eapli.base.errornotificationmanagement.dto;

import eapli.framework.representations.dto.DTO;

import java.util.Date;

@DTO
public class ErrorNotificationDTO {

    public Long notificationID;
    public Date notificationDate;
    public String errorType;
    public String notificationState;
    public String machineId;

    public ErrorNotificationDTO(Long notificationID, Date notificationDate, String errorType, String notificationState, String machineId) {
        this.notificationID = notificationID;
        this.notificationDate = notificationDate;
        this.errorType = errorType;
        this.notificationState = notificationState;
        this.machineId = machineId;
    }

    public Long notificationID() { return notificationID; }

    public Date notificationDate() {
        return notificationDate;
    }

    public String errorType() {
        return errorType;
    }

    public String notificationState() {
        return notificationState;
    }

    public String machineId() {
        return machineId;
    }


    @Override
    public String toString() {
        return "ErrorNotificationDTO{" +
                ", notificationDate=" + notificationDate +
                ", errorType='" + errorType + '\'' +
                ", notificationState='" + notificationState + '\'' +
                ", machineId=" + machineId +
                '}';
    }
}
