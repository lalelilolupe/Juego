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
import com.itver.project.resources.User;
import com.itver.project.database.MysqlUserDAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogicServer {

    private MysqlUserDAO manager;
    private ArrayList<User> users_list;

    public LogicServer(MysqlUserDAO manager) {
        this.manager = manager;
        users_list = new ArrayList<>();
    }

    //Metodo para verificar si el usuario esta en la base de datos y autenticarse
    public boolean verifyUserOnDatabase(PacketNet packet, NetConnection connection) {
        User current_user = packet.getUsuario(); //usuario enviado por el cliente
        String usuario = current_user.getUsuario(); //extraccion del usuario 
        String password = current_user.getPassword(); //extraccion de la contraseña
        User userFromDB = manager.get(usuario, password);//Verificar si en la base de datos existe
        if (userFromDB != null) {
            //iniciar la sesion del jugador
            users_list.add(userFromDB);
            Session session = new Session(userFromDB, connection);
            session.start();
            return true;
        }
        return false;
    }

    //Metodo para registrar un nuevo usuario en la base de datos
    public boolean registerUserOnDatabase(PacketNet packet, NetConnection connection) {
        User new_user = packet.getUsuario(); //Usuario enviado por el cliente
        if (manager.insert(new_user)) { //insercion en la base de datos del nuevo usuario
            //iniciar sesion del jugador
            users_list.add(new_user);
            Session session = new Session(new_user, connection);
            session.start();
            return true;
        }

        return false;
    }

    //Clase que acturara de hilo para las sesiones de los juegadores(clientes)
    public class Session extends Thread {

        private final User usuario;
        private final NetConnection individual_connection;
        private PacketNet paquete;

        public Session(User user, NetConnection connection) {
            this.usuario = user;
            this.individual_connection = connection;
            this.paquete = new PacketNet();
        }

        @Override
        public void run() {
            System.out.println("Sesion iniciada para el jugador : " + usuario.getUsuario());
            while (!individual_connection.socket.isClosed()) {
                PacketNet received_packet = individual_connection.readPacket();
                if (received_packet != null) {
                    if (received_packet.getTipo_mensaje().equals(Protocol.PLAY)) {
                        System.out.println("usuario " + usuario.getUsuario() + " listo para jugar");
                        paquete.setTipo_mensaje(Protocol.REQUEST_ACEPTED);
                        paquete.setMensaje("Juega!");
                        individual_connection.sendPacket(paquete);
                    }
                } else {
                    individual_connection.closeComunication();
                    System.out.println("Sesion terminada del usuario: " + usuario.getUsuario());
                }

            }

        }

    }

}
