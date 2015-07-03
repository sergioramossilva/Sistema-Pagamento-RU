package br.edu.utfpr.cm.pi.daos;

import br.edu.utfpr.cm.pi.beans.UsuarioSistema;

public class UsuarioDao extends JpaDao<UsuarioSistema, Long> {

    public UsuarioDao() {
        super(UsuarioSistema.class);
    }

}