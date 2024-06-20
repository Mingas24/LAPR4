package eapli.base.floormanagement.application;

import eapli.framework.application.UseCaseController;

@UseCaseController
public class DefineDepositController {

    private DefineDepositService svc = new DefineDepositService();

    public boolean defineDeposit(String idDeposit, String typeDeposit, String descriptDeposit) {
        return this.svc.defineDeposit(idDeposit, typeDeposit, descriptDeposit);
    }

    public boolean validateIdDeposit(String idDeposit){
        if(idDeposit.length() > 10){
            return false;
        }
        return true;
    }

    public boolean validateTypeDeposit(String typeDeposit){
        if(typeDeposit.trim().equalsIgnoreCase("Entry") ||
                typeDeposit.trim().equalsIgnoreCase("Exit")){
            return true;
        }
        return false;
    }

    public boolean validatedescriptDeposit (String descript){
        if(descript.length() > 50){
            return false;
        }
        return true;
    }

}
