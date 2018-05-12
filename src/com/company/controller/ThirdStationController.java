package com.company.controller;

import com.company.model.ModelManager;
import com.company.model.Part;
import com.company.view.View;
import com.company.view.View3;

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
