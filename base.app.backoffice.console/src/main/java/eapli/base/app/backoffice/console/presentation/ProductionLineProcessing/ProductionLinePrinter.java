package eapli.base.app.backoffice.console.presentation.ProductionLineProcessing;

import eapli.base.errornotificationmanagement.dto.ErrorNotificationDTO;
import eapli.base.machinemanagement.DTO.ProductionLineDTO;
import eapli.framework.visitor.Visitor;

public class ProductionLinePrinter implements Visitor<ProductionLineDTO> {

    @Override
    public void visit(ProductionLineDTO visitee) {
        System.out.printf("Production Late{" +
                " ID= " + visitee.productionLineID() + " Processing State= " + visitee.processingState() + " Last Processing= " + visitee.lastProcessing() + '}');
    }
}
