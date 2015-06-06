package br.edu.utfpr.cm.pi.beans;

import javax.persistence.Entity;

@Entity
public class Cargo extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    private String nome;
    private Boolean admin;

    public Cargo() {
        super();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((admin == null) ? 0 : admin.hashCode());
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
        Cargo other = (Cargo) obj;
        if (admin == null) {
            if (other.admin != null)
                return false;
        } else if (!admin.equals(other.admin))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cargo [id=" + this.getId() + ", nome=" + nome + ", admin="
                + admin + "]";
    }

}