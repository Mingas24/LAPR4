package eapli.base.app.backoffice.console.presentation.ImportMessages;

import eapli.base.messagemanagement.application.MessageController;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.util.Console;


public class ImportUI extends AbstractUI {
    private final MessageController controller = new MessageController();


    @Override
    protected boolean doShow() {
        String path = Console.readLine("Insert the path where the messages are:");
        try {
            controller.threadService(path);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String headline() {
        return "\n<------Import the messages------>";
    }
}
