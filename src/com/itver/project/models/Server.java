/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itver.project.models;

/**
 *
 * @author PONKCHO
 */
import com.itver.project.resources.NetConnection;
import com.itver.project.resources.PacketNet;
import com.itver.project.resources.Protocol;
import com.itver.project.database.ConnectionDatabase;
import com.itver.project.models.LogicServer;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Random;

public class Server extends ServerSocket {

    protected int port;
    private LogicServer logic;
    
    public Server(int port, LogicServer logic) throws IOException{
        super(port);
        this.logic = logic;
        onStart();
    }
    
    private void onStart(){
        port = this.getLocalPort();
        System.out.println("Iniciando Servidor...");
        System.out.println("Servidor Iniciado Correctamente");
        System.out.println("Numero de puerto: " + port);
        setListenerForClients();
    }
    
    public void setListenerForClients(){
        try {
            while (true) {
                System.out.println("Esperando clientes...");
                Socket socket = accept();
                System.out.println("Nuevo cliente conectado");
                setComunication(socket);
            }
        } catch (IOException e) {
            System.err.println("Error en el listener " + e.getMessage());
        }
    }
    
    public void setComunication(Socket socket){
        NetConnection connection = new NetConnection(socket); //objeto para la comunicacion por red
        PacketNet paquete = connection.readPacket(); // paquete recibio por el cliente
        PacketNet paquete_respuesta = new PacketNet(); //Paquete de respuesta al cliente
        System.out.println("Leyendo datos..."); 
        Protocol p1 = paquete.getTipo_mensaje();    //Tipo de mensaje del cliente
        Protocol p2 = null;                            // Tipo de mensaje de respuesta
        switch (p1) {                       //Actuar de acuerdo al tipo de mensaje
            case LOGGIN:
                p2 = logic.verifyUserOnDatabase(paquete, connection)?Protocol.REQUEST_ACEPTED:Protocol.REQUEST_FAILED;
                paquete_respuesta.setTipo_mensaje(p2);
                break;
            case REGISTER:
                p2 = logic.registerUserOnDatabase(paquete, connection)?Protocol.REQUEST_ACEPTED:Protocol.REQUEST_FAILED;
                paquete_respuesta.setTipo_mensaje(p2);
                break;
            case PLAY:
                break;
            case TIRO:
                // Cambios Aqui
                System.out.println("TIROss ");
                int dado;
                Random girar= new Random();
                dado= girar.nextInt(6)+1;
                p2 = logic.registerUserOnDatabase(paquete, connection)?Protocol.REQUEST_ACEPTED:Protocol.REQUEST_FAILED;
                paquete_respuesta.setTipo_mensaje(p2);
                paquete.setTiro(dado);
                System.out.println("TIRO " + dado);
                break;
            default:
                System.err.println("Error en el tipo de mensaje");
        }
        connection.sendPacket(paquete_respuesta);
    }

}
