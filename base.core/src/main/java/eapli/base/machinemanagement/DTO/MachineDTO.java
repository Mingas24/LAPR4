package eapli.base.machinemanagement.DTO;

public class MachineDTO {

    public String machineID;


    public MachineDTO(String machineID) {
        this.machineID = machineID;
    }

    public String machineID() {
        return machineID;
    }

    @Override
    public String toString() {
        return "MachineDTO{" +
                "machineID='" + machineID + '\'' +
                '}';
    } 
}
