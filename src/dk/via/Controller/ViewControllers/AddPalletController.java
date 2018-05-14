package dk.via.Controller.ViewControllers;

import dk.via.model.ModelManager;
import dk.via.model.Pallet;
import dk.via.view.View;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddPalletController extends ViewManager {

    public TextField idTF;
    public TextField capacityTF;
    public Button addBtn;
    public Button backBtn;

    private ModelManager modelManager;

    public AddPalletController() {
        modelManager = ModelManager.getInstance();
    }

    public void addPallet(ActionEvent actionEvent) {
        Pallet pallet = null;
        int id = Integer.parseInt(idTF.textProperty().getValue());
        if (capacityTF.textProperty().getValue() != null) {
            float capacity = Float.parseFloat(capacityTF.textProperty().getValue());
            pallet = new Pallet(id, capacity);
        } else {
            pallet = new Pallet(id);
        }
        View.allert("Pallet= " + pallet.toString());
        modelManager.getPalletsList().add(pallet);

    }

    public void goToDismantleView(ActionEvent actionEvent) throws IOException {
        loadView(backBtn, "../../view/dismantleCar.fxml");
    }
}
