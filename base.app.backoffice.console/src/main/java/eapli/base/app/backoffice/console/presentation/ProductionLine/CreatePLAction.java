package eapli.base.app.backoffice.console.presentation.ProductionLine;

import eapli.framework.actions.Action;

public class CreatePLAction implements Action {

    @Override
    public boolean execute(){ return new CreatePLUI().show();}
}
