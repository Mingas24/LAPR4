package eapli.base.rawmaterial.application;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.CategoryDescription;
import eapli.base.categorymanagement.domain.CategoryID;
import eapli.base.categorymanagement.dto.CategoryDTO;
import eapli.base.categorymanagement.repository.CategoryRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.rawmaterial.domain.*;
import eapli.base.rawmaterial.repository.RawMaterialRepository;
import eapli.framework.application.UseCaseController;

import java.util.List;
import java.util.Optional;


@UseCaseController
public class AddRawMaterialController {

    private final RawMaterialRepository rawmaterialRepository = PersistenceContext.repositories().rawMaterials();
    private final CategoryRepository catRep = PersistenceContext.repositories().categories();

    AddRawMaterialService svc = new AddRawMaterialService();

    public RawMaterial registerRawMaterial(String internalCodeRawMaterial, String descriptionRawMaterial,
                                           String techSheetRawMaterial, CategoryDTO catDTO) {

        RawMaterialInternalCode idRawMaterial = new RawMaterialInternalCode(internalCodeRawMaterial);
        RawMaterialDescription desRawMaterial = new RawMaterialDescription(descriptionRawMaterial);
        RawMaterialTechSheet tsRawMaterial = new RawMaterialTechSheet(techSheetRawMaterial);

        Optional<Category> opc = catRep.findByCategoryID(catDTO.idCategory());
        Category ca = opc.get();


        RawMaterial rm = new RawMaterial(idRawMaterial, desRawMaterial, tsRawMaterial, ca);

        return rm;
    }

    public boolean saveRawMaterial(String internalCodeRawMaterial, String descriptionRawMaterial,
                                   String techSheetRawMaterial, CategoryDTO catDTO) {

        RawMaterial rawMaterialAux = registerRawMaterial(internalCodeRawMaterial, descriptionRawMaterial, techSheetRawMaterial,
                catDTO);

        RawMaterial rm = this.rawmaterialRepository.save(rawMaterialAux);
        if (rm != null) {
            return true;
        }
        return false;

    }

    public List<CategoryDTO> findAllCat() {
        return svc.findAllCat();
    }


}
