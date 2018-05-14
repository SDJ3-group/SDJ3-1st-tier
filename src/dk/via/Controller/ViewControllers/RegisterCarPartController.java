package dk.via.Controller.ViewControllers;

import dk.via.Controller.RMI.ClientRmi;
import dk.via.model.*;
import dk.via.view.View;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class RegisterCarPartController extends ViewManager {

    public ComboBox carsIdCB;
    public TextField idTF;
    public TextField nameTF;
    public TextField weightTF;
    public Button registerBtn;
    public Button backBtn;

    private ArrayList<String> carIDs = new ArrayList<>();

    private ModelManager modelManager;

    @FXML
    public void initialize() {
        ObservableList<String> carIDsList = FXCollections.observableArrayList(getCarIDs());
        carsIdCB.setItems(carIDsList);
    }

    public RegisterCarPartController() {
        modelManager = ModelManager.getInstance();
    }

    private ArrayList<String> getCarIDs() {
        ArrayList<Car> cars = modelManager.getCarsList();
        for (Car car : cars) {
            carIDs.add(car.getVinNO());
        }
        return carIDs;
    }

    public void registerCarPart(ActionEvent actionEvent) {

        int id = Integer.parseInt(idTF.textProperty().getValue());
        String name = nameTF.textProperty().getValue();
        float weight = Float.parseFloat(weightTF.textProperty().getValue());
        String carId = carsIdCB.getValue().toString();

        Part part = new Part(weight, name, id);

        dismantleTheCarpart(carId, part);

    }

    public void goToDismantleView(ActionEvent actionEvent) throws IOException {
        loadView(backBtn, "../../view/dismantleCar.fxml");
    }

    public String getAllCarParts() {
        try {
            return ClientRmi.getInstance().getService().getAllParts().toString();//modelManager.getAllCars();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void dismantleTheCarpart(String vinNo, Part part) {
        Car carToBeDismantled = modelManager.getCar(vinNo);
        part.setCar(carToBeDismantled);
        modelManager.getCarPartsList().add(part);
        View.allert("Part= " + part.toString());
        modelManager.dismantleTheCar(carToBeDismantled);


//        Car carToBeDismantled = /*ModelManager.getInstance().getCar(vinNo);*/ null;
        /*try {
            carToBeDismantled = ClientRmi.getInstance().getService().getCar(vinNo);
            part.setCar(carToBeDismantled);
            ClientRmi.getInstance().getService().updatePart(part);
            View.allert("the part " + part.toString() + " has been taken from the car " + carToBeDismantled);
        } catch (RemoteException e) {
            View.allert("there is no such a car in the warehouse");
            e.printStackTrace();
        }*/

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

    public Part makePart(float weight, String name, int id) {
        return new Part(weight, name, id);
    }
    //getne si auto podla vinka
    //creatne part z auta a da ho na prislusnu paletu paletu
}