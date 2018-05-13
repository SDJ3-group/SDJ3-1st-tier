package com.company.controller.Rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
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
            rmiService = (RMIInterface) Naming.lookup(ipAddress + ":" + port);
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    public RMIInterface getService() {
        return rmiService;
    }
}
