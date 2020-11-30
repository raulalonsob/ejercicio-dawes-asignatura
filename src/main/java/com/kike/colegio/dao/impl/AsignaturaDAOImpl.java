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
			ResultSet rs = st.executeQuery("SELECT * FROM ASIGNATURAS");

			while (rs.next()) {
				Asignatura a = new Asignatura(rs.getInt(1), rs.getString(2), rs.getInt(3));
				listaAsignaturas.add(a);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaAsignaturas;
	}

	@Override
	public List<Asignatura> obtenerAsignaturasporIdyNombreyCurso(String id, String nombre, String curso) {
		String sql = "select * from asignaturas where id like ? and nombre like ? and curso like ?";

		ResultSet asignaturaResultSet = null;
		Connection connection = DBUtils.DBConnection();
		List<Asignatura> listaAsignaturas = new ArrayList<>();

		try {
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, "%" + id + "%");
			ps.setString(2, "%" + nombre + "%");
			ps.setString(3, "%" + curso + "%");


			asignaturaResultSet = ps.executeQuery();

			while (asignaturaResultSet.next()) {
				Asignatura a = new Asignatura
						(asignaturaResultSet.getInt(1), asignaturaResultSet.getString(2), asignaturaResultSet.getInt(3));
				listaAsignaturas.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaAsignaturas;
	}

	@Override
	public Integer insertarAsignaturas(String id, String nombre, String curso) {
		String sql = "INSERT INTO asignaturas (id, nombre, curso) VALUES (?, ?, ?)";
		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		Integer resultado = null;

		try {
			ps = connection.prepareStatement(sql);

			ps.setString(1, id);
			ps.setString(2, nombre);
			ps.setString(3, curso);

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
	public Integer actualizarAsignatura(String idOld, String idNew, String nombre, String curso) {
		String sql = "UPDATE asignaturas SET id= ?, nombre = ? , curso = ? WHERE id = ?";

		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		Integer resultado = null;

		try {
			ps = connection.prepareStatement(sql);

			ps.setString(1, idNew);
			ps.setString(2, nombre);
			ps.setString(3, curso);
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
		String sql = "DELETE FROM asignaturas WHERE id = ?";

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


