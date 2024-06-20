package eapli.base.app.backoffice.console.presentation.ExportXML;

import eapli.base.fileexportmanagement.application.ExportFactoryFloorToXMLController;
import eapli.framework.presentation.console.AbstractUI;

public class ExportFactoryFloorToXMLUI extends AbstractUI {

    private final ExportFactoryFloorToXMLController expt = new ExportFactoryFloorToXMLController();

    @Override
    protected boolean doShow() {
        if (expt.categoriesXML()) {
            System.out.println("Successful!");
        } else {
            System.out.println("Failure!");
        }
        return false;
    }

    @Override
    public String headline() {
        return "\n Export Factory Floor to XML";
    }
}
