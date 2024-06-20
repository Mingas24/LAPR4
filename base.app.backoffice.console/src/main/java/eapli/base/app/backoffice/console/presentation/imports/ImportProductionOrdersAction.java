package eapli.base.app.backoffice.console.presentation.imports;

import eapli.framework.actions.Action;

public class ImportProductionOrdersAction implements Action {
    @Override
    public boolean execute() {
        return new ImportProductionOrdersUI().show();
    }
}
