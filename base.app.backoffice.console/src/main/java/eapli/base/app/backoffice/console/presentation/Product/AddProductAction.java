package eapli.base.app.backoffice.console.presentation.Product;

import eapli.framework.actions.Action;

public class AddProductAction implements Action {
    @Override
    public boolean execute() {
        return new AddProductUI().show();
    }
}
