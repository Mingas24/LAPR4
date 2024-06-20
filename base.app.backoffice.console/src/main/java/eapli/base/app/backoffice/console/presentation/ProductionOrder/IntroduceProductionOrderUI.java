package eapli.base.app.backoffice.console.presentation.ProductionOrder;

import eapli.base.productionordermanagement.application.IntroduceProductionOrderController;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.util.Console;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IntroduceProductionOrderUI extends AbstractUI {

    private final IntroduceProductionOrderController controller = new IntroduceProductionOrderController();

    @Override
    protected boolean doShow() {

        String productionOrderID = Console.readLine("Insert the new Production Order ID: ");
        while(!controller.validateProductionOrderID(productionOrderID)){
            System.out.println("\nERROR! Invalid Production Order ID!!.");
            productionOrderID = Console.readLine("\nInsert the new Production Order ID: ");
        }

        Date emissionDate = Console.readDate("\nInsert the Emission Date (YYYY/MM/DD): ");

        Date expectedExecutionDate = Console.readDate("\nInsert the Expected Execution Date (YYYY/MM/DD): ");
        while (!controller.validateExpectedExecutionDate(emissionDate, expectedExecutionDate)){
            System.out.println("\nERROR! Invalid Expected Execution Date!!.");
            expectedExecutionDate = Console.readDate("\nInsert the Expected Execution Date (YYYY/MM/DD): ");
        }

        String prodUniFabCode = Console.readLine("\nInsert the Fabrication Code of the Product: ");
        while(!controller.checkProduct(prodUniFabCode)){
            System.out.println("\nERROR! Invalid Product!!.");
            prodUniFabCode = Console.readLine("\nInsert the Fabrication Code of the Product: ");
        }
        if(controller.checkProductionSheet(prodUniFabCode)){
            System.out.println("\nThis product does not have a production sheet!");
        }

        int quantity = Console.readInteger("\nInsert the quantity to produce: ");
        while (quantity < 1){
            System.out.println("\nERROR! Invalid Quantity!!.");
            quantity = Console.readInteger("\nInsert the quantity to produce: ");
        }

        String unity = Console.readLine("\nInsert the unity of the product (UN/KG/L/METERS)");
        while(!controller.validateUnity(unity)){
            System.out.println("\nERROR! Invalid Unity!!.");
            unity = Console.readLine("\nInsert the unity of the product (UN/KG/L/METERS)");
        }
        List<String> orderIds = new ArrayList<>();
        String orderID = Console.readLine("\nInsert one id of the order");
        orderIds.add(orderID);
        while (!orderID.equalsIgnoreCase("0")){
            orderID = Console.readLine("\nInsert more id's of orders if necessary, insert 0 when finished: ");
            if (!orderID.equalsIgnoreCase("0")){
                orderIds.add(orderID);
            }
        }

        try {
            controller.createProductionOrder(productionOrderID, emissionDate, expectedExecutionDate, prodUniFabCode, quantity, unity, orderIds);
            System.out.println("\nSuccessfully created the production order!!");
        } catch (IntegrityViolationException e) {
            System.out.println("\nERROR! Could not create the production order!" + e);
        }

        return false;
    }

    @Override
    public String headline()  {
        return "\n<------Introduce a new Production Order------>";
    }
}
