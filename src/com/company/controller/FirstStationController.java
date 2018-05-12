package com.company.controller;

import com.company.controller.Rmi.ClientRmi;
import com.company.model.Car;
import com.company.model.ModelManager;
import com.company.view.View;

import java.rmi.RemoteException;

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
        //modelManager.registerNewCar(incomingCar);
        try {
            ClientRmi.getInstance().getService().addCar(incomingCar);
            View.allert("The car " + incomingCar.toString() + " has been added");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    public String getAllCars()
    {
        try {
            return ClientRmi.getInstance().getService().getAllCars().toString();//modelManager.getAllCars();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }
}
