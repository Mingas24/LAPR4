package eapli.base.app.backoffice.console.presentation.ExportXML;

import eapli.framework.actions.Action;

public class XMLtoHTMLUnityKGAction implements Action {
    @Override
    public boolean execute() {
        return new XMLtoHTMLUnityKGUI().show();
    }
}
