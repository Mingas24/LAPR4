package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.categorymanagement.application.CategoryController;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CategoryBootstrapper implements Action {

    private static final Logger LOGGER = LogManager.getLogger(CategoryBootstrapper.class);

    private final CategoryController controller = new CategoryController();

    @Override
    public boolean execute(){
        register("1", "Metais");
        register("2", "Madeiras");
        register("3", "Vidros");
        return true;
    }

    private void register(String catID, String catDesc){
        try{
            final boolean category = this.controller.createCategory(catDesc, catID);
        }catch (IntegrityViolationException | ConcurrencyException e){
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", "category");
            LOGGER.trace("Assuming existing record", e);
        }
    }
}
