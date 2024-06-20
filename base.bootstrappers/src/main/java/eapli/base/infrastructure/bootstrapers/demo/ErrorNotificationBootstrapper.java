package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.errornotificationmanagement.domain.*;
import eapli.base.errornotificationmanagement.repositories.ErrorNotificationRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.machinemanagement.repositories.MachineRepository;
import eapli.framework.actions.Action;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.Date;


public class ErrorNotificationBootstrapper implements Action {

    private static final Logger LOGGER = LogManager.getLogger(ProductBootstrapper.class);

    private final ErrorNotificationRepository repository = PersistenceContext.repositories().errorNotifications();
    private final MachineRepository repo = PersistenceContext.repositories().machines();

    @Override
    public boolean execute() {
        ErrorNotification err = new ErrorNotification(new NotificationDate(new Date(System.currentTimeMillis())),
                ErrorType.INEXISTENT_PRODUCT);
        err.changeMachine(repo.findMachineByID("DD4").get());
        repository.save(err);

        ErrorNotification err1 = new ErrorNotification(new NotificationDate(new Date(System.currentTimeMillis())),
                ErrorType.INEXISTENT_DEPOSIT);
        err1.changeMachine(repo.findMachineByID("T3").get());
        repository.save(err1);

        ErrorNotification err2 = new ErrorNotification(new NotificationDate(new Date(System.currentTimeMillis())),
                ErrorType.INEXISTENT_PRODUCTION_LINE);
        err2.changeMachine(repo.findMachineByID("FCP").get());
        repository.save(err2);

        ErrorNotification err3 = new ErrorNotification(new NotificationDate(new Date(System.currentTimeMillis())),
                ErrorType.INEXISTENT_RAWMATERIAL);
        err3.changeMachine(repo.findMachineByID("SCP").get());
        repository.save(err3);

        return true;
    }
}
