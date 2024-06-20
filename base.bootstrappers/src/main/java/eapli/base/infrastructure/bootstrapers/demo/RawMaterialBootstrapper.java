package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.categorymanagement.dto.CategoryDTO;
import eapli.base.rawmaterial.application.AddRawMaterialController;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RawMaterialBootstrapper implements Action {

    private static final Logger LOGGER = LogManager.getLogger(RawMaterialBootstrapper.class);

    private final AddRawMaterialController controller = new AddRawMaterialController();

    @Override
    public boolean execute() {
        register("600", "zinco", "ficha1", new CategoryDTO("1", "metais"));
        register("601", "pinho", "ficha2", new CategoryDTO("2", "madeiras"));
        register("602", "balistico", "ficha3", new CategoryDTO("3", "vidros"));
        return true;
    }

    private void register(String internalCodeRawMaterial, String descriptionRawMaterial, String techSheetRawMaterial, CategoryDTO catDTO) {
        try {
            controller.saveRawMaterial(internalCodeRawMaterial, descriptionRawMaterial, techSheetRawMaterial, catDTO);
        } catch (IntegrityViolationException | ConcurrencyException e) {
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", "product");
            LOGGER.trace("Assuming existing record", e);
        }
    }
}
