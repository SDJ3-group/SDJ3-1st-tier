package dk.via.Controller.ViewControllers;

import dk.via.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.ArrayList;

public class MainViewController extends ViewManager {

    public Button registerCarBtn;
    public Button dismantleCarBtn;
    public Button packPartsBtn;

    public ListView carsLV;
    public ListView carPartsLV;

    private ArrayList<Car> carArrayList = new ArrayList<>();
    private ArrayList<Part> carPartsArrayList = new ArrayList<>();

    @FXML
    public void initialize() {

        carArrayList = ModelManager.getInstance().getCarsList();
        carPartsArrayList = ModelManager.getInstance().getCarPartsList();

        if (!carArrayList.isEmpty()) {
            ObservableList<Car> data = FXCollections.observableArrayList(carArrayList);
            carsLV.setItems(data);
        }
        if (!carPartsArrayList.isEmpty()) {
            ObservableList<Part> data = FXCollections.observableArrayList(carPartsArrayList);
            carPartsLV.setItems(data);
        }

    }

    public void registerCar(ActionEvent actionEvent) throws IOException {
        loadView(registerCarBtn, "../../view/registerCar.fxml");
    }

    public void dismantleCar(ActionEvent actionEvent) throws IOException {
        loadView(dismantleCarBtn, "../../view/dismantleCar.fxml");
    }

    public void packParts(ActionEvent actionEvent) throws IOException {
        loadView(packPartsBtn, "../../view/packages.fxml");
    }
}
