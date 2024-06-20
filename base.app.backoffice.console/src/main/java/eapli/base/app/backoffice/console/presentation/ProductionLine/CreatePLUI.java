package eapli.base.app.backoffice.console.presentation.ProductionLine;

import eapli.base.machinemanagement.application.ProductionLineController;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.util.Console;

public class CreatePLUI extends AbstractUI {

    private final ProductionLineController controller = new ProductionLineController();

    @Override
    protected boolean doShow(){
        String plID = Console.readLine("Insert an id for your Production Line:");

        try{
            controller.createProdLine(plID);
            System.out.println("\nYou just created a new Production Line");
        } catch (final IntegrityViolationException e){
            System.out.println("\nERROR! There's already a production line with that ID!");
        }
        return false;
    }

    @Override
    public String headline() {return "\n<---------Create a new Production Line--------->";}
}
