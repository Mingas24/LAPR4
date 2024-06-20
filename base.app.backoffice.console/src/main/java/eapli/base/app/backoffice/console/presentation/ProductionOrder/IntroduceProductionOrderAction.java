package eapli.base.app.backoffice.console.presentation.ProductionOrder;

import eapli.framework.actions.Action;

public class IntroduceProductionOrderAction implements Action {
    @Override
    public boolean execute() { return new IntroduceProductionOrderUI().show(); }
}
