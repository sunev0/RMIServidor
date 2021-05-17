/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiservidor;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Nicole
 */
public class Mensajes implements Serializable { //Para que un programa java pueda convertir un objeto en un montón de bytes y pueda luego recuperarlo debe ser serializable
    
    private String NomUsuario;
    private String Mensj;
    private String tipo;
    private Date Fecha;

  public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNomUsuario() {
        return NomUsuario;
    }

    public void setNomUsuario(String nomusuario) {
        this.NomUsuario = nomusuario;
    }

    public String getMensaje() {
        return Mensj;
    }

    public void setMensaje(String mensj) {
        this.Mensj = mensj;
    }
    
}
