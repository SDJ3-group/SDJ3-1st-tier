package com.company.controller;
import com.company.model.*;
import com.company.view.*;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.NoSuchElementException;

/**
 * Created by Libcoo on 11.05.2018.
 */
public class SecondStationController extends Controller{
    private ModelManager modelManager;
    public SecondStationController(){
        modelManager = ModelManager.getInstance();
    }

    public void dismantleTheCar(String licensePlate){
        try{
            Car carToBeDismantled = ModelManager.getInstance().getCar(licensePlate);
            if (!(carToBeDismantled==null)){
                ModelManager.getInstance().dismantleTheCar(carToBeDismantled);
                View.allert(modelManager.getAllPalletes());
            } else View.allert("the car you wish to dismantle doesnt exist");
        }
        catch (NoSuchElementException e){
            View.allert(e.getMessage());
        }
    }

}
