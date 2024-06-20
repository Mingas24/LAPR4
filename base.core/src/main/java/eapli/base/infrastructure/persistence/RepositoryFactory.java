/**
 *
 */
package eapli.base.infrastructure.persistence;

import eapli.base.categorymanagement.repository.CategoryRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;

import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.errornotificationmanagement.repositories.ErrorNotificationRepository;
import eapli.base.floormanagement.repositories.DepositRepository;
import eapli.base.machinemanagement.domain.Machine;
import eapli.base.machinemanagement.repositories.MachineRepository;
import eapli.base.machinemanagement.repositories.ProductionLineRepository;
import eapli.base.machinemanagement.repositories.RequestFileRepository;
import eapli.base.messagemanagement.repositories.MessageRepository;
import eapli.base.productionordermanagement.domain.ProductionOrder;
import eapli.base.productionordermanagement.repository.ProductionOrderRepository;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.base.rawmaterial.repository.RawMaterialRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

/**
 * @author Paulo Gandra Sousa
 *
 */
public interface RepositoryFactory {

    /**
     * factory method to create a transactional context to use in the repositories
     *
     * @return
     */
    TransactionalContext newTransactionalContext();

    /**
     *
     * @param autoTx the transactional context to enrol
     * @return
     */
    UserRepository users(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    UserRepository users();

    /**
     *
     * @param autoTx the transactional context to enroll
     * @return
     */
    ClientUserRepository clientUsers(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    ClientUserRepository clientUsers();

    /**
     *
     * @param autoTx the transactional context to enroll
     * @return
     */
    SignupRequestRepository signupRequests(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    SignupRequestRepository signupRequests();

    DepositRepository deposits();

    ProductionLineRepository productionLines();

    ProductRepository product();

    RawMaterialRepository rawMaterials();

    MachineRepository machines();

    CategoryRepository categories();

    ProductionOrderRepository productionOrder();

    MessageRepository messages();

    ErrorNotificationRepository errorNotifications();

    RequestFileRepository requestFiles();

}
