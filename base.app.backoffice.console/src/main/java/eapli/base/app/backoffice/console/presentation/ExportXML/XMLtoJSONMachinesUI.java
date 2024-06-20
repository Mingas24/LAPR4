package eapli.base.app.backoffice.console.presentation.ExportXML;

import eapli.base.fileexportmanagement.application.TransformXMLController;
import eapli.framework.presentation.console.AbstractUI;

public class XMLtoJSONMachinesUI extends AbstractUI {

    private final TransformXMLController trans = new TransformXMLController();

    @Override
    protected boolean doShow() {
        if (trans.chooseTransformation(8)){
            System.out.println("Successful!");
        }else{
            System.out.println("Failure!");
        }
        return true;
    }

    @Override
    public String headline() {
        return "\n XML to JSON *Machines*";
    }
}
