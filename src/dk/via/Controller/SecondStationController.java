package dk.via.Controller;

import dk.via.Controller.RMI.ClientRmi;
import dk.via.model.Car;
import dk.via.model.ModelManager;
import dk.via.model.Part;
import dk.via.view.View;

import java.rmi.RemoteException;

/**
 * Created by Libcoo on 11.05.2018.
 */
public class SecondStationController extends Controller{
    private ModelManager modelManager;
    public SecondStationController(){
        modelManager = ModelManager.getInstance();
    }

    public void dismantleTheCarpart(String vinNo, Part part) {
        //try{
        Car carToBeDismantled = /*ModelManager.getInstance().getCar(vinNo);*/ null;
        try {
            carToBeDismantled = ClientRmi.getInstance().getService().getCar(vinNo);
            part.setCar(carToBeDismantled);
            ClientRmi.getInstance().getService().updatePart(part);
            View.allert("the part " + part.toString() + " has been taken from the car " + carToBeDismantled);
        } catch (RemoteException e) {
            View.allert("there is no such a car in the warehouse");
            e.printStackTrace();
        }

            /*if (!(carToBeDismantled==null)){
                ModelManager.getInstance().dismantleTheCar(carToBeDismantled);
                View.allert(modelManager.getAllPalletes());
            } else View.allert("the car you wish to dismantle doesnt exist");
        }
        catch (NoSuchElementException e){
            View.allert(e.getMessage());
        }
        */
    }

    public Part makePart(String name, float weight, int id) {
        return new Part(weight, name, id);
    }
    //getne si auto podla vinka
    //creatne part z auta a da ho na prislusnu paletu paletu

}
