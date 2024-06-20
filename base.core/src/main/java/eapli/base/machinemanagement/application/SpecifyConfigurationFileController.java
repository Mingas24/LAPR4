package eapli.base.machinemanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.machinemanagement.DTO.MachineDTO;
import eapli.base.machinemanagement.domain.ConfigurationSheet;
import eapli.base.machinemanagement.domain.Machine;
import eapli.base.machinemanagement.domain.RequestConfigurationFile;
import eapli.base.machinemanagement.repositories.MachineRepository;
import eapli.base.machinemanagement.repositories.RequestFileRepository;
import eapli.base.util.ImportFile;

import java.io.File;
import java.util.List;

public class SpecifyConfigurationFileController {

    private SpecifyConfigurationFileService cfs = new SpecifyConfigurationFileService();
    private RequestFileRepository requestFileRepository = PersistenceContext.repositories().requestFiles();
    private MachineRepository machineRepository = PersistenceContext.repositories().machines();
    private ImportFile importer = new ImportFile();

    public List<MachineDTO> listMachines() {

        List<MachineDTO> mDTO = cfs.listMachines();

        return mDTO;
    }


    public boolean specifyConfigFile(String machineID, String filename, String shortDesc) {
        return cfs.specifyConfigFile(machineID, filename, shortDesc);
    }

    public void sendFile(String machineID, String file){
        List<String> fileLines = importer.fileToList(file);
        StringBuilder content = new StringBuilder();
        for (String s : fileLines) {
            content.append(s);
        }
        ConfigurationSheet cs = new ConfigurationSheet(content.toString());
        requestFileRepository.save(new RequestConfigurationFile(machineRepository.findMachineByID(machineID).get().protocolId(), cs));
    }
}
