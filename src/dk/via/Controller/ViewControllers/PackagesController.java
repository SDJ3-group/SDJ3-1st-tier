package dk.via.Controller.ViewControllers;

import dk.via.model.ModelManager;
import dk.via.model.Package;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.util.ArrayList;

public class PackagesController extends ViewManager {

    public Button makePckgBtn;
    public Button backBtn;
    public ListView packagesLV;

    private ArrayList<Package> packagesArrayList = new ArrayList<>();

    private ModelManager modelManager;

    public PackagesController() {
        modelManager = ModelManager.getInstance();
    }

    @FXML
    public void initialize() {

        packagesArrayList = modelManager.getPackagesList();

        if (!packagesArrayList.isEmpty()) {
            ObservableList<Package> data = FXCollections.observableArrayList(packagesArrayList);
            packagesLV.setItems(data);
        }

    }

    public void makePackage(ActionEvent actionEvent) throws IOException {
        loadView(backBtn, "../../view/makePackage.fxml");

    }

    public void goToMainView(ActionEvent actionEvent) throws IOException {
        loadView(backBtn, "../../view/mainView.fxml");
    }
}
