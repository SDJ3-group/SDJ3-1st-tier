package dk.via;

import dk.via.Controller.RMI.ClientRmi;

public class Main {

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
    }
}
