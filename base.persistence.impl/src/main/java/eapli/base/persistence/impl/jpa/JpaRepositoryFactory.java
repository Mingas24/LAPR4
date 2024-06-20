package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.categorymanagement.repository.CategoryRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.errornotificationmanagement.repositories.ErrorNotificationRepository;
import eapli.base.floormanagement.repositories.DepositRepository;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.machinemanagement.repositories.MachineRepository;
import eapli.base.machinemanagement.repositories.ProductionLineRepository;
import eapli.base.machinemanagement.repositories.RequestFileRepository;
import eapli.base.messagemanagement.repositories.MessageRepository;
import eapli.base.productionordermanagement.repository.ProductionOrderRepository;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.base.rawmaterial.repository.RawMaterialRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.JpaAutoTxUserRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 * Created by nuno on 21/03/16.
 */
public class JpaRepositoryFactory implements RepositoryFactory {

    @Override
    public UserRepository users(final TransactionalContext autoTx) {
        return new JpaAutoTxUserRepository(autoTx);
    }

    @Override
    public UserRepository users() {
        return new JpaAutoTxUserRepository(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }


    @Override
    public JpaClientUserRepository clientUsers(final TransactionalContext autoTx) {
        return new JpaClientUserRepository(autoTx);
    }

    @Override
    public JpaClientUserRepository clientUsers() {
        return new JpaClientUserRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext autoTx) {
        return new JpaSignupRequestRepository(autoTx);
    }

    @Override
    public SignupRequestRepository signupRequests() {
        return new JpaSignupRequestRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public DepositRepository deposits() {
        return new JpaDepositRepository();
    }

    @Override
    public ProductionLineRepository productionLines() {
        return new JpaPLRepository();
    }

    @Override
    public ProductRepository product() {
        return new JpaProductRepository();
    }

    @Override
    public RawMaterialRepository rawMaterials() {
        return new JpaRawMaterialRepository();
    }

    @Override
    public MachineRepository machines() {
        return new JpaMachineRepository();
    }

    @Override
    public CategoryRepository categories() {
        return new JpaCategoryRepository();
    }

    @Override
    public ProductionOrderRepository productionOrder() {
        return new JpaProductionOrderRepository();
    }

    @Override
    public MessageRepository messages() {
        return new JpaMessageRepository();
    }

    @Override
    public ErrorNotificationRepository errorNotifications() {
        return new JpaErrorNotificationRepository();
    }

    @Override
    public RequestFileRepository requestFiles() {
        return new JPARequestFile();
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        return JpaAutoTxRepository.buildTransactionalContext(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }
}
