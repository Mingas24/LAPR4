package eapli.base.persistence.impl.inmemory;

import eapli.base.machinemanagement.domain.ID;
import eapli.base.machinemanagement.domain.Machine;
import eapli.base.machinemanagement.repositories.MachineRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryMachinesRepository extends InMemoryDomainRepository<ID, Machine> implements MachineRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<Machine> findMachineByProtocol(int protocolID){return matchOne(e->e.protocolId().protocolId()==protocolID);}

    @Override
    public Optional<Machine> findMachineByID(String machineID) {
        return matchOne(e -> e.machineId().id()==(machineID));
    }

    @Override
    public Iterable<Machine> findMachinesByPLID(String plID) {
        return match(e -> e.machinePLID().productionLineID()==(plID));
    }
}
