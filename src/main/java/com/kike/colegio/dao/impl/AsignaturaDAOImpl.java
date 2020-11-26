package com.kike.colegio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kike.colegio.dao.AsignaturaDAO;
import com.kike.colegio.dtos.Asignatura;
import com.kike.colegio.utils.DBUtils;

public class AsignaturaDAOImpl implements AsignaturaDAO{

	@Override
	public List<Asignatura> obtenerTodasAsignaturas() {

		List<Asignatura> listaAsignaturas = new ArrayList<>();

		try {
			Connection connection = DBUtils.DBConnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM ALUMNOS");

			while (rs.next()) {
				Asignatura a = new Asignatura(rs.getInt(1), rs.getString(2), "");
				listaAsignaturas.add(a);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaAsignaturas;
	}

	@Override
	public List<Asignatura> obtenerAsignaturasporIdyNombre(String id, String nombre) {
		// String sql = "SELECT * FROM alumnos WHERE id LIKE ? AND nombre LIKE ?";
		String sql = "SELECT a.id, a.nombre, m.nombre, m.id_municipio " + "FROM alumnos a, municipios m "
				+ "WHERE  a.id_municipio = m.id_municipio " + "AND a.id LIKE ? AND a.nombre LIKE ?";

		ResultSet asignaturaResultSet = null;
		Connection connection = DBUtils.DBConnection();
		List<Asignatura> listaAsignaturas = new ArrayList<>();

		try {
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, "%" + id + "%");
			ps.setString(2, "%" + nombre + "%");

			asignaturaResultSet = ps.executeQuery();

			while (asignaturaResultSet.next()) {
				Asignatura a = new Asignatura
						(asignaturaResultSet.getInt(1), asignaturaResultSet.getString(2),
						asignaturaResultSet.getString(3), asignaturaResultSet.getInt(4));
				listaAsignaturas.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaAsignaturas;
	}

	@Override
	public Integer insertarAsignaturas(String id, String nombre, String idMunicipio) {
		String sql = "INSERT INTO alumnos (id, nombre, id_municipio) VALUES (?, ?, ?)";
		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		Integer resultado = null;

		try {
			ps = connection.prepareStatement(sql);

			ps.setString(1, id);
			ps.setString(2, nombre);
			ps.setString(3, idMunicipio);

			resultado = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return resultado;
	}

	@Override
	public Integer actualizarAsignaturas(String idOld, String idNew, String nombre, String idMunicipio) {
		String sql = "UPDATE alumnos SET id= ?, nombre = ? ,id_municipio = ? WHERE id = ?";

		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		Integer resultado = null;

		try {
			ps = connection.prepareStatement(sql);

			ps.setString(1, idNew);
			ps.setString(2, nombre);
			ps.setString(3, idMunicipio);
			ps.setString(4, idOld);

			resultado = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return resultado;
	}

	@Override
	public Integer borrarAsignatura(String id) {
		String sql = "DELETE FROM alumnos WHERE id = ?";

		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		Integer resultado = null;

		try {
			ps = connection.prepareStatement(sql);

			ps.setString(1, id);

			resultado = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return resultado;
	}

}


