package br.edu.utfpr.cm.pi.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Entity implementation class for Entity: tipo_transacao
 *
 */
@Entity(name="tipo_transacao")
@Inheritance(strategy=InheritanceType.JOINED)
public class TipoTransacao extends BasicData implements Serializable {

	
	private String nome;
	private static final long serialVersionUID = 1L;

	public TipoTransacao() {
		super();
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
   
}
