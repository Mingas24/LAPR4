package eapli.base.app.backoffice.console.presentation.RequestConfig;

import eapli.framework.actions.Action;

public class RequestConfigAction implements Action {
    @Override
    public boolean execute() {
        return new RequestConfigUI().doShow();
    }
}
