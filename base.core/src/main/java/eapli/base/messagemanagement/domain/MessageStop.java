package eapli.base.messagemanagement.domain;

import eapli.base.errornotificationmanagement.domain.ErrorType;
import eapli.base.machinemanagement.domain.ID;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Calendar;

@Entity
@DiscriminatorValue("S8")
public class MessageStop extends Message {

    @Column
    private ErrorType error;

    public MessageStop(ID id,Calendar date, ErrorType error) {
        super(id, date);
        this.error=error;
    }

    public MessageStop() {
    }
}
