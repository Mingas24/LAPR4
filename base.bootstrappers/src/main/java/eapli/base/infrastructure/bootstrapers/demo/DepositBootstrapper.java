package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.floormanagement.application.DefineDepositController;
import eapli.base.floormanagement.domain.*;
import eapli.base.floormanagement.repositories.DepositRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class DepositBootstrapper implements Action {

    private static final Logger LOGGER = LogManager.getLogger(DepositBootstrapper.class);

    private final DefineDepositController controller = new DefineDepositController();
    private final DepositRepository depositRepository = PersistenceContext.repositories().deposits();
    private final ProductRepository productRepository = PersistenceContext.repositories().product();

    @Override
    public boolean execute() {
        register("L040", DepositType.ENTRY.name(), "Madeira, Plastico");
        register("102031", DepositType.ENTRY.name(), "Ferro, Parafusos");
        register("L030", DepositType.EXIT.name(), "Ferro, Parafusos");
        register("L042", DepositType.EXIT.name(), "Ferro, Parafusos");
        return true;
    }

    private void register(String depositID, String depositType, String descriptDeposit) {
        try {
            this.controller.defineDeposit(depositID,depositType,descriptDeposit);
        } catch (IntegrityViolationException | ConcurrencyException e){
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", "product");
            LOGGER.trace("Assuming existing record", e);
        }
    }
}
