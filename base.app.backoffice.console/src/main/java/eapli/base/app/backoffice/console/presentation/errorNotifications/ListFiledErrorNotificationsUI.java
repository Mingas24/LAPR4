package eapli.base.app.backoffice.console.presentation.errorNotifications;

import eapli.base.errornotificationmanagement.application.ListFiledErrorNotificationsController;
import eapli.base.errornotificationmanagement.dto.ErrorNotificationDTO;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ListWidget;
import eapli.framework.presentation.console.SelectWidget;

public class ListFiledErrorNotificationsUI extends AbstractUI {

    private final ListFiledErrorNotificationsController controller = new ListFiledErrorNotificationsController();

    @Override
    protected boolean doShow() {

       final Iterable<ErrorNotificationDTO> listFiledErrorNotifications = controller.listFiledErrorNotifications();

        final ListWidget<ErrorNotificationDTO> sw = new ListWidget<>("Filed Notifications", listFiledErrorNotifications, new ErrorNotificationPrinter());

        sw.show();

        return true;
    }

    @Override
    public String headline() {
        return "Filed Error Notifications";
    }
}
