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
    
    private String nomUsu;
    private String mens;
    private String tipo;
    private Date fecha;

  public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUsuarios() {
        return nomUsu;
    }

    public void setUsuarios(String nomusuario) {
        this.nomUsu = nomusuario;
    }

    public String getMens() {
        return mens;
    }

    public void setMens(String mensj) {
        this.mens = mensj;
    }
    
}
