package br.edu.utfpr.cm.pi.daos;

import br.edu.utfpr.cm.pi.beans.Usuario;

public class UsuarioDao extends JpaDao<Usuario, Integer> {

	public UsuarioDao() {
		super(Usuario.class);
	}

}
