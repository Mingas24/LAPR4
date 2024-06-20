package eapli.base.persistence.impl.jpa;

import eapli.base.rawmaterial.domain.RawMaterialInternalCode;
import eapli.base.rawmaterial.repository.RawMaterialRepository;
import eapli.base.rawmaterial.domain.RawMaterial;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaRawMaterialRepository extends BasepaRepositoryBase<RawMaterial, RawMaterialInternalCode, RawMaterialInternalCode> implements RawMaterialRepository {

    public JpaRawMaterialRepository() {
        super("id");
    }

    @Override
    public Optional<RawMaterial> findMaterialByID(String rawMaterial) {
        final Map<String, Object> params = new HashMap<>();
        params.put("RAWMATERIALINTERNALCODE", rawMaterial);
        return matchOne("e.RAWMATERIALINTERNALCODE().RAWMATERIALINTERNALCODE()=:rawMaterial", params);
    }
}
