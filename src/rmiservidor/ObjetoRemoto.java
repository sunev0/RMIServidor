/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiservidor;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nicole
 */
public class ObjetoRemoto extends UnicastRemoteObject implements Interfaz, Serializable {

    List<String> usuarios = new ArrayList<>();
    List<Mensajes> mensajes = new ArrayList<>();

    public ObjetoRemoto() throws RemoteException {
        super(); //Activa el código en UnicastRemoteObject que realiza la vinculación RMI y la inicialización remota del objeto

    }

    @Override
    public boolean iniciarses(String nomUsu) throws RemoteException {
        boolean conectado = false;
        for (String usuario : usuarios) {
            if (nomUsu.equals(usuario)) {
                conectado = true;
                break;
            } else {
                conectado = false;
            }
        }
        if (conectado == false) {
            usuarios.add(nomUsu);
            Mensajes mensaje = new Mensajes();
            mensaje.setNomUsu(nomUsu);
            mensaje.setMensaje(" entró al chat ");
            mensaje.setTipo("entró");
            mensaje.setFecha(new Date());
            this.mensajes.add(mensaje);

            return true;
        } else {
            return false;
        }
    }

    @Override
    public void cerrarses(String nomUsu) throws RemoteException {
        usuarios.remove(nomUsu);
        Mensajes mensaje = new Mensajes();
        mensaje.setNomUsu(nomUsu);
        mensaje.setMensaje(" dejó el chat ");
        mensaje.setTipo("dejó");
        mensaje.setFecha(new Date());
        this.mensajes.add(mensaje);
    }

    @Override
    public void enviarmens(Mensajes mensaje) throws RemoteException {
        this.mensajes.add(mensaje);
    }

   @Override
    public List<Mensajes> getTodosMens() throws RemoteException {
        for (Mensajes m : mensajes) {
            System.out.println(m.getNomUsu() + " " + m.getMensaje());
        }
        return mensajes;
    }

    @Override
    public List<String> getTodosUsu() throws RemoteException {
        for (String u : usuarios) {
            System.out.println(u);
        }
        return usuarios;
    }

}
