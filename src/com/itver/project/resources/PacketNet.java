/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itver.project.resources;

import java.io.Serializable;

/**
 *
 * @author PONKCHO
 */
public class PacketNet implements Serializable{
    
    private User usuario;
    private Protocol tipo_mensaje;
    private String mensaje;
    private int tiro;
    
    public PacketNet(){
        
    }
    
    public PacketNet(User usuario, Protocol tipo_mensaje){
        this.usuario = usuario;
        this.tipo_mensaje = tipo_mensaje;
    }
    
    public PacketNet(String mensaje, Protocol tipo_mensaje){
        this.mensaje = mensaje;
        this.tipo_mensaje = tipo_mensaje;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public Protocol getTipo_mensaje() {
        return tipo_mensaje;
    }

    public void setTipo_mensaje(Protocol tipo_mensaje) {
        this.tipo_mensaje = tipo_mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public void setTiro(int tiro) {
        this.tiro = tiro;
    }
    
    public int getTiro() {
        return this.tiro;
    }
}
