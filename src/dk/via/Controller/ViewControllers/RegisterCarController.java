package dk.via.Controller.ViewControllers;

import dk.via.Controller.RMI.ClientRmi;
import dk.via.model.*;
import dk.via.view.View;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.rmi.RemoteException;

public class RegisterCarController extends ViewManager {

    public TextField vinNoTF;
    public TextField modelTF;
    public TextField weightTF;
    public Button registerBtn;
    public Button backBtn;

    private ModelManager modelManager;

    public RegisterCarController() {
        modelManager = ModelManager.getInstance();
    }

    public void registerCar(ActionEvent actionEvent) {

        String vinNo = vinNoTF.textProperty().getValue();
        String model = modelTF.textProperty().getValue();
        float weight = Float.parseFloat(weightTF.textProperty().getValue());

        registerCar(vinNo,model,weight);

    }

    public void goToMainView(ActionEvent actionEvent) throws IOException {
        loadView(backBtn, "../../view/mainView.fxml");
    }

    public void registerCar(String licensePlate, String model, float weight){
        Car incomingCar = new Car(licensePlate,model,weight);
        //modelManager.registerNewCar(incomingCar);
        try {
            ClientRmi.getInstance().getService().addCar(incomingCar);
            View.allert("The car " + incomingCar.toString() + " has been added");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public String getAllCars()
    {
        try {
            return ClientRmi.getInstance().getService().getAllCars().toString();//modelManager.getAllCars();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }
}