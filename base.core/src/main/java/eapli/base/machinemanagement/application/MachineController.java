package eapli.base.machinemanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.machinemanagement.domain.*;
import eapli.base.machinemanagement.repositories.MachineRepository;
import eapli.base.machinemanagement.repositories.ProductionLineRepository;
import eapli.framework.application.UseCaseController;
import eapli.framework.domain.repositories.TransactionalContext;

import java.time.LocalDate;

@UseCaseController
public class MachineController {

    private final MachineRepository machineRepository = PersistenceContext.repositories().machines();
    private final ProductionLineRepository plRepository = PersistenceContext.repositories().productionLines();
    private final TransactionalContext txCtx = PersistenceContext.repositories().newTransactionalContext();

    public Machine newMachine(String code, String brand, String model, String type, String serialNum, LocalDate instDate,
                              String desc, String plID, int protocolID) {
        ID id = new ID(code);
        Brand b = new Brand(brand);
        Model m = new Model(model);
        Type t = new Type(type);
        SerialNumber n = new SerialNumber(serialNum);
        InstallationDate date = new InstallationDate(instDate);
        MachineDescription description = new MachineDescription(desc);
        ProductionLineID pl = new ProductionLineID(plID);
        ProtocolId protID = new ProtocolId(protocolID);
        Machine machine = new Machine(id, b, m, t, description, date, n, pl, protID);
        return machine;
    }

    public boolean validatePLID(String plID) {
        ProductionLineID pl = new ProductionLineID(plID);
        return plRepository.findProductionLineByID(pl).isPresent();
    }

    public ProductionLine checkPLID(String plID) {
        ProductionLineID pl = new ProductionLineID(plID);
        return plRepository.findProductionLineByID(pl).get();
    }

    public Machine registerMachine(String code, String brand, String model, String type, String serialNum, LocalDate instDate,
                                   String desc, ProductionLine pl, int protocolID) {
        Machine mAux = newMachine(code, brand, model, type, serialNum, instDate, desc, pl.plID().productionLineID(), protocolID);
        pl.AddMachineToDefault(mAux);
        txCtx.beginTransaction();

        machineRepository.save(mAux);
        plRepository.save(pl);
        txCtx.commit();

        return mAux;
    }

    public Machine registerMachine(String code, String brand, String model, String type, String serialNum, LocalDate instDate,
                                   String desc, ProductionLine pl, int pos, int protocolID) {
        Machine mAux = newMachine(code, brand, model, type, serialNum, instDate, desc, pl.plID().productionLineID(), protocolID);
        pl.AddMachineSpecific(mAux, pos);
        txCtx.beginTransaction();

        machineRepository.save(mAux);
        plRepository.save(pl);
        txCtx.commit();

        return mAux;
    }
}
