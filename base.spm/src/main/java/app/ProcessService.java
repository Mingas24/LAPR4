package app;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.machinemanagement.domain.ProductionLine;
import eapli.base.machinemanagement.domain.ProductionLineID;
import eapli.base.machinemanagement.repositories.MachineRepository;
import eapli.base.machinemanagement.repositories.ProductionLineRepository;
import eapli.base.messagemanagement.domain.Message;
import eapli.base.messagemanagement.repositories.MessageRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ProcessService {
    MessageRepository repo = PersistenceContext.repositories().messages();
    ProductionLineRepository productionLineRepository = PersistenceContext.repositories().productionLines();
    MachineRepository machineRepository = PersistenceContext.repositories().machines();

    private void waitForThreads(List<ThreadProcess> threads) {
        try {
            for (ThreadProcess thread : threads) {
                thread.join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validateMessages(String[] pls, Date begin, Date end) {
        Iterable<Message> messages = repo.allOrderedMessages();
        List<ProductionLine> productionLines = new ArrayList<>();
        List<Message> messageList = new ArrayList<>();
        List<Message> messageProdLine;
        List<ThreadProcess> threadProcessList = new ArrayList<>();
        ThreadProcess threadProcess;
        for (String pl : pls) {
            if (productionLineRepository.findProductionLineByID(new ProductionLineID(pl)).isPresent()) {
                productionLines.add(productionLineRepository.findProductionLineByID(new ProductionLineID(pl)).get());
            }
        }
        for (Message message : messages) {
            if ((message.date().before(end) || message.date().equals(end)) && (message.date().after(begin) || message.date().equals(begin))) {
                messageList.add(message);
            }
        }
        for (ProductionLine productionLine : productionLines) {
            messageProdLine = new ArrayList<>();
            for (Message message : messages) {
                if (productionLine.order().contains(machineRepository.findMachineByID(message.idMac().id()).get())) {
                    messageProdLine.add(message);
                }
            }

            threadProcess = new ThreadProcess(productionLine, messageProdLine);
            threadProcess.start();
            threadProcessList.add(threadProcess);
        }

        waitForThreads(threadProcessList);
    }

}
