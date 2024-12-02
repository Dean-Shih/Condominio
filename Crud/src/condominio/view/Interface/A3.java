/*
 
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
*/
package condominio.view.Interface;

import condominio.view.Interface.Telalogin;
import condominio.view.Interface.Telalogin;


public class A3{
  public static void main(String[] args) {

        //Abrir tela de login
        Telalogin login = new Telalogin();
        login.setVisible(true);
   
        //Realizar a conexão com o BD
        Conector c = new Conector();
        try {
        c.testarConexao();
        }catch (Exception ex){
            System.out.println(ex.getClass());
        }






    }

}
