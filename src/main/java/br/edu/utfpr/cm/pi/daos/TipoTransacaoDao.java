package br.edu.utfpr.cm.pi.daos;

import br.edu.utfpr.cm.pi.beans.TipoTransacao;

public class TipoTransacaoDao extends JpaDao<TipoTransacao, Long> {

    public TipoTransacaoDao() {
        super(TipoTransacao.class);
    }

}