package eapli.base.persistence.impl.jpa;

import eapli.base.machinemanagement.domain.ID;
import eapli.base.machinemanagement.domain.Machine;
import eapli.base.machinemanagement.domain.ProductionLineID;
import eapli.base.machinemanagement.repositories.MachineRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaMachineRepository extends BasepaRepositoryBase<Machine, ID, ID> implements MachineRepository {
    public JpaMachineRepository() {
        super("id");
    }

    @Override
    public Optional<Machine> findMachineByID(String machineID) {

        Optional<Machine> m;
        final Map<String, Object> params = new HashMap<>();
        params.put("MachineID", machineID);
        if(matchOne("e.id.id=:MachineID", params).get()==null){
            return null;
        }else{
            return matchOne("e.id.id=:MachineID", params);
        }

    }

    @Override
    public Optional<Machine> findMachineByProtocol(int protocolID) {
        final Map<String, Object> params = new HashMap<>();
        params.put("ProtocolID", protocolID);
        return matchOne("e.protocolID.protId=:ProtocolID", params);
    }

    @Override
    public Iterable<Machine> findMachinesByPLID(String ProdLineID) {
        final Map<String, Object> params = new HashMap<>();
        params.put("ProdLineID", ProdLineID);
        return match("e.plID.plID=:ProdLineID", params);
    }
}
