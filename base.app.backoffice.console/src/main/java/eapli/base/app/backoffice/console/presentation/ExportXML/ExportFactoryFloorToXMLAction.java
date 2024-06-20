package eapli.base.app.backoffice.console.presentation.ExportXML;

import eapli.framework.actions.Action;

public class ExportFactoryFloorToXMLAction implements Action {
    @Override
    public boolean execute() {
        return new ExportFactoryFloorToXMLUI().show();
    }
}
