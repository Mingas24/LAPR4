package eapli.base.app.backoffice.console.presentation.rawmaterial;

import eapli.base.app.backoffice.console.presentation.Product.ProductPrinter;
import eapli.base.app.backoffice.console.presentation.category.CategoryPrinter;
import eapli.base.categorymanagement.dto.CategoryDTO;
import eapli.base.rawmaterial.application.AddRawMaterialController;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import eapli.framework.util.Console;

import java.util.List;

public class CreateRMUI extends AbstractUI {

    private final AddRawMaterialController controller = new AddRawMaterialController();

    @Override
    protected boolean doShow() {

        final Iterable<CategoryDTO> listDTO = controller.findAllCat();

        final SelectWidget<CategoryDTO> sw = new SelectWidget<>("category list: ", listDTO, new CategoryPrinter());

        sw.show();


        final CategoryDTO cto = sw.selectedElement();
        String rmID = Console.readLine("Insert an id for your Raw Material:");
        String rmDes = Console.readLine("Insert a description for your Raw Material:");
        String rmTS = Console.readLine("Insert a technical sheet for your Raw Material:");

        try {
            controller.saveRawMaterial(rmID, rmDes, rmTS, cto);
            System.out.println("\nYou just created a new Raw Material");
        } catch (final IntegrityViolationException e) {
            System.out.println("\nERROR! There's already a raw material with that ID!");
        }


        return false;
    }

    @Override
    public String headline() {
        return "\n<---------Create a new Raw Material--------->";
    }

}
