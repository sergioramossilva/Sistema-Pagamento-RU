package br.edu.utfpr.cm.pi.ldap;

import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.utfpr.cm.pi.beans.UsuarioSistema;
import br.edu.utfpr.cm.pi.daos.UsuarioDao;
import br.edu.utfpr.cm.saa.entidades.Usuario;
import br.edu.utfpr.cm.saa.security.LDAPManager;

import com.novell.ldap.LDAPEntry;
import com.novell.ldap.LDAPException;

/**
 *
 * @author Paulo Azevedo
 */
public class LoginLDAP {
    LDAPManager ldapManager = new LDAPManager("172.17.2.4:389",
            "ou=todos,dc=utfpr,dc=edu,dc=br");

    public UsuarioSistema logarNoLDAP(String login, String senha) {
        try {
            /*
             * LDAPManager ldapManager = new LDAPManager("172.17.2.4:389",
             * "ou=todos,dc=utfpr,dc=edu,dc=br");
             */

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
                    // como a autenticacao no ldap já foi realizada a deve ser
                    // alterada
                    // para permitir a autorização local
                    // assword = "";
                    // } else {
                    // throw new
                    // UnknownAccountException("N�o existe conta com este login.");
                    // }
                    return geraUsuarioDoSistemaAPartirDeLoginNoLDAP(login);

                } else {
                    System.out.println("Fail");
                    return null;
                }

            }
            return null;
        } catch (LDAPException ex) {
            Logger.getLogger(MainLDAP.class.getName()).log(Level.SEVERE, null,
                    ex);
            return null;
        }
    }

    /**
     * @param login
     * @return
     * @throws LDAPException
     */
    public UsuarioSistema geraUsuarioDoSistemaAPartirDeLoginNoLDAP(String login) {
        UsuarioSistema usuarioSistema = null;
        try {
            Usuario usuarioLdap = ldapManager.search(login);
            UsuarioDao dao = new UsuarioDao();
            usuarioSistema = dao
                    .retornaUsuarioDoSistemaAPartirDeUsuarioDoLdap(usuarioLdap);

            if (usuarioSistema == null && usuarioLdap != null) {

                usuarioSistema = new UsuarioSistema();
                usuarioSistema.setLogin(usuarioLdap.getLogin());
                usuarioSistema.setNome(usuarioLdap.getNome());
                dao.save(usuarioSistema);
            }
            if (!usuarioSistema.getNome().equals(usuarioLdap.getNome())) {
                usuarioSistema.setNome(usuarioLdap.getNome());
                dao.save(usuarioSistema);
            }
        } catch (LDAPException e) {
            e.printStackTrace();
        }
        return usuarioSistema;
    }
}
