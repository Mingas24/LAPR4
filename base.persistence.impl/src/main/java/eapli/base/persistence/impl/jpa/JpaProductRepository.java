package eapli.base.persistence.impl.jpa;

import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.repositories.ProductRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaProductRepository extends BasepaRepositoryBase<Product, Long, Long> implements ProductRepository {

    public JpaProductRepository() {
        super("id");
    }

    @Override
    public Iterable<Product> findWithoutProductionSheet() {
        return match("e.prodSheet IS EMPTY");
    }

    @Override
    public Optional<Product> findProductByUFP(String UFC) {
        final Map<String, Object> params = new HashMap<>();
        params.put("UFC", UFC);
        return matchOne("e.unFabCode.unFabCode=:UFC", params);
    }

}

