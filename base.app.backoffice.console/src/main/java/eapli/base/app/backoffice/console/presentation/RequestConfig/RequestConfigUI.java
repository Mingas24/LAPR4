package eapli.base.app.backoffice.console.presentation.RequestConfig;

import eapli.base.app.backoffice.console.presentation.MachineConfigurationFile.MachinePrinter;
import eapli.base.machinemanagement.DTO.MachineDTO;
import eapli.base.machinemanagement.application.SpecifyConfigurationFileController;
import eapli.base.machinemanagement.application.SpecifyConfigurationFileService;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import eapli.framework.util.Console;

public class RequestConfigUI extends AbstractUI {

    private final SpecifyConfigurationFileController controller = new SpecifyConfigurationFileController();
    private final SpecifyConfigurationFileService service = new SpecifyConfigurationFileService();

    @Override
    protected boolean doShow() {
        final Iterable<MachineDTO> listDTO = controller.listMachines();
        final SelectWidget<MachineDTO> selectWidget = new SelectWidget<>("Choose the machine you wish to add the file:", listDTO, new MachinePrinter());

        selectWidget.show();

        final MachineDTO mdto = selectWidget.selectedElement();

        final String name = Console.readLine("Insert the file name:");

        try {
            controller.sendFile(mdto.machineID, name);
        } catch (Exception e) {
            System.out.println("Something is wrong");
        }
        return false;
    }

    @Override
    public String headline() {
        return null;
    }
}
