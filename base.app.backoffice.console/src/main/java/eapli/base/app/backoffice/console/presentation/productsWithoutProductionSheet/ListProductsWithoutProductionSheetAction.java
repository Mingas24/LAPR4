package eapli.base.app.backoffice.console.presentation.productsWithoutProductionSheet;

import eapli.framework.actions.Action;

public class ListProductsWithoutProductionSheetAction implements Action {
    @Override
    public boolean execute() { return new ListProductsWithoutProductionSheetUI().show(); }
}
