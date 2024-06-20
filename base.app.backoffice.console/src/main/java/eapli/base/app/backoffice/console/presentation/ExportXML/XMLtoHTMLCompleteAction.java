package eapli.base.app.backoffice.console.presentation.ExportXML;

import eapli.framework.actions.Action;

public class XMLtoHTMLCompleteAction implements Action {
    @Override
    public boolean execute() {
        return new XMLtoHTMLCompleteUI().show();
    }
}
