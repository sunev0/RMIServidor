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
    List<Mensajes> mensaje = new ArrayList<>();

    public ObjetoRemoto() throws RemoteException {
        super(); //Activa el código en UnicastRemoteObject que realiza la vinculación RMI y la inicialización remota del objeto

    }

    //@Override
    public boolean login(String nomusuario) throws RemoteException {
        boolean conectado = false;
        for (String usuario : usuarios) {
            if (usuarios.equals(usuario)) {
                conectado = true;
                break;
            } else {
                conectado = false;
            }
        }
        if (conectado == false) {
            usuarios.add(nomusuario);
            Mensajes mensajes = new Mensajes();
            mensajes.setUsuarios(nomusuario);
            mensajes.setMens(" entró al chat ");
            mensajes.setTipo("entró");
            mensajes.setFecha(new Date());
            mensaje.add(mensajes);

            return true;
        } else {
            return false;
        }
    }

   // @Override
    public void logout(String nomusuario) throws RemoteException {
        usuarios.remove(nomusuario);
        Mensajes mensajes = new Mensajes();
        mensajes.setUsuarios(nomusuario);
        mensajes.setMens(" dejó el chat ");
        mensajes.setTipo("dejó");
        mensajes.setFecha(new Date());
        mensaje.add(mensajes);
    }

    //@Override
    public void MandarMensaje(Mensajes mensajes) throws RemoteException {
        mensaje.add(mensajes);
    }

   // @Override
    public List<Mensajes> ObtenerMensajes() throws RemoteException {
        for (Mensajes m : mensaje) {
            System.out.println(m.getUsuarios() + " " + m.getMens());
        }
        return mensaje;
    }

   // @Override
    public List<String> ObtenerUsuarios() throws RemoteException {
        for (String u : usuarios) {
            System.out.println(u);
        }
        return usuarios;
    }

}
