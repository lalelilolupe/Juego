/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itver.project.database;

/**
 *
 * @author PONKCHO
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


//Clase para crear la conexion con la base de datos
public class ConnectionDatabase {
    
    private static Connection connection;
    public static final String DRIVER = "jdbc:mysql://localhost/";
    public static final String NAME_DATABASE = "juegocraps";
    public static final String USER = "root";
    public static final String PASSWORD = "disidente";
    public static final String URL = DRIVER + NAME_DATABASE;
    
    //Este metodo es para crear la conexion con la base de datos
    public static Connection getConnection(){
        if(connection == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                //connection = DriverManager.getConnection(URL, USER, PASSWORD);
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/juegocraps", "root", "disidente");
            } catch (SQLException | ClassNotFoundException ex) {
                System.err.println("Error en la conexion con la base de datos "+ ex.getMessage());
            }
        }
        return connection;
    }
}
