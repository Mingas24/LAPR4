package eapli.base.machinemanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.machinemanagement.DTO.MachineDTO;
import eapli.base.machinemanagement.domain.ConfigurationSheet;
import eapli.base.machinemanagement.domain.Machine;
import eapli.base.machinemanagement.repositories.MachineRepository;
import eapli.base.util.ImportFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SpecifyConfigurationFileService {


    private final MachineRepository repo = PersistenceContext.repositories().machines();
    List<MachineDTO> listOfMachinesDTO = new ArrayList<>();
    Iterable<Machine> listOfMachines = repo.findAll();


    public List<MachineDTO> listMachines() {


        for (Machine m : listOfMachines) {


            MachineDTO mdto = new MachineDTO(m.machineId().id());
            listOfMachinesDTO.add(mdto);


        }

        if (listOfMachinesDTO.isEmpty()) {
            throw new NullPointerException();
        } else return listOfMachinesDTO;

    }


    public boolean specifyConfigFile(String machineID, String filename, String shortDesc) {


        ImportFile i = new ImportFile();
        List<String> fileLines = i.fileToList(filename);

        StringBuilder content = new StringBuilder();

        for (String s : fileLines) {
            content.append(s);
        }


        //------
        if (repo.findMachineByID(machineID).isPresent()) {
            Machine m = repo.findMachineByID(machineID).get();
            ConfigurationSheet cs = new ConfigurationSheet(content.toString());
            m.addConfig(cs, shortDesc);
            repo.save(m);
            return true;
        }

        return false;

    }
}
