package eapli.base.floormanagement.application;

import eapli.base.floormanagement.domain.Deposit;
import eapli.base.floormanagement.domain.DepositID;
import eapli.base.floormanagement.domain.DepositType;
import eapli.base.floormanagement.domain.DescriptDeposit;
import eapli.base.floormanagement.repositories.DepositRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class DefineDepositService {

    //  private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final DepositRepository depositRepository = PersistenceContext.repositories().deposits();

    public Deposit deposit(String idDeposit, String depositType, String descript) {
        DepositID idDep = new DepositID(idDeposit);
        DescriptDeposit descriptDeposit = new DescriptDeposit(descript);
        if (depositType.trim().equalsIgnoreCase("Entry")) {
            Deposit entryDeposit = new Deposit(idDep, DepositType.ENTRY, descriptDeposit);
            return entryDeposit;
        } else if (depositType.trim().equalsIgnoreCase("Exit")) {
            Deposit exitDeposit = new Deposit(idDep, DepositType.EXIT, descriptDeposit);
            return exitDeposit;
        }
        return null;
    }

    public boolean defineDeposit(String idDeposit, String depositType, String descript) {
        Deposit depositAux = deposit(idDeposit, depositType, descript);
        Deposit deposit = this.depositRepository.save(depositAux);
        if (deposit != null) {
            return true;
        }
        return false;
    }
}
