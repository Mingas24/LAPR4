package eapli.base.app.backoffice.console.presentation.rawmaterial;

import eapli.framework.actions.Action;


public class CreateRMAction implements Action {

    @Override
    public boolean execute(){
        return new CreateRMUI().show();
    }
}
