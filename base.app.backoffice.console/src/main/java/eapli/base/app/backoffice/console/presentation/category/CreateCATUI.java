package eapli.base.app.backoffice.console.presentation.category;


import eapli.base.categorymanagement.application.CategoryController;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.util.Console;

@SuppressWarnings("squid:S106")
public class CreateCATUI extends AbstractUI {

    private final CategoryController theController = new CategoryController();

    @Override
    protected boolean doShow() {
        final String catDes = Console.readLine("Category Description:");
        final String catID = Console.readLine("Category ID:");

        try {
            theController.createCategory(catDes, catID);
            System.out.println("\nSuccess");
        } catch (@SuppressWarnings("unused") final IntegrityViolationException e) {
            System.out.println("That Category already exists.");
        }
        return false;
    }

    @Override
    public String headline() {
        return "Register Category";
    }
}
