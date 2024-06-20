package eapli.base.app.backoffice.console.presentation.Machines;

import eapli.framework.actions.Action;

public class MachineAction implements Action {

    @Override
    public boolean execute(){ return new MachineUI().show();}
}
