package com.company.controller;
import com.company.model.*;
import com.company.view.*;
import java.util.ArrayList;

/**
 * Created by Libcoo on 11.05.2018.
 */
public class FirstStationController extends Controller {
    private View view;
    private ModelManager modelManager;

    public FirstStationController(){
        modelManager = ModelManager.getInstance();
    }

    public void registerCar(String licensePlate, String model, float weight){
        Car incomingCar = new Car(licensePlate,model,weight);
        modelManager.registerNewCar(incomingCar);
    }
    public String getAllCars()
    {
        return modelManager.getAllCars();
    }
}
