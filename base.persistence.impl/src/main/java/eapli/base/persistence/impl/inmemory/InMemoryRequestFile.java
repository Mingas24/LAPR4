package eapli.base.persistence.impl.inmemory;

import eapli.base.machinemanagement.domain.ProtocolId;
import eapli.base.machinemanagement.domain.RequestConfigurationFile;
import eapli.base.machinemanagement.repositories.RequestFileRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryRequestFile extends InMemoryDomainRepository<ProtocolId, RequestConfigurationFile> implements RequestFileRepository {
    static {
        InMemoryInitializer.init();
    }
}
