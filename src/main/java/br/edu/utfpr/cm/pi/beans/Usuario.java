package br.edu.utfpr.cm.pi.beans;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity(name="usuario")
@Inheritance(strategy=InheritanceType.JOINED)

public class Usuario extends BasicData implements Serializable {

	
	private String login;
	private double saldo;
	@Temporal(TemporalType.DATE)      
	private Calendar dataCriacao;
	private static final long serialVersionUID = 1L;

	public Usuario() {
		super();
	}   
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}   
	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}   
	public Calendar getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
   
}
