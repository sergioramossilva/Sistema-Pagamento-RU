package br.edu.utfpr.cm.model;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BasicData implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	public BasicData() {
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
