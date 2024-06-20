package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.application.AddProductController;
import eapli.base.productmanagement.domain.*;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductBootstrapper implements Action {

    private static final Logger LOGGER = LogManager.getLogger(ProductBootstrapper.class);

    private final AddProductController controller = new AddProductController();

    @Override
    public boolean execute() {
        register("50000106", "160000", "chef knife",
                "knife", Unity.UN.name(), "Kitchen Utensils");
        register("850002", "160001", "dinner fork",
                "fork", Unity.UN.name(), "Kitchen Utensils");
        register("850003", "160002", "soup spoon",
                "spoon", Unity.UN.name(), "Kitchen Utensils");
        register("32000142", "160003", "Blocos Ferro",
                "Blocos", Unity.UN.name(), "Materiais");
        return true;
    }

    private void register(String unFabCode, String comCode, String compDesc,
                          String shortDesc,String unity,String cat) {

        try {
      final Product product = this.controller.newProduct(unFabCode, comCode,
              compDesc, shortDesc, unity, cat);
        } catch (IntegrityViolationException | ConcurrencyException e){
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", "product");
            LOGGER.trace("Assuming existing record", e);
        }
    }
}
