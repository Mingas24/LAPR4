package eapli.base.app.backoffice.console.presentation.ProductionLineProcessing;

import eapli.framework.actions.Action;

public class PLProcessingAction implements Action {

    @Override
    public boolean execute() {
        return new PLProcessingUI().show();
    }
}