package eapli.base.floormanagement.repositories;

import eapli.base.floormanagement.domain.Deposit;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface DepositRepository extends DomainRepository<Long, Deposit> {

    Optional<Deposit> findDepositByID(String deposit);

}
