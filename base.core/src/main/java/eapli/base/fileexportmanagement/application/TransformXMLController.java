package eapli.base.fileexportmanagement.application;

public class TransformXMLController {

    private final TransformXML trans = new TransformXML();

    public boolean chooseTransformation(int option){
        if(trans.transformationSelector(option)){
            return true;
        }else{
            return false;
        }
    }
}
