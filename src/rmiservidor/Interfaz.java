/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiservidor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Nicole
 */
public interface Interfaz extends Remote{
    public boolean iniciarses(String nomUsu) throws RemoteException;
    public void cerrarses(String nomUsu) throws RemoteException;
    public void enviarmens(Mensajes mensaje) throws RemoteException;
    public List<Mensajes> getTodosMens() throws RemoteException;
    public List<String> getTodosUsu() throws RemoteException;
}
