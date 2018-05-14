package dk.via.Controller.ViewControllers;

import dk.via.model.ModelManager;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddPalletController extends ViewManager {

    public TextField idTF;
    public TextField capacityTF;
    public Button registerBtn;
    public Button backBtn;

    private ModelManager modelManager;

    public AddPalletController() {
        modelManager = ModelManager.getInstance();
    }

    public void registerCarPart(ActionEvent actionEvent) {
    }

    public void goToDismantleView(ActionEvent actionEvent) throws IOException {
        loadView(backBtn, "../../view/dismantleCar.fxml");
    }
}
