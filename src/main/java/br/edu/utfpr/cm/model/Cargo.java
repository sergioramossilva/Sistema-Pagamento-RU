package br.edu.utfpr.cm.model;

import javax.persistence.Entity;

import org.hibernate.annotations.Type;



@Entity
public class Cargo extends IdSuperClass {

	private String nome;
	
	@Type(type="true_false")
	private boolean isAdmin;
	
}
