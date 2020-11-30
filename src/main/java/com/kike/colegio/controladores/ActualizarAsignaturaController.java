package com.kike.colegio.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kike.colegio.dao.AsignaturaDAO;
import com.kike.colegio.dao.impl.AsignaturaDAOImpl;

/**
 * Servlet implementation class ActualizarAsignaturaController
 */
@WebServlet("/actualizarasignatura")
public class ActualizarAsignaturaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarAsignaturaController() {
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
		String curso = request.getParameter("curso");
		


		AsignaturaDAO a = new AsignaturaDAOImpl();
		a.actualizarAsignatura(idOld, idNew, nombre, curso);
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/asignatura/actualizarAsignaturas.jsp");
		
		d.forward(request, response);
	}

}
