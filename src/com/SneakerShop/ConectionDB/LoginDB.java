/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.SneakerShop.ConectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import com.SneakerShop.loggin.FromMenu;

/**
 *
 * @author PC WHITE WOLF
 */
public class LoginDB {

    
    public void validaUsuario(JTextField usuario, JPasswordField contrasenia){
        try {
            com.SneakerShop.loggin.FromMenu FromMenu = new com.SneakerShop.loggin.FromMenu();
            
            ResultSet rs= null;
            PreparedStatement ps = null;
            
            com.SneakerShop.ConectionDB.ConnectionDB objetoConexion = new com.SneakerShop.ConectionDB.ConnectionDB();
            Connection con = objetoConexion.establishConnection();
             
            String consulta = "SELECT * FROM Usuarios WHERE nombre = ? AND contraseña = ?";
            ps = con.prepareStatement(consulta);
            
            ps.setString(1, usuario.getText());
            ps.setString(2, String.valueOf(contrasenia.getPassword()));
            
            rs = ps.executeQuery();
             
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
                FromMenu.setVisible(true);
                // Aquí puedes redirigir a otra ventana
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
            } 

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al validar el usuario: " + e.getMessage());
        }
    }
    
    
}
