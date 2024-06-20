package eapli.base.productmanagement.repositories;

import eapli.base.productmanagement.domain.Product;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface ProductRepository extends DomainRepository<Long, Product> {

    Iterable<Product> findWithoutProductionSheet();

    Optional<Product> findProductByUFP(String UFP);

}
