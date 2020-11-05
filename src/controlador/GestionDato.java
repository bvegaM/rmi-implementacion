/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bvegam
 */
public class GestionDato {

    private RMI remoteInterface;
    public GestionDato(String ipServer,int puerto) {
        try {
            Registry myRegister = LocateRegistry.getRegistry("127.0.0.1",1234);
            this.remoteInterface = (RMI) myRegister.lookup("rmiExample");
        } catch (RemoteException ex) {
            Logger.getLogger(GestionDato.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(GestionDato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String obtenerEpisodio(int id) throws RemoteException{
        return this.remoteInterface.obtenerEpisodio(id);
    }
}
