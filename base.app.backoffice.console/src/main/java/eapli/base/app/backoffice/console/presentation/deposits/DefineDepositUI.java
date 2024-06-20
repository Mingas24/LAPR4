package eapli.base.app.backoffice.console.presentation.deposits;

import eapli.base.floormanagement.application.DefineDepositController;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.util.Console;

public class DefineDepositUI extends AbstractUI {

    private final DefineDepositController controller = new DefineDepositController();


    @Override
    protected boolean doShow() {

        String depositId = Console.readLine("Insert the new Deposit ID (max 10 charact): ");
        while (!controller.validateIdDeposit(depositId)) {
            System.out.println("\nERROR! Insert a maximum of 10 characters.");
            depositId = Console.readLine("\nInsert the new Deposit ID (max 10 charact): ");
        }
        String depositType = Console.readLine("\nInsert the Deposit Type (ENTRY/EXIT): ");
        while (!controller.validateTypeDeposit(depositType)) {
            System.out.println("\nERROR! The type can only be ENTRY or EXIT");
            depositType = Console.readLine("\nInsert the Deposit Type (ENTRY/EXIT): ");
        }
        String depositDescript = Console.readLine("\nInsert the description of the Deposit: ");
        while(!controller.validatedescriptDeposit(depositDescript)) {
            System.out.println("\nERROR! Max 50 characters. ");
            depositDescript = Console.readLine("\nInsert the description of the Deposit: ");
        }
        try {
            controller.defineDeposit(depositId,depositType,depositDescript);
            System.out.println("\nSuccessfully created the deposit!!");
        } catch (final IntegrityViolationException e) {
            System.out.println("\nERROR! There's already a deposit with that ID!");
        }
        return false;
    }

    @Override
    public String headline()  {
        return "\n<------Define a new Deposit------>";
    }
}
