package com.kike.colegio.dao;

import java.util.List;

import com.kike.colegio.dtos.Asignatura;


public interface AsignaturaDAO {
	List<Asignatura> obtenerTodasAsignaturas();
	List<Asignatura> obtenerAsignaturasporIdyNombreyCurso(String id, String nombre, String curso);
	Integer insertarAsignaturas(String id, String nombre, String Curso);
	Integer actualizarAsignatura(String idOld, String idNew, String nombre, String curso);
	Integer borrarAsignatura (String id);
}
