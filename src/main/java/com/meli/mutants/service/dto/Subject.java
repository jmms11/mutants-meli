package com.meli.mutants.service.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author JhonMauricio
 *
 */
@Entity
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_subject;
	
	@Column
	private String type;
	
	@Column
	private String adn;
	

	public Subject() {
		
	}
	

	public Integer getId_subject() {
		return id_subject;
	}

	public void setId_subject(Integer id_subject) {
		this.id_subject = id_subject;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAdn() {
		return adn;
	}

	public void setAdn(String adn) {
		this.adn = adn;
	}

	@Override
	public String toString() {
		return "Subject [id_subject=" + id_subject + ", type=" + type + ", adn=" + adn + "]";
	}
	
	

}
