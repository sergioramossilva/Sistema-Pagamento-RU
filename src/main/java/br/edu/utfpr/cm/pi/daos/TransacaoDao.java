package br.edu.utfpr.cm.pi.daos;

import br.edu.utfpr.cm.pi.beans.Transacao;

public class TransacaoDao extends JpaDao<Transacao, Integer> {

	public TransacaoDao() {
		super(Transacao.class);
	}
}