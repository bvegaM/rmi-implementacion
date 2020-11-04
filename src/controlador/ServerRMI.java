/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bvegam
 */
public class ServerRMI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Registry myRegistry = LocateRegistry.createRegistry(1234);
            myRegistry.bind("rmiExample", new ServerImplements());
            System.err.println("Server ON!");
        } catch (RemoteException ex) {
            Logger.getLogger(ServerRMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(ServerRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
