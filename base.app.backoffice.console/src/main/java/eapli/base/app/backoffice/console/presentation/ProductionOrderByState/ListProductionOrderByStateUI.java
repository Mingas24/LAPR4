package eapli.base.app.backoffice.console.presentation.ProductionOrderByState;

import eapli.base.productionordermanagement.DTO.ProductionOrderDTO;
import eapli.base.productionordermanagement.application.ListProductionOrderByStateController;

import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.util.Console;

public class ListProductionOrderByStateUI extends AbstractUI {

    ListProductionOrderByStateController lpo = new ListProductionOrderByStateController();

    @Override
    protected boolean doShow() {
        String state = Console.readLine("Insert state: \n");

        for (ProductionOrderDTO poDTO : lpo.listProductionOrderAtGivenState(state)) {
            System.out.println(poDTO.toString());

        }
        return true;
    }

    @Override
    public String headline() {
        return "List Production Order At Required State";
    }
}
