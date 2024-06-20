package eapli.base.machinemanagement.DTO;

import eapli.framework.representations.dto.DTO;

import java.util.Calendar;

@DTO
public class ProductionLineDTO {

    public String productionLineID;
    public String processingState;
    public Calendar lastProcessing;

    public ProductionLineDTO(String productionLineID, String processingState, Calendar lastProcessing) {
        this.productionLineID = productionLineID;
        this.processingState = processingState;
        this.lastProcessing = lastProcessing;
    }

    public String productionLineID() {
        return productionLineID;
    }

    public String processingState() {
        return processingState;
    }

    public Calendar lastProcessing() {
        return lastProcessing;
    }
}
