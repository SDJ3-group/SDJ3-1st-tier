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
        part.setCar(modelManager.getCar(carId));

        View.allert("The car part has been added");

//        registerCar(vinNo,model,weight);

    }

    public void goToDismantleView(ActionEvent actionEvent) throws IOException {
        loadView(backBtn, "../../view/dismantleCar.fxml");
    }

    public String getAllCarParts()
    {
        try {
            return ClientRmi.getInstance().getService().getAllParts().toString();//modelManager.getAllCars();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }
}