package eapli.base.app.backoffice.console.presentation.ImportMessages;

import eapli.framework.actions.Action;

import javax.swing.*;

public class ImportAction implements Action {

    @Override
    public boolean execute(){ return new ImportUI().show();}
}
