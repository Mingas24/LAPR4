package eapli.base.messagemanagement.application;

import eapli.base.messagemanagement.domain.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Interperter {
    MessageController controller = new MessageController();

    public void checkType(String message) throws ParseException {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddmmss", Locale.ENGLISH);
        String[] line = message.split(";");
        if (!message.isEmpty()) {
            switch (line[1]) {
                case ("C0"):
                    c.setTime(sdf.parse(line[2]));
                    MessageConsume messageConsumes = controller.newMessageConsume(line[0], line[1], c, line[3], Integer.parseInt(line[4]), line[5]);
                    controller.registerMessage(messageConsumes);
                    break;
                case ("C9"):
                    c.setTime(sdf.parse(line[2]));
                    MessageDelivery messageDelivery = controller.newMessageDelivery(line[0], line[1], c, line[3], Integer.parseInt(line[4]), line[5]);
                    controller.registerMessage(messageDelivery);
                    break;
                case ("P2"):
                    c.setTime(sdf.parse(line[2]));
                    MessageReversal messageReversal = controller.newMessageReversal(line[0], line[1], c, line[3], Integer.parseInt(line[4]), line[5]);
                    controller.registerMessage(messageReversal);
                    break;
                case ("P1"):
                    c.setTime(sdf.parse(line[2]));
                    MessageProduction messageProduction = controller.newMessageProduction(line[0], line[1], c, line[3], Integer.parseInt(line[4]), line[5]);
                    controller.registerMessage(messageProduction);
                    break;
                case ("S0"):
                    c.setTime(sdf.parse(line[2]));
                    MessageBegginning messageBegginning = controller.newMessageBeggining(line[0], line[1], c, line[3]);
                    controller.registerMessage(messageBegginning);
                    break;
                case ("S1"):
                    c.setTime(sdf.parse(line[2]));
                    MessageResume messageResume = controller.newMessageResume(line[0], line[1], c);
                    controller.registerMessage(messageResume);
                    break;
                case ("S8"):
                    c.setTime(sdf.parse(line[2]));
                    MessageStop messageStop = controller.newMessageStop(line[0], line[1], c, line[3]);
                    controller.registerMessage(messageStop);
                    break;
                case ("S9"):
                    c.setTime(sdf.parse(line[2]));
                    MessageEnd messageEnd = controller.newMessageEnd(line[0], line[1], c, line[3]);
                    controller.registerMessage(messageEnd);
                    break;
                default:
                    break;
            }
        }
    }
}
