package eapli.base.app.backoffice.console.presentation.errorNotifications;

import eapli.framework.actions.Action;

public class ListUnhandledErrorNotificationsAction implements Action {
    @Override
    public boolean execute() {
        return new ListUnhandledErrorNotificationsUI().show();
    }
}
