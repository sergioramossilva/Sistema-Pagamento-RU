package br.edu.utfpr.cm.pi.daos;

import br.edu.utfpr.cm.pi.beans.Usuario;

public class UsuarioDao extends JpaDao<Usuario, Long> {

    public UsuarioDao() {
        super(Usuario.class);
    }

}