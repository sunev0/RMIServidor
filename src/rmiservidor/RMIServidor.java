/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiservidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Nicole
 */
public class RMIServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Registry registro = LocateRegistry.createRegistry(6303);
            System.out.println("Instancia de registro local creada en el puerto 6303");

            registro.rebind("chatServer", new ObjetoRemoto()); //Se crea el objeto remoto
            System.out.println("El servidor se ha iniciado");
            
        } catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
}
