package eapli.base.messagemanagement.application;

import eapli.base.errornotificationmanagement.domain.ErrorNotification;
import eapli.base.errornotificationmanagement.domain.ErrorType;
import eapli.base.errornotificationmanagement.domain.NotificationDate;
import eapli.base.errornotificationmanagement.dto.ErrorNotificationDTO;
import eapli.base.errornotificationmanagement.repositories.ErrorNotificationRepository;
import eapli.base.floormanagement.domain.DepositID;
import eapli.base.floormanagement.repositories.DepositRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.machinemanagement.domain.ID;
import eapli.base.messagemanagement.domain.*;
import eapli.base.messagemanagement.repositories.MessageRepository;
import eapli.base.productionordermanagement.domain.ProductionOrderId;
import eapli.base.productionordermanagement.repository.ProductionOrderRepository;
import eapli.base.productmanagement.domain.*;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.base.rawmaterial.domain.RawMaterialInternalCode;
import eapli.base.rawmaterial.repository.RawMaterialRepository;
import eapli.framework.application.UseCaseController;

import java.util.Calendar;

@UseCaseController
public class MessageController {
    private final MessageRepository messageRepository = PersistenceContext.repositories().messages();
    private final ProductRepository productRepository = PersistenceContext.repositories().product();
    private final ProductionOrderRepository productionOrderRepository = PersistenceContext.repositories().productionOrder();
    private final DepositRepository depositRepository = PersistenceContext.repositories().deposits();
    private final RawMaterialRepository rawMaterialRepository = PersistenceContext.repositories().rawMaterials();
    private final ErrorNotificationRepository errorNotificationRepository = PersistenceContext.repositories().errorNotifications();

    public final ThreadService threadServices = new ThreadService();


    public void threadService(String path) throws InterruptedException {
        threadServices.createThread(path);
    }

    public UniqueFabricationCode newProduct(String ufp) {
        if (productRepository.findProductByUFP(ufp).isPresent()) {
            return productRepository.findProductByUFP(ufp).get().unFabCode();
        } else {
            return null;
        }
    }

    public DepositID newDeposit(String deposit) {
        if (depositRepository.findDepositByID(deposit).isPresent()) {
            return depositRepository.findDepositByID(deposit).get().depositId();
        } else {
            return null;
        }
    }

    public ProductionOrderId newProductionOrder(String productionOrder) {
        if (productionOrderRepository.findProductionOrderByProductionOrderId(productionOrder).isPresent()) {
            return productionOrderRepository.findProductionOrderByProductionOrderId(productionOrder).get().ProductionOrderID();
        } else {
            return null;
        }
    }

    public RawMaterialInternalCode newRawMaterial(String rawMaterial) {
        if (rawMaterialRepository.findMaterialByID(rawMaterial).isPresent()) {
            return rawMaterialRepository.findMaterialByID(rawMaterial).get().rawMaterialInternalCode();
        } else {
            return null;
        }
    }

    public MessageBegginning newMessageBeggining(String id, String messageType, Calendar date, String productionOrderId) {
        ID id1 = new ID(id);
        if (newProductionOrder(productionOrderId) != null) {
            ProductionOrderId productionOrder = newProductionOrder(productionOrderId);
            if (messageType.trim().equalsIgnoreCase("S0")) {
                return new MessageBegginning(id1, date, productionOrder);
            }
        } else {
            errorNotificationRepository.save(new ErrorNotification(new NotificationDate(date.getTime()), ErrorType.INEXISTENT_PRODUCTION_ORDER));
        }
        return null;
    }

    public MessageConsume newMessageConsume(String id, String messageType, Calendar date,
                                            String ufp, int quantity, String depositID) {
        ID id1 = new ID(id);
        if (newDeposit(depositID) != null) {
            DepositID dt = newDeposit(depositID);
            if (messageType.trim().equalsIgnoreCase("C0")) {
                try {
                    if (newProduct(ufp) == null) {
                        RawMaterialInternalCode rm = newRawMaterial(ufp);
                        return new MessageConsume(id1, date, rm, quantity, dt);
                    } else {
                        UniqueFabricationCode prod = newProduct(ufp);
                        return new MessageConsume(id1, date, prod, quantity, dt);
                    }
                } catch (Exception e) {
                    System.out.println("Product/RawMaterial not found");
                }
            }
        } else {
            errorNotificationRepository.save(new ErrorNotification(new NotificationDate(date.getTime()), ErrorType.INEXISTENT_DEPOSIT));
        }


        return null;
    }

    public MessageDelivery newMessageDelivery(String id, String messageType, Calendar date,
                                              String ufp, int quantity, String depositID) {
        ID id1 = new ID(id);
        if (newDeposit(depositID) != null) {
            DepositID dt = newDeposit(depositID);
            if (messageType.trim().equalsIgnoreCase("C9")) {
                UniqueFabricationCode prod = newProduct(ufp);
                return new MessageDelivery(id1, date, prod, quantity, dt);
            }
        } else {
            errorNotificationRepository.save(new ErrorNotification(new NotificationDate(date.getTime()), ErrorType.INEXISTENT_DEPOSIT));
        }
        return null;
    }

    public MessageReversal newMessageReversal(String id, String messageType, Calendar date,
                                              String ufp, int quantity, String depositID) {
        ID id1 = new ID(id);
        if (newDeposit(depositID) != null) {
            DepositID dt = newDeposit(depositID);
            if (messageType.trim().equalsIgnoreCase("C0")) {
                RawMaterialInternalCode rm = newRawMaterial(ufp);
                return new MessageReversal(id1, date, rm, quantity, dt);

            }
        } else {
            errorNotificationRepository.save(new ErrorNotification(new NotificationDate(date.getTime()), ErrorType.INEXISTENT_DEPOSIT));
        }
        return null;
    }

    public MessageEnd newMessageEnd(String id, String messageType, Calendar date, String productionOrderId) {
        ID id1 = new ID(id);
        if (newProductionOrder(productionOrderId.trim()) != null) {
            ProductionOrderId productionOrder = newProductionOrder(productionOrderId);
            if (messageType.trim().equalsIgnoreCase("S9")) {
                return new MessageEnd(id1, date, productionOrder);
            }
        } else {
            errorNotificationRepository.save(new ErrorNotification(new NotificationDate(date.getTime()), ErrorType.INEXISTENT_PRODUCTION_ORDER));
        }
        return null;
    }

    public MessageProduction newMessageProduction(String id, String messageType, Calendar date, String ufp,
                                                  int quantity, String lot) {
        ID id1 = new ID(id);
        if (messageType.trim().equalsIgnoreCase("P1")) {
            if (newProduct(ufp) == null) {
                RawMaterialInternalCode rm = newRawMaterial(ufp);
                return new MessageProduction(id1, date, rm, quantity, lot);
            } else {
                UniqueFabricationCode prod = newProduct(ufp);
                return new MessageProduction(id1, date, prod, quantity, lot);
            }
        }
        return null;
    }

    public MessageResume newMessageResume(String id, String messageType, Calendar date) {
        ID id1 = new ID(id);
        if (messageType.trim().equalsIgnoreCase("S1")) {
            return new MessageResume(id1, date);
        }
        return null;
    }

    public MessageStop newMessageStop(String id, String messageType, Calendar date, String error) {
        ID id1 = new ID(id);
        if (messageType.trim().equalsIgnoreCase("S8")) {
            return new MessageStop(id1, date, ErrorType.valueOf(error));
        }
        return null;
    }

    public Message registerMessage(Message message) {
        return messageRepository.save(message);
    }
}
