package br.edu.utfpr.cm.pi.daos;

import br.edu.utfpr.cm.pi.beans.Funcionario;

public class FuncionarioDao extends JpaDao<Funcionario, Long> {

    public FuncionarioDao() {
        super(Funcionario.class);
    }

}
