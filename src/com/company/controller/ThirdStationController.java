package com.company.controller;
import com.company.model.*;
import com.company.view.*;

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
            view.allert(e.getMessage());
        }
    }


    public void prepareASystemPackage(String model, int noOfObjects){
        modelManager.prepareASystemPackage(model,  noOfObjects);
    }


}
