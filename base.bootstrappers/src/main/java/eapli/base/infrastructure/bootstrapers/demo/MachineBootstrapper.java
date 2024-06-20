package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.machinemanagement.application.MachineController;
import eapli.base.machinemanagement.domain.Machine;
import eapli.base.machinemanagement.domain.ProductionLine;
import eapli.base.machinemanagement.domain.ProductionLineID;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;

public class MachineBootstrapper implements Action {

    private static final Logger LOGGER = LogManager.getLogger(ProductBootstrapper.class);

    private final MachineController controller = new MachineController();

    @Override
    public boolean execute() {
        register("DD4", "SAMSUNG", "ASSEMBLY-LINE-ORDENATOR", "ORDENATOR", "3366998877",
                LocalDate.parse("2020-03-27"), "ORDENATOR", "Line 1", 1);
        register("T3", "BOSCH", "HAND-SANITIZER_DISPENSERINATOR", "DISPENSER", "456393578",
                LocalDate.parse("2019-11-01"), "A dispenser for hand sanitizer", "Line 1", 2);
        register("FCP", "HYUNDAI", "PRODUCT ASSEMBLER GENERATION3", "ASSEMBLER", "9998887773",
                LocalDate.parse("2019-09-11"), "Assembles Products",  "Line 2", 3);
        register("SCP", "FORD", "CONVEYOR BELT GENERATION DELTA", "CONVEYOR BELT", "123456754",
                LocalDate.parse("2019-12-25"), "USED FOR TRANSPORTING OBJECTS", "Line 2", 4);

        return true;
    }


    private void register(String code, String brand, String model, String type, String serialNum, LocalDate instDate,
                          String desc, String plID, int protocolID) {
        if (this.controller.validatePLID(plID)) {
            try {
                ProductionLine pl = controller.checkPLID(plID);
                Machine m = this.controller.registerMachine(code, brand, model, type, serialNum,
                        instDate, desc, pl, protocolID);
                pl.AddMachineToDefault(m);
            } catch (IntegrityViolationException | ConcurrencyException e) {
                LOGGER.warn("Assuming {} already exists (activate trace log for details)", "machine");
                LOGGER.trace("Assuming existing record", e);
            }
        }
    }
}
