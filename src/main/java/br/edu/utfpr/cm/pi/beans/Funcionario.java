package br.edu.utfpr.cm.pi.beans;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "funcionario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Funcionario extends BasicData implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    private Cargo cargo;

    private String nome;

    @Column(unique = true)
    private String cpf;

    @Temporal(TemporalType.DATE)
    private Calendar dataCadastro;
    private boolean ativo;

    @Column(unique = true)
    private String login;
    private String senha;

    public Funcionario() {
    }

    /**
     * @return the cargo
     */
    public Cargo getCargo() {
        return cargo;
    }

    /**
     * @param cargo
     *            the cargo to set
     */
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome
     *            the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf
     *            the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the dataCadastro
     */
    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @param dataCadastro
     *            the dtCadastro to set
     */
    public void setDataCadastro(Calendar dtCadastro) {
        this.dataCadastro = dtCadastro;
    }

    /**
     * @return the ativo
     */
    public boolean isAtivo() {
        return ativo;
    }

    /**
     * @param ativo
     *            the ativo to set
     */
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login
     *            the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha
     *            the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + (ativo ? 1231 : 1237);
        result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        result = prime * result
                + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((senha == null) ? 0 : senha.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) obj;
        if (ativo != other.ativo) {
            return false;
        }
        if (cargo == null) {
            if (other.cargo != null) {
                return false;
            }
        } else if (!cargo.equals(other.cargo)) {
            return false;
        }
        if (cpf == null) {
            if (other.cpf != null) {
                return false;
            }
        } else if (!cpf.equals(other.cpf)) {
            return false;
        }
        if (dataCadastro == null) {
            if (other.dataCadastro != null) {
                return false;
            }
        } else if (!dataCadastro.equals(other.dataCadastro)) {
            return false;
        }
        if (login == null) {
            if (other.login != null) {
                return false;
            }
        } else if (!login.equals(other.login)) {
            return false;
        }
        if (nome == null) {
            if (other.nome != null) {
                return false;
            }
        } else if (!nome.equals(other.nome)) {
            return false;
        }
        if (senha == null) {
            if (other.senha != null) {
                return false;
            }
        } else if (!senha.equals(other.senha)) {
            return false;
        }
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Funcionario [id=" + this.getId() + "cargo=" + cargo.getNome()
                + ", nome=" + nome + ", cpf=" + cpf + ", dtCadastro="
                + dataCadastro + ", ativo=" + ativo + ", login=" + login
                + ", senha=" + senha + "]";
    }

}