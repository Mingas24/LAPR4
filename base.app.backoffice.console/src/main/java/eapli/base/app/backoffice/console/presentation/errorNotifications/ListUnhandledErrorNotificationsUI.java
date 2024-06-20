package eapli.base.app.backoffice.console.presentation.errorNotifications;

import eapli.base.errornotificationmanagement.application.FileErrorNotificationController;
import eapli.base.errornotificationmanagement.application.ListUnhandledErrorNotificationsController;
import eapli.base.errornotificationmanagement.dto.ErrorNotificationDTO;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

public class ListUnhandledErrorNotificationsUI extends AbstractUI {

    private final ListUnhandledErrorNotificationsController listController = new ListUnhandledErrorNotificationsController();
    private final FileErrorNotificationController fileErrorNotificationController = new FileErrorNotificationController();


    @Override
    protected boolean doShow() {

        final Iterable<ErrorNotificationDTO> unhandledErrorNotifications = listController.listUnhandledErrorNotifications();

        final SelectWidget<ErrorNotificationDTO> sw = new SelectWidget<>("Unhandled Notifications: Select one to file it or 0 to exit", unhandledErrorNotifications, new ErrorNotificationPrinter());

        sw.show();

        if (sw.selectedOption() != 0) {

            final ErrorNotificationDTO errorNotificationDTO = sw.selectedElement();
            try {
                fileErrorNotificationController.fileErrorNotification(errorNotificationDTO);
                System.out.println("Successfully Filed the Error Notification!\n");
            } catch (final IntegrityViolationException e) {
                System.out.println("ERROR!  Error while filling the error notification!\n");
            }
        }


        return false;
    }

    @Override
    public String headline() {
        return "Unhandled Error Notifications";
    }
}
