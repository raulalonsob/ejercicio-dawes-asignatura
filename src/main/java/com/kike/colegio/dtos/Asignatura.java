package com.kike.colegio.dtos;

public class Asignatura {
	private Integer id;
	private String nombre;
	private Integer curso;
	
	public Asignatura() {
		super();
	}

	public Asignatura(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Asignatura(Integer id, String nombre, Integer curso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.curso = curso;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}
	
	
}
