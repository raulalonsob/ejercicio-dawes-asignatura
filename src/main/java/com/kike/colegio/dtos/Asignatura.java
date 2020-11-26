package com.kike.colegio.dtos;

public class Asignatura {
	private Integer id;
	private String nombre;
	private String curso;
	private Integer idCurso;
	/**
	 * @param id
	 * @param nombre
	 * @param curso
	 * @param idCurso
	 */
	public Asignatura(Integer id, String nombre, String curso, Integer idCurso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.curso = curso;
		this.idCurso = idCurso;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the curso
	 */
	public String getCurso() {
		return curso;
	}
	/**
	 * @param curso the curso to set
	 */
	public void setCurso(String curso) {
		this.curso = curso;
	}
	/**
	 * @return the idCurso
	 */
	public Integer getIdCurso() {
		return idCurso;
	}
	/**
	 * @param idCurso the idCurso to set
	 */
	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}
	/**
	 * @param id
	 * @param nombre
	 * @param curso
	 */
	public Asignatura(Integer id, String nombre, String curso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.curso = curso;
	}
	/**
	 * @param id
	 * @param nombre
	 */
	public Asignatura(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
}
