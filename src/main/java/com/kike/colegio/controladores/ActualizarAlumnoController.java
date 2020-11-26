package com.kike.colegio.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kike.colegio.dao.AlumnoDAO;
import com.kike.colegio.dao.impl.AlumnoDAOImpl;

/**
 * Servlet implementation class ActualizarAlumno
 */

@WebServlet("/actualizaralumno")
public class ActualizarAlumnoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarAlumnoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idOld = request.getParameter("idOld");
		String idNew = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String idMunicipio = request.getParameter("municipios");
		


		AlumnoDAO a = new AlumnoDAOImpl();
		a.actualizarAlumno(idOld, idNew, nombre, idMunicipio);
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/alumno/actualizarAlumnos.jsp");
		
		d.forward(request, response);
		
	}

}
