package eapli.base.app.backoffice.console.presentation.MachineConfigurationFile;


import eapli.base.machinemanagement.DTO.MachineDTO;
import eapli.base.machinemanagement.application.SpecifyConfigurationFileController;
import eapli.base.machinemanagement.application.SpecifyConfigurationFileService;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import eapli.framework.util.Console;

public class ConfigurationFileUI extends AbstractUI {

    private final SpecifyConfigurationFileController scfc = new SpecifyConfigurationFileController();
    private final SpecifyConfigurationFileService service = new SpecifyConfigurationFileService();

    @Override
    protected boolean doShow() {

        final Iterable<MachineDTO> listDTO = scfc.listMachines();

        final SelectWidget<MachineDTO> sw = new SelectWidget<>("machine list: ", listDTO, new MachinePrinter());

        sw.show();

        final MachineDTO mdto = sw.selectedElement();

        String mFile = Console.readLine("Insert the configuration file path:");

        String desc = Console.readLine("Insert a short description:");

        try {
            //Save configuration file
            service.specifyConfigFile(mdto.machineID, mFile, desc);
            System.out.println("Configuration file saved\n");
        } catch (final IntegrityViolationException e) {
            System.out.println("ERROR! Invalid machine id!\n");
        }

        return false;
    }

    @Override
    public String headline() {
        return "\n<---------Specify configuration file--------->";
    }
}
