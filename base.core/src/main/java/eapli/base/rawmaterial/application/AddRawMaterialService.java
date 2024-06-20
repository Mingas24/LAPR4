package eapli.base.rawmaterial.application;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.dto.CategoryDTO;
import eapli.base.categorymanagement.repository.CategoryRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

public class AddRawMaterialService {

    private final CategoryRepository catRepo = PersistenceContext.repositories().categories();

    public List<CategoryDTO> findAllCat() {

        List<CategoryDTO> catList = new ArrayList<>();


        Iterable<Category> itCat = catRepo.findAll();

        for (Category c : itCat) {
            CategoryDTO catDTO = new CategoryDTO(c.iDCategory().categoryID(), c.descriptionCategory().description());


            catList.add(catDTO);
        }

        return catList;
    }


}
