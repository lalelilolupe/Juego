/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itver.project.resources;

/**
 *
 * @author PONKCHO
 */
import java.io.Serializable;

public class User implements Serializable{
    
    private Long id;
    private String nombre;
    private String apellidos;
    private String usuario;
    private String correo;
    private String password;

    public User() {
    }

    public User(Long id, String nombre, String apellidos, String usuario, String correo, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.correo = correo;
        this.password = password;
    }

    
    public User(String nombre, String apellidos, String usuario, String correo, String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.correo = correo;
        this.password = password;
    }

    public void setID(Long id){
        this.id = id;
    }
    
    public Long getID(){
        return id;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", usuario=" + usuario + ", correo=" + correo + ", password=" + password + '}';
    }
    
}
