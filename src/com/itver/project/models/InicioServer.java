/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itver.project.models;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PONKCHO
 */

import com.itver.project.database.ConnectionDatabase;
import com.itver.project.database.MysqlUserDAO;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InicioServer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int port=9090;
//        System.out.println("PUERTO DE SERVIDOR: ");
//        port = input.nextInt();
        try {
            MysqlUserDAO manager = new MysqlUserDAO(ConnectionDatabase.getConnection());
            LogicServer logicServer = new LogicServer(manager);
            Server server = new Server(port, logicServer);
        } catch (IOException ex) {
            Logger.getLogger(InicioServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
