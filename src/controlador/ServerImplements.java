/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author bvegam
 */
public class ServerImplements extends UnicastRemoteObject implements RMI{

    public ServerImplements() throws RemoteException {
        super();
    }

    @Override
    public int sumar(int num1, int num2) throws RemoteException {
        return num1+num2;
    }
    
}
