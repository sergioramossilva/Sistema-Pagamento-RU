package br.edu.utfpr.cm.pi.ldap;

import br.edu.utfpr.cm.pi.beans.UsuarioSistema;

public class TesteLdap {

    public static void main(String[] args) {
        LoginLDAP ll = new LoginLDAP();
        UsuarioSistema u = ll.logarNoLDAP("aRA", "senha");
        System.out.println("nosso usuário: " + u.getNome() + " " + u.getSaldo());
        
         

    }

}
