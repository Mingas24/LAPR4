package eapli.base.rawmaterial.repository;

import eapli.base.floormanagement.domain.Deposit;
import eapli.base.rawmaterial.domain.RawMaterial;
import eapli.base.rawmaterial.domain.RawMaterialInternalCode;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface RawMaterialRepository extends DomainRepository<RawMaterialInternalCode, RawMaterial> {

    Optional<RawMaterial> findMaterialByID(String rawMaterial);
}
