package eapli.base.persistence.impl.inmemory;

import eapli.base.categorymanagement.repository.CategoryRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.errornotificationmanagement.repositories.ErrorNotificationRepository;
import eapli.base.floormanagement.repositories.DepositRepository;
import eapli.base.infrastructure.bootstrapers.BaseBootstrapper;
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
import eapli.framework.infrastructure.authz.repositories.impl.InMemoryUserRepository;

/**
 *
 * Created by nuno on 20/03/16.
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

	static {
		// only needed because of the in memory persistence
		new BaseBootstrapper().execute();
	}

	@Override
	public UserRepository users(final TransactionalContext tx) {
		return new InMemoryUserRepository();
	}

	@Override
	public UserRepository users() {
		return users(null);
	}


	@Override
	public ClientUserRepository clientUsers(final TransactionalContext tx) {

		return new InMemoryClientUserRepository();
	}

	@Override
	public ClientUserRepository clientUsers() {
		return clientUsers(null);
	}

	@Override
	public SignupRequestRepository signupRequests() {
		return signupRequests(null);
	}

	@Override
	public DepositRepository deposits() { return new InMemoryDepositRepository(); }

	@Override
	public ProductionLineRepository productionLines() { return new InMemoryPLRepository(); }

	@Override
	public ProductRepository product(){return new InMemoryProductRepository();}

	@Override
	public RawMaterialRepository rawMaterials() { return new InMemoryRawMaterialRepository(); }


	@Override
	public MachineRepository machines() { return new InMemoryMachinesRepository();}

	@Override
	public CategoryRepository categories() { return new InMemoryCategoryRepository(); }
        
        @Override
        public ProductionOrderRepository productionOrder() {
            return new InMemoryProductionOrderRepository();
    }

	@Override
	public MessageRepository messages() {
		return new InMemoryMessageRepository();
	}

	@Override
	public ErrorNotificationRepository errorNotifications(){return new InMemoryNotificationErrorRepository();}

	@Override
	public RequestFileRepository requestFiles() {
		return new InMemoryRequestFile();
	}

	@Override
	public SignupRequestRepository signupRequests(final TransactionalContext tx) {
		return new InMemorySignupRequestRepository();
	}

	@Override
	public TransactionalContext newTransactionalContext() {
		// in memory does not support transactions...
		return null;
	}

}
