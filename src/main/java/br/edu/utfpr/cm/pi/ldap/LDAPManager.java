package br.edu.utfpr.cm.pi.ldap;

public class LDAPManager {    
}

/*package br.edu.utfpr.cm.saa.security;

import com.novell.ldap.LDAPAttributeSet;
import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPEntry;
import com.novell.ldap.LDAPException;
import com.novell.ldap.LDAPSearchResults;
import com.novell.ldap.util.Base64;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Iterator;
import com.novell.ldap.LDAPAttribute;
import java.util.Map;

*//**
 * This class is responsible for searching for users in an ldap server.
 * @author Marcelo F. Vasconcelos [marvas1987@gmail.com]
 *//*
public class LDAPManager {

    public static final String FILTER = "filter";
    public static final String VALUE = "value";
    *//**porta para conexao com o servidor ldap [pdarao=389]*//*
    private int ldapPort = LDAPConnection.DEFAULT_PORT;
    *//**escopo para conexao com o servidor ldap [pdarao(sub)=2]*//*
    private int searchScope = LDAPConnection.SCOPE_SUB;
    *//**versao do servidor ldap [pdarao(v3)=3]*//*
    private int ldapVersion = LDAPConnection.LDAP_V3;
    *//**endereco de rede do servidor ldap*//*
    private String ldapHost;
    *//**base para busca no servidor*//*
    private String searchBase;
    private LDAPConnection ldapConnection = new LDAPConnection();
    private LDAPEntry ldapEntry = null;
    private LDAPSearchResults searchResults = null;
    private LDAPAttributeSet attributeSet = null;

    *//**
     * Creates a new LDAPManager object initialized with default values for:<br>
     * --ldapPort<br>
     * --searchScope<br>
     * --ldapVersion<br>
     *//*
    public LDAPManager() {
    }

    *//**
     * Creates a new LDAPManager object initialized from the parameters
     * @param ldapHost LDAP server URL
     * @param searchBase base para busca ex: "ou=users,dc=mycompany,dc=com,dc=br"
     *//*
    public LDAPManager(String ldapHost, String searchBase) {
        this.ldapHost = ldapHost;
        this.searchBase = searchBase;
    }

    *//**
     * Creates a new LDAPManager object initialized from the parameters
     * @param ldapPort LDAP server port conection
     * @param searchScope escopo da busca
     * @param ldapVersion LDAP server version
     * @param ldapHost LDAP server URL
     * @param searchBase base para busca ex: "ou=users,dc=mycompany,dc=com,dc=br"
     *//*
    public LDAPManager(int ldapPort, int searchScope, int ldapVersion, String ldapHost, String searchBase) {
        this.ldapPort = ldapPort;
        this.searchScope = searchScope;
        this.ldapVersion = ldapVersion;
        this.ldapHost = ldapHost;
        this.searchBase = searchBase;
    }

    public void connect() throws LDAPException {
        // connect to the server
        ldapConnection.connect(ldapHost, ldapPort);
    }

    *//**
     * Authenticates an user from LDAP server using the loginDN and password.
     * @param loginDN loginDN of user on LDAP server.
     * @param password password of user on LDAP server.
     * @return <code>true</code> if login successfull or <code>false</code> otherwise.
     * @throws IncorrectCredentialsException if the password is invalid.
     *//*
    public boolean login(String loginDN, String password) {
        try {
            if (loginDN != null && password != null) {
                // bind to the server
                ldapConnection.bind(ldapVersion, loginDN, password.getBytes("UTF8"));
                return true;
            } else {
                return false;
            }
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } catch (LDAPException ex) {
            System.out.println("Error: " + ex.getResultCode() + " - " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
        return false;
    }

    *//**
     * Closes the connection with LDAP server.
     * @throws LDAPException 
     *//*
    public void disconnect() throws LDAPException {
        // disconnect with the server
        ldapConnection.disconnect();
    }

    *//**
     * Realiza uma busca no servidor LDAP a partir dos valores recebidos nos parametros.
     * @param searchFilter filtro de busca ex: (uid=uidUser)<br> caso seu valor seja <code>null</code>
     * recupera todos os componentes a partir da base de busca definida.
     * @param attributes atributos do componente que serão recuperados ex: {"cn","dn","uid","email"}<br>
     * caso seu valor seja <code>null</code> assumirá o valor padrão "(objectclass=*)" e irá recuperar todos os atributos.
     * @return <code>true</code> caso algum elemento seja encontrado ou <code>false</code> caso contrário.
     * @throws LDAPException A general exception which includes an error message and an LDAP error code.
     *//*
    public boolean search(String searchFilter, String[] attributes) throws LDAPException {
        connect();
        searchResults = ldapConnection.search(
                searchBase,
                searchScope,
                searchFilter,
                attributes, // if null return all attributes
                false); // return attrs and values
                if (searchResults==null) throw new LDAPException("Não foi possível pesquisar no LDAP. Verifique se o servidor está no ar.",LDAPException.UNAVAILABLE,"");
        return searchResults.hasMore();
    }

    *//**
     * Realiza a busca por um componente no servidor LDAP a partir dos valores recebidos como parametro.
     * @param parameters parametros para filtragem da busca. nome do filtro e valor do filtro.
     * ex: ["carLicense", "1506211"].
     * @param attributes atributos do componente que serão recuperados ex: {"cn","dn","uid","email","carLicense"}<br>
     * caso seu valor seja <code>null</code> assumirá o valor padrão "(objectclass=*)" e irá recuperar todos os atributos.
     * @return <code>true</code> caso algum elemento seja encontrado ou <code>false</code> caso contrário.
     * @throws LDAPException A general exception which includes an error message and an LDAP error code.
     *//*
    public boolean search(Map<String, String> parameters, String[] attributes) throws LDAPException {
        String filter = parameters.get(FILTER);
        String value = parameters.get(VALUE);
        boolean result = false;

        // conectando no servidor
        connect();

        // o segundo parametro null permite o retorno de todos os atributos do usuario
        result = search("(" + filter + "=" + value + ")", attributes);

        return result;
    }

    *//**
     * Get the next component present on searchResult
     * @return an LDAPEntry object, can be <code>null</code> if don't have more components
     * or if nothing has been found.
     *//*
    public LDAPEntry nextEntry() {
        if (searchResults != null && searchResults.hasMore()) {
            try {
                ldapEntry = searchResults.next();
            } catch (LDAPException e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            ldapEntry = null;
        }
        return ldapEntry;
    }

    *//**
     * Get the result of performed search on server.
     * @return a LDAPSearchResults object with the result of performed search on server
     *//*
    public LDAPSearchResults getSearchResults() {
        return searchResults;
    }

    *//**
     * Get the attribute value received as parameter
     * @param attr attribute from which will obtained the value
     * @return uma string as the attribute value
     *//*
    public String getAttributeValue(LDAPAttribute attr) {
        Enumeration allValues = attr.getStringValues();
        String value = "";
        if (allValues != null) {
            // percorre os valores
            while (allValues.hasMoreElements()) {
                value = (String) allValues.nextElement();
                if (!Base64.isLDIFSafe(value)) {
                    // base64 encode and then print out
                    value = Base64.encode(value.getBytes());
                }
            }
        }
        return value;
    }

    *//**
     * Get value of an attribute from your name.
     * @param attributeName name of the attibute
     * @return string with the attribute value, can be <code>null</code> if not found attribute with that name.
     *//*
    public String getAttributeValue(String attributeName) {
        String value = null;
        // get a set with all the attribute in the search
        attributeSet = ldapEntry.getAttributeSet();
        // get the iterator through the list of attributes.
        Iterator allAttributes = attributeSet.iterator();
        while (allAttributes.hasNext()) {
            // takes each attribute
            LDAPAttribute attribute = (LDAPAttribute) allAttributes.next();
            // get the attribute name
            String attrName = attribute.getName();
            if (attrName.equals(attributeName)) {
                // get value or values from attribute
                value = getAttributeValue(attribute);
            }
        }
        return value;
    }

    public LDAPAttributeSet getAttributeSet() {
        return attributeSet;
    }

    public String getLdapHost() {
        return ldapHost;
    }

    public void setLdapHost(String ldapHost) {
        this.ldapHost = ldapHost;
    }

    public int getLdapPort() {
        return ldapPort;
    }

    public void setLdapPort(int ldapPort) {
        this.ldapPort = ldapPort;
    }

    public int getLdapVersion() {
        return ldapVersion;
    }

    public void setLdapVersion(int ldapVersion) {
        this.ldapVersion = ldapVersion;
    }

    public String getSearchBase() {
        return searchBase;
    }

    public void setSearchBase(String searchBase) {
        this.searchBase = searchBase;
    }

    public int getSearchScope() {
        return searchScope;
    }

    public void setSearchScope(int searchScope) {
        this.searchScope = searchScope;
    }

        }
*/