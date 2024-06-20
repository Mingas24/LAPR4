package eapli.base.persistence.impl.jpa;

import eapli.base.machinemanagement.domain.ProductionLine;
import eapli.base.machinemanagement.domain.ProductionLineID;
import eapli.base.machinemanagement.repositories.ProductionLineRepository;

import java.util.*;

public class JpaPLRepository extends BasepaRepositoryBase<ProductionLine, ProductionLineID, ProductionLineID> implements
    ProductionLineRepository{

    public JpaPLRepository() {
        super("id");
    }

    @Override
    public Optional<ProductionLine> findProductionLineByID(ProductionLineID plID) {
        return matchOne("e.plID = :plID", "plID",plID);
    }
}
