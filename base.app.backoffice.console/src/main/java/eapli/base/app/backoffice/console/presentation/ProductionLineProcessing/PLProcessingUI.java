package eapli.base.app.backoffice.console.presentation.ProductionLineProcessing;

import eapli.base.machinemanagement.DTO.ProductionLineDTO;
import eapli.base.machinemanagement.application.ChangeProcessingController;
import eapli.base.machinemanagement.domain.ProductionLineProcessingState;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import eapli.framework.util.Console;

public class PLProcessingUI extends AbstractUI {

    private final ChangeProcessingController controller = new ChangeProcessingController();

    @Override
    protected boolean doShow() {

        final Iterable<ProductionLineDTO> productionLinesDTO = controller.allProdLines();

        final SelectWidget<ProductionLineDTO> sw = new SelectWidget<>("Production Lines and Processing States: Select one to change it's state or 0 to exit", productionLinesDTO, new ProductionLinePrinter());

        sw.show();

        if (sw.selectedOption() != 0) {
            final ProductionLineDTO productionLineDTO = sw.selectedElement();
            int option = Console.readInteger("Insert 1 to Activate the processing or 2 to Deactivate");
            if(option == 1){
                try{
                    controller.changeProcessingState(productionLineDTO, ProductionLineProcessingState.ACTIVATED.name());
                    System.out.println("Successfully changed the Processing State");
                } catch (IntegrityViolationException e){
                    System.out.println("ERROR! Could not change the processing state!");
                }
            } else if (option == 2){
                try{
                    controller.changeProcessingState(productionLineDTO, ProductionLineProcessingState.DEACTIVATED.name());
                    System.out.println("Successfully changed the Processing State");
                } catch (IntegrityViolationException e){
                    System.out.println("ERROR! Could not change the processing state!");
                }
            }
        }
        return false;
    }

    @Override
    public String headline() {
        return "\n<---------Production Line Processing--------->";
    }
}
