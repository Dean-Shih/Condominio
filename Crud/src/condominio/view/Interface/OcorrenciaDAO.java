/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package condominio.view.Interface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author brasa
 */
public class OcorrenciaDAO {

private static final String BD_URL = "jdbc:mysql://localhost:3306/bd_condominio"; 
private static final String USER = "root";
private static final String PASSWORD = "root";

        public static boolean inserir(Ocorrencia ocorrencia) {
        final String INSERT_MULTA = "insert into multa  (descricao, valor, data_ocorrencia, cpf, data_vencimento, data_pagamento, situacao) VALUES (?, ?, ?, ?, ?, ?, ?)"; 
        // conectar com o BD - desconectar no final
        // try with resources fecha automaticamente ao final toda conexão aberta
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try  {
             connection = DriverManager.getConnection(BD_URL, USER, PASSWORD);
             preparedStatement = 
             connection.prepareStatement(INSERT_MULTA);
             
            preparedStatement.setString(1, ocorrencia.getDescricao());
            preparedStatement.setString(2, ocorrencia.getValor());
            preparedStatement.setString(3, ocorrencia.getData_ocorrencia());
            preparedStatement.setString(4, ocorrencia.getCpf());
            preparedStatement.setString(5, ocorrencia.getData_vencimento());
            preparedStatement.setString(6, ocorrencia.getData_pagamento());
            preparedStatement.setString(7, ocorrencia.getSituacao());      
          
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
                
            }

        }
    }    
        public static Ocorrencia buscarPorCPF(String cpf) {
        final String SELECT_MULTA_SQL = "SELECT * FROM multa WHERE cpf = ?;";

        // try with resource automaticamente fecha tudo que foi aberto
        try (
            Connection conn = DriverManager.getConnection(BD_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_MULTA_SQL)) {
            preparedStatement.setString(1, cpf);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) { // testa se tem uma próxima linha na tabela
 
                cpf = rs.getString("cpf");
                String descricao = rs.getString("descricao");
                String valor = rs.getString("valor");
                String data_ocorrencia = rs.getString("data_ocorrencia");
                String data_vencimento = rs.getString("data_vencimento");
                String data_pagamento = rs.getString("data_pagamento");
                String situacao = rs.getString("situacao");
                
                Ocorrencia ocorrencia = new Ocorrencia(descricao, valor, data_ocorrencia, cpf, data_vencimento, data_pagamento, situacao);
                return ocorrencia;
            }
            
            return null; 
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        }
    
        public static int apagarPorCpf(String cpf) {
        final String SELECT_USERS_SQL = "DELETE FROM multa WHERE cpf = ?;";

        try (Connection conn = DriverManager.getConnection(BD_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_USERS_SQL)) {
            preparedStatement.setString(1, cpf);
            int registros = preparedStatement.executeUpdate();
            return registros;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        }
        
        public static int atualizarMorador(String descricao, String valor, String data_ocorrencia, String cpf, String data_vencimento,String data_pagamento, String situacao) {
        final String SELECT_USERS_SQL = "UPDATE multa SET descricao = ?, valor = ?, data_ocorrencia = ?, data_vencimento = ?, data_pagamento = ?, situacao = ? WHERE cpf = ?;";

        try (Connection conn = DriverManager.getConnection(BD_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_USERS_SQL)) {
            preparedStatement.setString(1, descricao);
            preparedStatement.setString(2, valor);
            preparedStatement.setString(3, data_ocorrencia);
            preparedStatement.setString(4, data_vencimento);
            preparedStatement.setString(5, data_pagamento);
            preparedStatement.setString(6, situacao);
            preparedStatement.setString(7, cpf);

            int registros = preparedStatement.executeUpdate();
            return registros;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        
        
        
        
        
        
        
        
        
        
        
        }
    }


