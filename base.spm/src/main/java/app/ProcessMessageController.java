package app;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.machinemanagement.repositories.ProductionLineRepository;
import eapli.base.messagemanagement.repositories.MessageRepository;

import java.time.LocalDate;
import java.util.Date;


public class ProcessMessageController {
    private final ProductionLineRepository productionLineRepository = PersistenceContext.repositories().productionLines();
    private final MessageRepository messageRepository = PersistenceContext.repositories().messages();
    ProcessService thread = new ProcessService();

    public void processmentThreadBlock(String[] pls, Date begin, Date end) {
        thread.validateMessages(pls, begin, end);
    }
}
