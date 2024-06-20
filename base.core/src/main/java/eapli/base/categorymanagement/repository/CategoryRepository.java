package eapli.base.categorymanagement.repository;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.CategoryID;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface CategoryRepository extends DomainRepository<Long, Category> {

    Optional<Category> findByCategoryID(String catID);
    
}
