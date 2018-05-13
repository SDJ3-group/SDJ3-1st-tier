package dk.via.Controller;

import dk.via.model.ModelManager;
import dk.via.model.Part;
import dk.via.view.View;
import dk.via.view.View3;

import javax.naming.NoPermissionException;

/**
 * Created by Libcoo on 11.05.2018.
 */
public class ThirdStationController extends Controller {
    private ModelManager modelManager;
    private View view;
    public ThirdStationController(){
        modelManager = ModelManager.getInstance();
        this.view=new View3();
    }

    public void makeAPackage(int noOfObjects, Part whatType){
        try {
            modelManager.makeAPackage(noOfObjects, whatType);

        } catch (NoPermissionException e){
            View.allert(e.getMessage());
        }
    }
    //takze nie ze sa ma zrobic samo, ale chceme interactovat s guickom
    // party sa sami nepriradia do packagu ale pride user a zaregistruje part ktoremu sa priradi package


    public void prepareASystemPackage(String model, int noOfObjects){
        modelManager.prepareASystemPackage(model,  noOfObjects);
    }


}
