package eapli.base.app.backoffice.console.presentation.imports;

import eapli.framework.actions.Action;

public class ImportProductCatalogueAction implements Action {
    @Override
    public boolean execute(){
        return new ImportProductCatalogueUI().show();
    }

}
