package br.edu.utfpr.cm.pi.ldap;

import br.edu.utfpr.cm.pi.beans.UsuarioSistema;

public class TesteLdap {

    public static void main(String[] args) {
        LoginLDAP ll = new LoginLDAP();
        UsuarioSistema u = ll.logarNoLDAP("a1294105", "15423949");
        System.out.println("nosso usuário: " + u.getNome() + " " + u.getSaldo());
        
         

    }

}
