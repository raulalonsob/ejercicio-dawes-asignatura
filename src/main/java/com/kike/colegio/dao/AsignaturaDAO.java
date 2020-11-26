package com.kike.colegio.dao;

import java.util.List;

import com.kike.colegio.dtos.Asignatura;


public interface AsignaturaDAO {
	List<Asignatura> obtenerTodasAsignaturas();
	List<Asignatura> obtenerAsignaturasporIdyNombre(String id, String nombre);
	Integer insertarAsignaturas(String id, String nombre, String idCurso);
	Integer actualizarAsignaturas(String idOld, String idNew, String nombre, String idCurso);
	Integer borrarAsignatura (String id);
}
