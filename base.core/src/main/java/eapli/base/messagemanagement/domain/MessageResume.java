package eapli.base.messagemanagement.domain;

import eapli.base.machinemanagement.domain.ID;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Calendar;

@Entity
@DiscriminatorValue("S1")
public class MessageResume extends Message {

    public MessageResume(ID id,Calendar date) {
        super(id, date);
    }

    public MessageResume() {
    }
}
