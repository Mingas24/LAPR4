package eapli.base.app.backoffice.console.presentation.ExportXML;

import eapli.framework.actions.Action;

public class XMLtoJSONMachinesAction implements Action {
    @Override
    public boolean execute() {
        return new XMLtoJSONMachinesUI().show();
    }
}
