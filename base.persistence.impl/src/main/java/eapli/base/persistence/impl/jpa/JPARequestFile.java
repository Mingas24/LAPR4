package eapli.base.persistence.impl.jpa;

import eapli.base.machinemanagement.domain.ProtocolId;
import eapli.base.machinemanagement.domain.RequestConfigurationFile;
import eapli.base.machinemanagement.repositories.RequestFileRepository;

public class JPARequestFile extends BasepaRepositoryBase<RequestConfigurationFile, ProtocolId, ProtocolId> implements RequestFileRepository {
    JPARequestFile() {
        super("Protocol ID  ");
    }
}
