package eapli.base.persistence.impl.jpa;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.CategoryID;
import eapli.base.categorymanagement.repository.CategoryRepository;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaCategoryRepository extends BasepaRepositoryBase<Category, Long, Long> implements CategoryRepository {

    public JpaCategoryRepository() {
        super("id");
    }

    @Override
    public Optional<Category> findByCategoryID(String catID) {
        final Map<String, Object> params = new HashMap<>();
        params.put("categoryid", catID);
        return matchOne("e.idCategory.idCategory=:categoryid", params);
    }

}