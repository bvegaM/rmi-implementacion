/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.GestionDato;
import controlador.RMI;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author bvegam
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String numeroUno = JOptionPane.showInputDialog("Ingrese el número uno");
        String numeroDos = JOptionPane.showInputDialog("Ingrese el numero dos");
        int num1 = Integer.parseInt(numeroUno);
        int num2 = Integer.parseInt(numeroDos);
        GestionDato gestion = new GestionDato("127.0.0.1",1234);
        try {
            System.out.println(gestion.sumar(num1, num2));
        } catch (RemoteException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
