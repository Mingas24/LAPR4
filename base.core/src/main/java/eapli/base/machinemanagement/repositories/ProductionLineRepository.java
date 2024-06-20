package eapli.base.machinemanagement.repositories;

import eapli.base.machinemanagement.domain.ProductionLine;
import eapli.base.machinemanagement.domain.ProductionLineID;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface ProductionLineRepository extends DomainRepository<ProductionLineID, ProductionLine> {
    Optional<ProductionLine> findProductionLineByID(ProductionLineID plID);
}
