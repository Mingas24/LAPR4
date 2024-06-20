package eapli.base.app.backoffice.console.presentation.ProductionSheet;

import eapli.base.app.backoffice.console.presentation.Product.AddProductUI;
import eapli.framework.actions.Action;

public class SpecifyProductionSheetAction implements Action {
    @Override
    public boolean execute() {
        return new SpecifyProductionSheetUI().show();
    }
}
