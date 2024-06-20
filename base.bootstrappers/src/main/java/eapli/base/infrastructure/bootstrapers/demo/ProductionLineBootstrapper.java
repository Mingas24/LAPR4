package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.machinemanagement.application.ProductionLineController;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ProductionLineBootstrapper implements Action {

    private static final Logger LOGGER = LogManager.getLogger(ProductionLineBootstrapper.class);

    private final ProductionLineController controller = new ProductionLineController();




    @Override
    public boolean execute() {
        register("Line 1");
        register("Line 2");
        register("Line 3");
        register("Line 4");
        register("Line 5");
        return true;
    }

    private void register(String plID){
        try{
            final boolean productionLine = this.controller.createProdLine(plID);
        }catch (IntegrityViolationException | ConcurrencyException e){
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", "production line");
            LOGGER.trace("Assuming existing record", e);
        }
    }

}
