package br.edu.utfpr.cm.pi.beans;

import br.edu.utfpr.cm.pi.daos.FuncionarioDao;

public class teste {

    public static void main(String[] args) {
        
        FuncionarioDao fdao = new FuncionarioDao();
        
        Funcionario funcionario = fdao.getLogin("boss", "123456");
        

   if(funcionario!=null) {
       System.out.println(funcionario.getNome());
   } else {
       System.out.println("Login invalido");
   }
    
        
     
    }
}