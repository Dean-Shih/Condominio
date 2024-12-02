/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package condominio.view.Interface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

/**
 *
 * @author brasa
 */
public class Conector {
           
    
    final String url = "jdbc:mysql://localhost:3306/bd_condominio";
    final String user = "root";
    final String senha = "root";

    public void testarConexao() throws SQLException{
    
    Connection cx = DriverManager.getConnection(url,user,senha);
    System.out.println("Conectado");
    cx.close();
    
    }
    }
    

