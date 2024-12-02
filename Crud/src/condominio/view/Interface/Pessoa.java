
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package condominio.view.Interface;

/**
 *
 * @author brasa
 */
public class Pessoa {
 
 String nome;
 String senha;
 String apartamento;
 String cpf;
 String telefone; 
 boolean tipo;
 
 public Pessoa(){
 
 }

 public Pessoa(String nome, String senha, String apartamento, String cpf, String telefone, boolean tipo) {
 
 this.nome = nome;
 this.senha = senha; 
 this.apartamento = apartamento;
 this.cpf = cpf;
 this.telefone = telefone;
 this.tipo = tipo;
 }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
}
