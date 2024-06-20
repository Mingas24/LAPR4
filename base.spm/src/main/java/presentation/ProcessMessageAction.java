package presentation;

import eapli.framework.actions.Action;

public class ProcessMessageAction implements Action {
    @Override
    public boolean execute() {
        return new ProcessMessageUI().show();
    }
}
