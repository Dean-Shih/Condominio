/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package condominio.view.Interface;

/**
 *
 * @author brasa
 */
public class Ocorrencia {
 
 String descricao;
 String valor ;
 String data_ocorrencia;
 String cpf;
 String data_vencimento; 
 String data_pagamento;
 String situacao;    

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
public Ocorrencia(){

}    
    
 public Ocorrencia(String descricao, String valor, String data_ocorrencia, String cpf, String data_vencimento,String data_pagamento, String situacao) {
 
 this.descricao = descricao;
 this.valor = valor; 
 this.data_ocorrencia = data_ocorrencia;
 this.cpf = cpf;
 this.data_vencimento = data_vencimento;
 this.data_pagamento = data_pagamento;
 this.situacao = situacao;
 }   

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getData_ocorrencia() {
        return data_ocorrencia;
    }

    public void setData_ocorrencia(String data_ocorrencia) {
        this.data_ocorrencia = data_ocorrencia;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(String data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public String getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(String data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    
    
    
    
    
    
    
    
    
}
