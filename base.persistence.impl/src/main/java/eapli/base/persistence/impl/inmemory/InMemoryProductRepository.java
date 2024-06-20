package eapli.base.persistence.impl.inmemory;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainAutoNumberRepository;

import java.util.Optional;

public class InMemoryProductRepository extends InMemoryDomainAutoNumberRepository<Product> implements ProductRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<Product> findWithoutProductionSheet() {
        return match(e -> e.prodSheet().isEmpty());
    }

    @Override
    public Optional<Product> findProductByUFP(String ufc) {
        return matchOne(e -> e.unFabCode().unFabCode().equals(ufc));
    }
}
