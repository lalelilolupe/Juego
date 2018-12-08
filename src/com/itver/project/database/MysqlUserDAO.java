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
import com.itver.project.resources.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//CLASE PARA HACER LAS CONEXIONES CON LAS BASE DE DATOS
public class MysqlUserDAO implements UserDAO {

    private Connection connection;
    final String INSERT = "insert into usuarios(usuario, nombre, apellidos, password, correo)"
            + " values(?, ?, ?, ? , ?)";
    final String UPDATE = "update usuarios SET usuario = ?, nombre = ?, apellidos = ?, password = ?, correo = ?";
    final String DELETE = "delete from usuarios where id_usuario = ?";
    final String GET_ALL = "select * from usuarios";
    final String GET = "select * from usuarios where usuario = ? and password =  ?";

    public MysqlUserDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean insert(User u) {
        try (PreparedStatement ps = connection.prepareStatement(INSERT)) {
            ps.setString(1, u.getUsuario());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getApellidos());
            ps.setString(4, u.getPassword());
            ps.setString(5, u.getCorreo());
            if (ps.executeUpdate() != 0) {
                System.out.println("Usuario " + u.getUsuario() + " registrado correctamente");
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error en la conexion al insertar " + e.getMessage());
        }
        return false;
    }

    @Override
    public void update(User u) {

    }

    @Override
    public void delete(User u) {
        try (PreparedStatement ps = connection.prepareStatement(DELETE)){
            ps.setLong(1, u.getID());
            if(ps.executeUpdate() != 0){
                System.out.println("Usuario eliminado: " + u.getUsuario());
            }
        } catch (Exception e) {
            System.err.println("Error en la conexion al eliminar " + e.getMessage());
        }
    }

    @Override
    public User get(String user, String password) {
        try (PreparedStatement ps = connection.prepareStatement(GET)) {
            System.out.println("usuario: " + user);
            System.out.println("password: " + password);
            ps.setString(1, user);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return convertToUser(rs);
                }else{
                    System.err.println("Usuario no encontrado: " + user);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Error al cargar los datos ");
            }
        } catch (Exception e) {
            System.err.println("Error al hacer el preparedStatement ");
        }
        return null;
    }

    @Override
    public List<User> getAll() {
         List<User> users = new ArrayList<>();
        try(PreparedStatement ps = connection.prepareStatement(GET_ALL)){
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    users.add(convertToUser(rs));
                }
            } catch (Exception e) {
                System.err.println("Error en el resultser");
            }
        } catch (Exception e) {
            System.err.println("Error en el prepared statement");
        }
        return users;
    }

    private User convertToUser(ResultSet rs) {

        try {
            String usuario = rs.getString("usuario");
            String nombre = rs.getString("nombre");
            String apellidos = rs.getString("apellidos");
            String password = rs.getString("password");
            String correo = rs.getString("correo");

            User user = new User(nombre, apellidos, usuario, correo, password);
            //user.setID(rs.getLong("id_usuario"));
            return user;
        } catch (Exception e) {
            System.err.println("Error al convertir el alumno al modelo");
        }

        return null;
    }
}
