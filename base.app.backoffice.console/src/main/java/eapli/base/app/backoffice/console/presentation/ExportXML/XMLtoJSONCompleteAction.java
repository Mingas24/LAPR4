package eapli.base.app.backoffice.console.presentation.ExportXML;

import eapli.framework.actions.Action;

public class XMLtoJSONCompleteAction implements Action {
    @Override
    public boolean execute() {
        return new XMLtoJSONCompleteUI().show();
    }
}
