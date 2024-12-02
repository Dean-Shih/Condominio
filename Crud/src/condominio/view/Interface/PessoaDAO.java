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
public class PessoaDAO {
    private static final String BD_URL = "jdbc:mysql://localhost:3306/bd_condominio"; 
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static boolean inserir(Pessoa pessoa) {
        final String INSERT_USUARIO = "insert into usuario (nome, senha, apartamento, cpf, telefone, tipo) VALUES (?, ?, ?, ?, ?, ?)"; 
        // conectar com o BD - desconectar no final
        // try with resources fecha automaticamente ao final toda conexão aberta
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try  {
             connection = DriverManager.getConnection(BD_URL, USER, PASSWORD);
             preparedStatement = 
             connection.prepareStatement(INSERT_USUARIO);
             
            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setString(2, pessoa.getSenha());
            preparedStatement.setString(3, pessoa.getApartamento());
            preparedStatement.setString(4, pessoa.getCpf());
            preparedStatement.setString(5, pessoa.getTelefone());
            preparedStatement.setBoolean(6, pessoa.isTipo());
          
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
    

        public static Pessoa buscarPorCPF(String cpf) {
        final String SELECT_USERS_SQL = "SELECT * FROM usuario WHERE cpf = ?;";

        // try with resource automaticamente fecha tudo que foi aberto
        try (
            Connection conn = DriverManager.getConnection(BD_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_USERS_SQL)) {
            preparedStatement.setString(1, cpf);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) { // testa se tem uma próxima linha na tabela
                cpf = rs.getString("cpf");
                String nome = rs.getString("nome");
                String senha = rs.getString("senha");
                String apartamento = rs.getString("apartamento");
                String telefone = rs.getString("telefone");
                Boolean tipo = rs.getBoolean("tipo");
                Pessoa pessoa = new Pessoa(nome,senha, apartamento, cpf, telefone, tipo);
                return pessoa;
            }
            return null; // não achou o RA
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
        public static int apagarPorCpf(String cpf) {
        final String SELECT_USERS_SQL = "DELETE FROM usuario WHERE cpf = ?;";

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
        public static int atualizarMorador(String cpf, String nome, String senha, String apartamento, String telefone) {
        final String SELECT_USERS_SQL = "UPDATE usuario SET nome = ?, senha = ?, apartamento = ?, telefone = ? WHERE cpf = ?;";

        try (Connection conn = DriverManager.getConnection(BD_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_USERS_SQL)) {
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, senha);
            preparedStatement.setString(3, apartamento);
            preparedStatement.setString(4, telefone);
            preparedStatement.setString(5, cpf);
            int registros = preparedStatement.executeUpdate();
            return registros;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
             }
            }



















