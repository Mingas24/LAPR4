package eapli.base.app.backoffice.console.presentation.ProductionOrderByState;

import eapli.base.app.backoffice.console.presentation.ProductionOrderByOrderID.ListProductionOrderByOrderIDUI;

import eapli.framework.actions.Action;

public class ListProductionOrderByStateAction implements Action {

    @Override
    public boolean execute() {
        return new ListProductionOrderByStateUI().show();
    }
}
