package eapli.base.app.backoffice.console.presentation.ProductionOrderByOrderID;

import eapli.base.productionordermanagement.application.ListProductionOrderByIDController;
import eapli.base.productionordermanagement.domain.ProductionOrder;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.util.Console;

public class ListProductionOrderByOrderIDUI extends AbstractUI {

    ListProductionOrderByIDController lpobidc = new ListProductionOrderByIDController();
    @Override
    protected boolean doShow() {
        String orderID = Console.readLine("Insert the OrderID: ");
        for(ProductionOrder po:lpobidc.findProductionOrderByID(orderID)){
            System.out.println(po.toString());
        }
        return true;
    }

    @Override
    public String headline() {
        return "List Production Order By OrderID";
    }
}
