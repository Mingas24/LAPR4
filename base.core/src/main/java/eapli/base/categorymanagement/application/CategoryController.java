package eapli.base.categorymanagement.application;


import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.CategoryDescription;
import eapli.base.categorymanagement.domain.CategoryID;
import eapli.base.categorymanagement.repository.CategoryRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;

@UseCaseController
public class    CategoryController {

    private final CategoryRepository categoryRepository = PersistenceContext.repositories().categories();


    public Category category(String descriptionCategory, String idCategory) {
        CategoryDescription catDes = new CategoryDescription(descriptionCategory);
        CategoryID catID = new CategoryID(idCategory);
        Category cat = new Category(catDes, catID);

        return cat;
    }

    public boolean createCategory(String descriptionCategory, String idCategory) {
        Category auxCat = category(descriptionCategory, idCategory);
        Category cat = this.categoryRepository.save(auxCat);
        if (cat != null) {
            return true;
        }
        return false;
    }
}
