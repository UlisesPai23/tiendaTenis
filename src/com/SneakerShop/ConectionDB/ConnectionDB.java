/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.SneakerShop.ConectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author PC WHITE WOLF
 */
public class ConnectionDB {
    Connection conectar;

    String usuario = "root";
    String contrasena = "Guaymas";
    String db = "SneakerShop";
    String ip = "localhost";
    String puerto = "3306";

    String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + db + "?useSSL=false&serverTimezone=UTC";

    public Connection establishConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, contrasena);
           // JOptionPane.showMessageDialog(null, "Conexión exitosa");
            return conectar;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas con la conexión: " + e.getMessage());
            return null;
        }
    }
}
    
