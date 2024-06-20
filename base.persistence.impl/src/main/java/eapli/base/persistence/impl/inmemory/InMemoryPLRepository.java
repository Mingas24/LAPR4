package eapli.base.persistence.impl.inmemory;


import eapli.base.machinemanagement.domain.ProductionLine;
import eapli.base.machinemanagement.domain.ProductionLineID;
import eapli.base.machinemanagement.repositories.ProductionLineRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryPLRepository extends InMemoryDomainRepository<ProductionLineID, ProductionLine>
        implements ProductionLineRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<ProductionLine> findProductionLineByID(ProductionLineID plID) {
        return Optional.empty();
    }
}
