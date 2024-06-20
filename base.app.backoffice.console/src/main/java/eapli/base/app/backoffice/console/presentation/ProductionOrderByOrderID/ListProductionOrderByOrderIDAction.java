package eapli.base.app.backoffice.console.presentation.ProductionOrderByOrderID;

import eapli.base.app.backoffice.console.presentation.productsWithoutProductionSheet.ListProductsWithoutProductionSheetUI;
import eapli.framework.actions.Action;


public class ListProductionOrderByOrderIDAction implements Action {

    @Override
    public boolean execute() {
        return new ListProductionOrderByOrderIDUI().show();
    }
}

