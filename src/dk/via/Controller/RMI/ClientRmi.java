package dk.via.Controller.RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ClientRmi extends UnicastRemoteObject {
    private static ClientRmi instance = null;
    private RMIInterface rmiService;

    private ClientRmi() throws RemoteException {
    }

    public static ClientRmi getInstance() {
        if (instance == null) {
            try {
                instance = new ClientRmi();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public void startClient(String ipAddress, int port) {
        try {
            System.setProperty("java.rmi.server.hostname","//localhost/RmiService");
            Registry registry = LocateRegistry.getRegistry();

            rmiService = (RMIInterface) registry.lookup("//localhost/RmiService");

          //  rmiService = (RMIInterface) Naming.lookup(ipAddress + ":" + port);
        } catch (NotBoundException e) {
            e.printStackTrace();
        }  catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    public RMIInterface getService() {
        return rmiService;
    }
}
