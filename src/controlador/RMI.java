/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author bvegam
 */
public interface RMI extends Remote{
    public String obtenerEpisodio(int id) throws RemoteException;
    
}
