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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class NetConnection {
    
    public Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    
    public NetConnection(Socket socket){
        this.socket = socket;
        initConnection();
    }
    
    private void initConnection(){
        try {
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(NetConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error en la inicializacion del protocolo");
        }
    }
    
    public boolean closeComunication(){
        try {
             output.close();
             input.close();
             socket.close();
             return true;
        } catch (IOException ex) {
            Logger.getLogger(NetConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro en el cierre de la comunicacion");
            return false;
        }    
    }
    
    public void sendPacket(PacketNet packet){
        try {
            output.writeObject(packet);
            output.flush();
        } catch (IOException ex) {
            Logger.getLogger(NetConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al enviar el mensaje");
        }
    }
    
    public PacketNet readPacket(){
        try {
            return (PacketNet) input.readObject();
        } catch (IOException ex) {
            return null;                
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NetConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al leer el mensaje, clase no encontrada");
        }
        return null;
    }
} 
