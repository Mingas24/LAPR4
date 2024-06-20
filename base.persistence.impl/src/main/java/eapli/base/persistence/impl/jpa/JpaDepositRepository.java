package eapli.base.persistence.impl.jpa;

import eapli.base.floormanagement.domain.Deposit;
import eapli.base.floormanagement.repositories.DepositRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaDepositRepository extends BasepaRepositoryBase<Deposit, Long, Long> implements
        DepositRepository {

    public JpaDepositRepository() {
        super("id");
    }

    @Override
    public Optional<Deposit> findDepositByID(String deposit) {
        final Map<String, Object> params = new HashMap<>();
        params.put("depositID", deposit);
        return matchOne("e.depositId.depositId=:depositID", params);
    }
}
