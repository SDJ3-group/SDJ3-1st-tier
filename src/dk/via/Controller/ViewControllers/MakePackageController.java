package dk.via.Controller.ViewControllers;

import dk.via.model.ModelManager;
import dk.via.model.Part;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class MakePackageController extends ViewManager {

    public ComboBox productTypesCB;
    public TextField noOfObjectsTF;
    public Button createPackageBtn;
    public Button backBtn;

    private ArrayList<String> productTypesIDs = new ArrayList<>();

    private ModelManager modelManager;

    @FXML
    public void initialize() {
        ObservableList<String> productTypesList = FXCollections.observableArrayList(getProductTypes());
        productTypesCB.setItems(productTypesList);
    }

    public MakePackageController() {
        modelManager = ModelManager.getInstance();
    }

    private ArrayList<String> getProductTypes() {
        ArrayList<String> partNames = new ArrayList<>();
        ArrayList<Part> parts = modelManager.getCarPartsList();
        for (Part part : parts) {
            if (!(partNames.contains(part.getName()))) {
                partNames.add(part.getName());
            }
        }
        return partNames;
    }

    public void createPackage(ActionEvent actionEvent) {

        int noOfProducts = Integer.parseInt(noOfObjectsTF.textProperty().getValue());
        String productType = productTypesCB.getValue().toString();

//        not sure how ??

//        modelManager.makeAPackage(noOfProducts, );



    }

    public void goToDismantleView(ActionEvent actionEvent) throws IOException {
        loadView(backBtn, "../../view/packages.fxml");
    }

}