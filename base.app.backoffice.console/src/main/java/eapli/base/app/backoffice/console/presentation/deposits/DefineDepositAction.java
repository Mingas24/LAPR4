package eapli.base.app.backoffice.console.presentation.deposits;

import eapli.framework.actions.Action;

public class DefineDepositAction implements Action {
    @Override
    public boolean execute() {
        return new DefineDepositUI().show();
    }
}
