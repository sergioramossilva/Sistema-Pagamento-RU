package br.edu.utfpr.cm.pi.beans;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuario extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    private String login;
    private Double saldo;

    @Temporal(TemporalType.DATE)
    private Calendar dataCriacao;

    public Usuario() {
        super();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Calendar getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Calendar dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
                + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
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
        Usuario other = (Usuario) obj;
        if (dataCriacao == null) {
            if (other.dataCriacao != null)
                return false;
        } else if (!dataCriacao.equals(other.dataCriacao))
            return false;
        if (login == null) {
            if (other.login != null)
                return false;
        } else if (!login.equals(other.login))
            return false;
        if (saldo == null) {
            if (other.saldo != null)
                return false;
        } else if (!saldo.equals(other.saldo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + this.getId() + ", login=" + login + ", saldo="
                + saldo + ", dataCriacao=" + dataCriacao + "]";
    }

}