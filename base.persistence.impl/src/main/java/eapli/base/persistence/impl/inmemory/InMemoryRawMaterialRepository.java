package eapli.base.persistence.impl.inmemory;

import eapli.base.rawmaterial.domain.RawMaterial;
import eapli.base.rawmaterial.domain.RawMaterialInternalCode;
import eapli.base.rawmaterial.repository.RawMaterialRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryRawMaterialRepository extends InMemoryDomainRepository<RawMaterialInternalCode, RawMaterial> implements RawMaterialRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<RawMaterial> findMaterialByID(String rawMaterial) {
        return matchOne(e -> e.rawMaterialInternalCode().toString().equals(rawMaterial));
    }
}
