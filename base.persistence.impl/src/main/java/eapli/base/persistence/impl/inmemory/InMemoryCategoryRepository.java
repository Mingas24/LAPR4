package eapli.base.persistence.impl.inmemory;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.CategoryID;
import eapli.base.categorymanagement.repository.CategoryRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryCategoryRepository extends InMemoryDomainRepository<Long, Category> implements CategoryRepository {

    static {
        InMemoryInitializer.init();
    }


    @Override
    public Optional<Category> findByCategoryID(String catID) {
        return matchOne(e -> e.iDCategory().categoryID().equals(catID));
    }
}
