package eapli.base.machinemanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.machinemanagement.DTO.ProductionLineDTO;
import eapli.base.machinemanagement.domain.ProductionLine;
import eapli.base.machinemanagement.domain.ProductionLineID;
import eapli.base.machinemanagement.domain.ProductionLineProcessingState;
import eapli.base.machinemanagement.repositories.ProductionLineRepository;
import eapli.framework.application.UseCaseController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@UseCaseController
public class ChangeProcessingController {

    private final ProductionLineRepository repository = PersistenceContext.repositories().productionLines();

    public List<ProductionLineDTO> allProdLines(){

        Iterable<ProductionLine> productionLines= repository.findAll();
        List<ProductionLineDTO> productionLineDTOS = new ArrayList<>();

        for(ProductionLine pl : productionLines){
            String prodLineID = pl.plID().productionLineID();
            String processingState = pl.state().name();
            Calendar lastProcessing = pl.lastMessageProcessing();

            ProductionLineDTO plDTO = new ProductionLineDTO(prodLineID, processingState, lastProcessing);
            productionLineDTOS.add(plDTO);
        }
        return  productionLineDTOS;
    }

    public boolean changeProcessingState(ProductionLineDTO productionLineDTO, String state){

        ProductionLine productionLine = repository.ofIdentity(new ProductionLineID(productionLineDTO.productionLineID)).get();
        productionLine.changeState(ProductionLineProcessingState.valueOf(state));
        repository.save(productionLine);
        return true;
    }

}
