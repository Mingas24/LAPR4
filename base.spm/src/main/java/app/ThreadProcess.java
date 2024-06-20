package app;

import eapli.base.errornotificationmanagement.domain.ErrorNotification;
import eapli.base.errornotificationmanagement.domain.ErrorType;
import eapli.base.errornotificationmanagement.domain.NotificationDate;
import eapli.base.errornotificationmanagement.repositories.ErrorNotificationRepository;
import eapli.base.floormanagement.domain.Deposit;
import eapli.base.floormanagement.domain.DepositType;
import eapli.base.floormanagement.repositories.DepositRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.machinemanagement.domain.ProductionLine;
import eapli.base.machinemanagement.domain.ProductionLineProcessingState;
import eapli.base.machinemanagement.repositories.MachineRepository;
import eapli.base.messagemanagement.domain.*;
import eapli.base.messagemanagement.repositories.MessageRepository;
import eapli.base.productionordermanagement.domain.ProductionOrder;
import eapli.base.productionordermanagement.repository.ProductionOrderRepository;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.base.rawmaterial.repository.RawMaterialRepository;

import java.util.Calendar;
import java.util.List;

public class ThreadProcess extends Thread {
    private final ProductionLine productionLine;
    private final List<Message> messageList;


    private final ErrorNotificationRepository errorNotificationRepository = PersistenceContext.repositories().errorNotifications();
    private final ProductionOrderRepository productionOrderRepository = PersistenceContext.repositories().productionOrder();
    private final MessageRepository messageRepository = PersistenceContext.repositories().messages();
    private final MachineRepository machineRepository = PersistenceContext.repositories().machines();
    private final RawMaterialRepository rawMaterialRepository = PersistenceContext.repositories().rawMaterials();
    private final ProductRepository productRepository = PersistenceContext.repositories().product();
    private final DepositRepository depositRepository = PersistenceContext.repositories().deposits();
    Iterable<ProductionOrder> productionOrders = productionOrderRepository.findAll();


    public ThreadProcess(ProductionLine productionLine, List<Message> messageList) {
        this.messageList = messageList;
        this.productionLine = productionLine;
    }

    @Override
    public void run() {
        productionLine.changeState(ProductionLineProcessingState.ACTIVATED);
        ProductionOrder productionOrder = null;
        for (Message message : messageList) {
            if (productionLine.state().equals(ProductionLineProcessingState.ACTIVATED)) {
                message.setProductionLine(productionLine);
                if (message instanceof MessageBegginning) {
                    productionOrder = productionOrderRepository.findProductionOrderByProductionOrderId(((MessageBegginning) message).productionOrderId().productOrderId()).get();
                    productionOrder.setProductionLine(productionLine);
                    System.out.println(machineRepository.findMachineByID(message.idMac().id()).get());
                    productionOrder.processBegginingMessage(message, machineRepository.findMachineByID(message.idMac().id()).get());
                    productionOrderRepository.save(productionOrder);
                }
                if (productionOrder != null) {
                    if (message instanceof MessageStop) {
                        productionOrder.processStopMessage(message, machineRepository.findMachineByID(message.idMac().id()).get());
                        productionOrderRepository.save(productionOrder);
                    }
                    if (message instanceof MessageResume) {
                        productionOrder.processBegginingMessage(message, machineRepository.findMachineByID(message.idMac().id()).get());
                        productionOrderRepository.save(productionOrder);
                    }
                    if (message instanceof MessageEnd) {
                        productionOrder.processEndMessage(message, machineRepository.findMachineByID(message.idMac().id()).get());
                        productionOrderRepository.save(productionOrder);
                        productionOrder = null;
                    }
                    if (message instanceof MessageConsume) {
                        Deposit deposit = depositRepository.findDepositByID(((MessageConsume) message).getDeposit().depositId()).get();
                        if (deposit.typeDeposit() == DepositType.ENTRY) {
                            errorNotificationRepository.save(new ErrorNotification(new NotificationDate(message.date().getTime()), ErrorType.INEXISTENT_DEPOSIT));
                        } else {
                            if (((MessageConsume) message).getProduct() == null) {
                                productionOrder.processConsumeMessageRaw((MessageConsume) message,
                                        rawMaterialRepository.findMaterialByID(((MessageConsume) message).getRawMaterial().toString()).get());
                                productionOrderRepository.save(productionOrder);
                            } else {
                                productionOrder.processConsumeMessageProd((MessageConsume) message,
                                        productRepository.findProductByUFP(((MessageConsume) message).getProduct().unFabCode()).get());
                                productionOrderRepository.save(productionOrder);
                            }
                        }
                    }
                    if (message instanceof MessageProduction) {
                        productionOrder.processProductionMessage((MessageProduction) message,
                                productRepository.findProductByUFP(((MessageProduction) message).getProduct().unFabCode()).get());
                        productionOrderRepository.save(productionOrder);
                    }
                    if (message instanceof MessageReversal) {
                        productionOrder.processReversalMessage((MessageReversal) message,
                                rawMaterialRepository.findMaterialByID(((MessageConsume) message).getRawMaterial().toString()).get());
                        productionOrderRepository.save(productionOrder);

                    }
                    if (message instanceof MessageDelivery) {
                        productionOrder.processDeliveryMessage((MessageDelivery) message,
                                depositRepository.findDepositByID(((MessageDelivery) message).getDeposit().depositId()).get());
                        productionOrderRepository.save(productionOrder);
                        try {
                            Thread.sleep(1000 * 10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }


                } else {
                    errorNotificationRepository.save(new ErrorNotification(new NotificationDate(message.date().getTime()), ErrorType.INEXISTENT_PRODUCTION_ORDER));
                }
                message.changeStatus();
                messageRepository.save(message);
            }
        }
        productionLine.changeState(ProductionLineProcessingState.DEACTIVATED);
        productionLine.changeLastMessageProcessing(Calendar.getInstance());
    }
}
