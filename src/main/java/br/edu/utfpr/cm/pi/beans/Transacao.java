package br.edu.utfpr.cm.pi.beans;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: transacao
 *
 */
@Entity(name = "transacao")
@Inheritance(strategy = InheritanceType.JOINED)
public class Transacao extends BasicData implements Serializable {
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Funcionario funcionario;
    @ManyToOne
    private TipoTransacao tipoTransacao;
    private int quantidade;
    private Calendar data;
    private static final long serialVersionUID = 1L;

    public Transacao() {
        super();
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return this.usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the funcionario
     */
    public Funcionario getFuncionario() {
        return this.funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * @return the tipoTransacao
     */
    public TipoTransacao getTipoTransacao() {
        return this.tipoTransacao;
    }

    /**
     * @param tipoTransacao the tipoTransacao to set
     */
    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return this.quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the data
     */
    public Calendar getData() {
        return this.data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Calendar data) {
        this.data = data;
    }

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    }
