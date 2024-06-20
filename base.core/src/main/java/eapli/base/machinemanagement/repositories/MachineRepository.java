package eapli.base.machinemanagement.repositories;

import eapli.base.machinemanagement.domain.ID;
import eapli.base.machinemanagement.domain.Machine;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface MachineRepository extends DomainRepository<ID, Machine> {

    Optional<Machine> findMachineByID(String machineID);

    Optional<Machine> findMachineByProtocol(int protocolID);

    Iterable<Machine> findMachinesByPLID(String plID);
}
