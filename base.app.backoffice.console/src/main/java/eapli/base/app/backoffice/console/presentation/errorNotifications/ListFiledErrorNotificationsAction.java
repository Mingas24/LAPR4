package eapli.base.app.backoffice.console.presentation.errorNotifications;

import eapli.framework.actions.Action;

public class ListFiledErrorNotificationsAction implements Action {
    @Override
    public boolean execute() {
        return new ListFiledErrorNotificationsUI().show();
    }
}
