package eapli.base.app.backoffice.console.presentation.errorNotifications;

import eapli.base.errornotificationmanagement.dto.ErrorNotificationDTO;
import eapli.framework.visitor.Visitor;

public class ErrorNotificationPrinter implements Visitor<ErrorNotificationDTO> {
    @Override
    public void visit(ErrorNotificationDTO visitee) {
        System.out.printf("Error Notification{" +
                " Date= " + visitee.notificationDate() + " Type= " + visitee.errorType() + " Machine ID= " + visitee.machineId() + '}');
    }
}
