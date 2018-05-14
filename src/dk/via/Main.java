package dk.via;

import dk.via.Controller.RMI.ClientRmi;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/mainView.fxml"));
        primaryStage.setTitle("Car Dismantling Company");
        primaryStage.setScene(new Scene(root, 1200, 800));
        primaryStage.show();
    }

    public static void main(String[] args) {


        ClientRmi clientRmi = ClientRmi.getInstance();
        clientRmi.startClient("//8.8.8.8/", 1099);
        /*
        ModelManager.getInstance().populate();
        View view = new View();
        Scanner keyboard = new Scanner(System.in);
        view.DisplayMenu();
        view.setView(keyboard.nextInt());

        */
        launch(args);
    }
}
