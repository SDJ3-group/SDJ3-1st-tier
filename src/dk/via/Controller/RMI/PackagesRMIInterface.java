package dk.via.Controller.RMI;


import java.rmi.RemoteException;

public interface PackagesRMIInterface {

    Package[] getAllPackages() throws RemoteException;

    Package getPackage(int id) throws RemoteException;

    void updatePackage(Package pack) throws RemoteException;

    void addPackage(Package pack) throws RemoteException;

    void deletePackage(Package pack) throws RemoteException;
}
