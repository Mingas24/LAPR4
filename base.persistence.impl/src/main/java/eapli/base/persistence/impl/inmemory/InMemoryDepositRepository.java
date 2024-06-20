package eapli.base.persistence.impl.inmemory;

import eapli.base.floormanagement.domain.Deposit;
import eapli.base.floormanagement.repositories.DepositRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainAutoNumberRepository;

import java.util.Optional;

public class InMemoryDepositRepository extends InMemoryDomainAutoNumberRepository<Deposit>
        implements DepositRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<Deposit> findDepositByID(String deposit) {
        return matchOne(e -> e.depositId().depositId().equals(deposit));
    }
}
