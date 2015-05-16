package br.edu.utfpr.cm.model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class IdSuperClass {

	@Id
	private long id;
}