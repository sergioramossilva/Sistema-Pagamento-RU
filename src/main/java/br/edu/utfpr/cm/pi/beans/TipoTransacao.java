package br.edu.utfpr.cm.pi.beans;

import javax.persistence.Entity;

@Entity
public class TipoTransacao extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    private String nome;

    public TipoTransacao() {
        super();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
        TipoTransacao other = (TipoTransacao) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TipoTransacao [id=" + this.getId() + ", nome=" + nome + "]";
    }
}