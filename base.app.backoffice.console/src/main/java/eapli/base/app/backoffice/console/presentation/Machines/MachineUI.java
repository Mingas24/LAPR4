package eapli.base.app.backoffice.console.presentation.Machines;

import eapli.base.machinemanagement.application.MachineController;
import eapli.base.machinemanagement.domain.ProductionLine;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.util.Console;

import java.time.LocalDate;

public class MachineUI extends AbstractUI {

    private final MachineController controller = new MachineController();

    @Override
    protected boolean doShow() {
        String id = Console.readLine("Insert the new Machine id:");
        String brand = Console.readLine("Insert the brand of this Machine:");
        String model = Console.readLine("Insert the model of this machine:");
        String type = Console.readLine("Insert the type of this machine:");
        String serialNum = Console.readLine("Insert the Serial Number of this machine:");
        CharSequence date = Console.readLine("Insert the date of the installation date: (YYYY-MM-DD)");
        String desc = Console.readLine("Insert the Description of this machine:");
        int protocolID = Console.readInteger("Insert the Protocol ID of this machine: (between 1/65535)");
        String pl = Console.readLine("Insert the production Line to which you wish to add this machine:");
        String yn = Console.readLine("Do you want to add the machine to the default position? (Y/N)");
        ProductionLine productionLine = controller.checkPLID(pl);
        try {
            controller.validatePLID(pl);
            if (yn.equals("Y")) {
                controller.registerMachine(id, brand, model, type, serialNum, LocalDate.parse(date), desc, productionLine, protocolID);
            }
            if (yn.equals("N")) {
                int pos = Console.readInteger("What position would you like to put the position in?");
                controller.registerMachine(id, brand, model, type, serialNum, LocalDate.parse(date), desc, productionLine, pos, protocolID);
            }
            System.out.println("\nSuccessfully added a new Machine!!");
        } catch (final IntegrityViolationException e) {
            System.out.println("\nERROR! That machine already exists!");
        }
        return false;
    }

    @Override
    public String headline() {
        return "\n<------Create a new Machine------>";
    }
}
