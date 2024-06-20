package eapli.base.app.backoffice.console.presentation.category;

import eapli.framework.actions.Action;

public class CreateCATAction implements Action {

    @Override
    public boolean execute(){
        return new CreateCATUI().show();
    }
}
