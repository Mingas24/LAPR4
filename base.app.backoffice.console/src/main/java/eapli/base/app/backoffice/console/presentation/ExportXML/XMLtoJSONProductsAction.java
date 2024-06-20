package eapli.base.app.backoffice.console.presentation.ExportXML;

import eapli.framework.actions.Action;

public class XMLtoJSONProductsAction implements Action {
    @Override
    public boolean execute() {
        return new XMLtoJSONProductsUI().show();
    }
}
