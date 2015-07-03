package br.edu.utfpr.cm.pi.ldap;

import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.utfpr.cm.pi.beans.UsuarioSistema;
import br.edu.utfpr.cm.saa.entidades.Usuario;
import br.edu.utfpr.cm.saa.security.LDAPManager;

import com.novell.ldap.LDAPEntry;
import com.novell.ldap.LDAPException;

/**
 *
 * @author Paulo Azevedo
 */
public class LoginLDAP {

    public UsuarioSistema logarNoLDAP(String login, String senha) {
        try {
            LDAPManager ldapManager = new LDAPManager("172.17.2.4:389", "ou=todos,dc=utfpr,dc=edu,dc=br");

            ldapManager.connect();
            String username = login;
            String password = senha;

            boolean result;
            result = ldapManager.search("(uid=" + username + ")", null);
            if (result) {
                LDAPEntry entry = ldapManager.nextEntry();
                String loginDN = entry.getDN();
                System.out.println(entry.getAttributeSet());
                if (ldapManager.login(loginDN, password)) {
                    
                    System.out.println("OK");
                    
                    
                    ldapManager.disconnect();
                    // como a autenticacao no ldap já foi realizada a deve ser alterada
                    //para permitir a autorização local
                    //assword = "";
                    //} else {
                    //throw new UnknownAccountException("N�o existe conta com este login.");
                    //}
                    Usuario usuarioLdap = ldapManager.search(login);
                    UsuarioSistema usuarioSistema = new UsuarioSistema();
                    usuarioSistema.setLogin(usuarioLdap.getLogin());
                    usuarioSistema.setNome(usuarioLdap.getNome());
                    return usuarioSistema;
                } else {
                    System.out.println("Fail");
                    return null;
                }
                
            }
            return null;
        } catch (LDAPException ex) {
            Logger.getLogger(MainLDAP.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
