package com.ensolvers.notesapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String name;
	@Column (nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
	private Boolean active = true;
	
	private String text;
	
	public Note(Integer id, String name, Boolean active, String text) {
		super();
		this.id = id;
		this.name = name;
		this.active = active;
		this.text = text;
	}
	public Note(String name, String text) {
		super();
		this.name = name;
		this.text = text;
	}
	public Note() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean checked) {
		this.active = checked;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
