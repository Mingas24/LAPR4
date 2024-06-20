package eapli.base.machinemanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.machinemanagement.domain.ProductionLine;
import eapli.base.machinemanagement.domain.ProductionLineID;
import eapli.base.machinemanagement.repositories.ProductionLineRepository;
import eapli.framework.application.UseCaseController;

@UseCaseController
public class ProductionLineController {

    private final ProductionLineRepository plRepository = PersistenceContext.repositories().productionLines();

    public ProductionLine prodLine(String plID){
        ProductionLineID id = new ProductionLineID((plID));
        ProductionLine pL = new ProductionLine(id);
        return pL;
    }

    public boolean createProdLine(String plID){
        ProductionLine pLaux = prodLine(plID);
        ProductionLine pL = this.plRepository.save(pLaux);
        if(pL != null){
            return true;
        }
        return false;
    }
}
