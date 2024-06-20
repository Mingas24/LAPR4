package eapli.base.app.backoffice.console.presentation.MachineConfigurationFile;

import eapli.base.machinemanagement.DTO.MachineDTO;
import eapli.framework.visitor.Visitor;

public class MachinePrinter implements Visitor<MachineDTO> {


    @Override
    public void visit(MachineDTO visitee) {
        System.out.printf("Machine{" +
                "machineID=" + visitee.machineID() + '}');
    }


}
