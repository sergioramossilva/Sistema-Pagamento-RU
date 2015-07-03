package br.edu.utfpr.cm.pi.ldap;

public class Autenticator {

}
/*

 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 
package br.edu.utfpr.cm.saa.security;

import br.edu.utfpr.cm.coint.manulab.controllers.LoginController;
import br.edu.utfpr.cm.coint.manulab.entities.Usuario;
import com.novell.ldap.LDAPEntry;
import com.novell.ldap.LDAPException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

*//**
 *
 * @author igor
 *//*
public class Autenticador {

    private Usuario usuario;
    private String loginDN;
    private LDAPManager ldapManager;
    private static final String host = "192.168.1.4";
    private static final String searchBase = "ou=colaboradores,ou=todos,dc=utfpr,dc=edu,dc=br";

    public Autenticador() {
        this.ldapManager = new LDAPManager(host, searchBase);
    }

    public boolean buscaNaBaseLDAP(String userName) throws LDAPException {
        usuario = new Usuario();
        ldapManager.connect();
        this.usuario.setLogin(userName);
        boolean existeNaBase = ldapManager.search("(uid=" + userName + ")", null);
        if (existeNaBase) {
            LDAPEntry entry = ldapManager.nextEntry();
            this.loginDN = entry.getDN();
            this.usuario.setNome(entry.getAttribute("cn").getStringValue());
            if (entry.getAttribute("mail") != null)
                this.usuario.setEmail(entry.getAttribute("mail").getStringValue());
            else
                this.usuario.setEmail(userName+"@utfpr.edu.br");
        }
        ldapManager.disconnect();
        return existeNaBase;
    }

    public boolean loginLdap(String login, String password) {
        boolean resultadoLogin = false;
        try {
            if (buscaNaBaseLDAP(login)) {
                ldapManager.connect();
                resultadoLogin = ldapManager.login(this.loginDN, password);
            }
            ldapManager.disconnect();
        } catch (LDAPException ex) {
            Logger.getLogger(Autenticador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (resultadoLogin);
    }

    public static String md5(String pass) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            BigInteger hash = new BigInteger(1, md.digest(pass.getBytes()));
            return hash.toString(16);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
*/