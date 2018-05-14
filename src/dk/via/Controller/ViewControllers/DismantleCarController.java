package dk.via.Controller.ViewControllers;

import dk.via.model.ModelManager;
import dk.via.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.util.ArrayList;

public class DismantleCarController extends ViewManager {

    public Button regCarPartBtn;
    public Button addPalletBtn;
    public Button backBtn;
    public ListView carpartsLV;
    public ListView palletsLV;

    private ArrayList<Part> carPartsArrayList = new ArrayList<>();
    private ArrayList<Pallet> palletsArrayList = new ArrayList<>();

    @FXML
    public void initialize() {

        carPartsArrayList = ModelManager.getInstance().getCarPartsList();
        palletsArrayList = ModelManager.getInstance().getPalletsList();

        if (!carPartsArrayList.isEmpty()) {
            ObservableList<Part> data = FXCollections.observableArrayList(carPartsArrayList);
            carpartsLV.setItems(data);
        }

        if (!palletsArrayList.isEmpty()) {
            ObservableList<Pallet> data = FXCollections.observableArrayList(palletsArrayList);
            palletsLV.setItems(data);
        }

    }

    public void regCarPart(ActionEvent actionEvent) throws IOException {
        loadView(regCarPartBtn, "../../view/registerCarPart.fxml");
    }

    public void addPallet(ActionEvent actionEvent) throws IOException {
        loadView(addPalletBtn, "../../view/addPallet.fxml");
    }

    public void goToMainView(ActionEvent actionEvent) throws IOException {
        loadView(backBtn, "../../view/mainView.fxml");
    }
}
