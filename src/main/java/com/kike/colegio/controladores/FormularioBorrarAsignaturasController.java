package com.kike.colegio.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kike.colegio.dao.AsignaturaDAO;

import com.kike.colegio.dao.impl.AsignaturaDAOImpl;

import com.kike.colegio.dtos.Asignatura;

/**
 * Servlet implementation class FormularioBorrarAsignaturasController
 */
@WebServlet("/formularioborrarasignaturas")
public class FormularioBorrarAsignaturasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioBorrarAsignaturasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/asignatura/borrarAsignaturas.jsp");
		d.forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String curso = request.getParameter("curso");
		
		AsignaturaDAO a = new AsignaturaDAOImpl();
	 	List<Asignatura> listaAsignaturas = new ArrayList<>();
	 	
	 	listaAsignaturas = a.obtenerAsignaturasporIdyNombreyCurso(id, nombre,curso);
		

		request.setAttribute("lista", listaAsignaturas);
		
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/asignatura/borrarAsignaturas.jsp");
		d.forward(request, response);
	}

}
