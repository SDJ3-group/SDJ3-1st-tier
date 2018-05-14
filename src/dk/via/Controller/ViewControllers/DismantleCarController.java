package dk.via.Controller.ViewControllers;

import dk.via.model.ModelManager;
import dk.via.model.Part;
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
    public ListView carPartsLV;

    private ArrayList<Part> carPartsArrayList = new ArrayList<>();

    @FXML
    public void initialize() {

        carPartsArrayList = ModelManager.getInstance().getCarPartsList();


        if (!carPartsArrayList.isEmpty()) {
            ObservableList<Part> data = FXCollections.observableArrayList(carPartsArrayList);
            System.out.println(data);
//            carPartsLV.setItems(data);
//            toto zatial nefunguje a nevidim si chybu.. v main view je to ok
        }

    }

    public void regCarPart(ActionEvent actionEvent) throws IOException {
        loadView(regCarPartBtn, "../../view/registerCarPart.fxml");
    }

    public void addPallet(ActionEvent actionEvent) throws IOException {
        loadView(addPalletBtn, "../../view/registerCar.fxml");
    }

    public void goToMainView(ActionEvent actionEvent) throws IOException {
        loadView(backBtn, "../../view/mainView.fxml");
    }
}
