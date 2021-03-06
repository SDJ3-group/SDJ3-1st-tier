package dk.via.Controller.RMI;

import dk.via.model.Pallet;

import java.rmi.RemoteException;

public interface PalletsRMIInterface {
    Pallet[] getAllPallets() throws RemoteException;

    Pallet getPallet(int id) throws RemoteException;

    void updatePallet(Pallet pallet) throws RemoteException;

    void addPallet(Pallet pallet) throws RemoteException;

    void deletePallet(Pallet pallet) throws RemoteException;
}
