package br.edu.utfpr.cm.pi.beans;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Transacao extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    private TipoTransacao tipoTransacao;

    @ManyToOne
    private Funcionario funcionario;

    @ManyToOne
    private Usuario usuario;

    private Integer quantidade;
    private Calendar data;

    public Transacao() {
        super();
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result
                + ((funcionario == null) ? 0 : funcionario.hashCode());
        result = prime * result
                + ((quantidade == null) ? 0 : quantidade.hashCode());
        result = prime * result
                + ((tipoTransacao == null) ? 0 : tipoTransacao.hashCode());
        result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Transacao other = (Transacao) obj;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (funcionario == null) {
            if (other.funcionario != null)
                return false;
        } else if (!funcionario.equals(other.funcionario))
            return false;
        if (quantidade == null) {
            if (other.quantidade != null)
                return false;
        } else if (!quantidade.equals(other.quantidade))
            return false;
        if (tipoTransacao == null) {
            if (other.tipoTransacao != null)
                return false;
        } else if (!tipoTransacao.equals(other.tipoTransacao))
            return false;
        if (usuario == null) {
            if (other.usuario != null)
                return false;
        } else if (!usuario.equals(other.usuario))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Transacao [id=" + this.getId() + ", tipoTransacao="
                + tipoTransacao + ", funcionario=" + funcionario + ", usuario="
                + usuario + ", quantidade=" + quantidade + ", data=" + data
                + "]";
    }

}