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

import com.kike.colegio.dao.AlumnoDAO;
import com.kike.colegio.dao.impl.AlumnoDAOImpl;
import com.kike.colegio.dtos.Alumno;
import com.kike.colegio.utils.ComboUtils;

/**
 * Servlet implementation class ActualizarAlumnos
 */
@WebServlet("/formularioactualizaralumnos")
public class FormularioActualizarAlumnosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioActualizarAlumnosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/alumno/actualizarAlumnos.jsp");
		d.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ComboUtils.recuperacionComboMunicipios(request);
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		
		AlumnoDAO a = new AlumnoDAOImpl();
	 	List<Alumno> listaAlumnos = new ArrayList<>();
	 	
	 	listaAlumnos = a.obtenerAlumnosporIdyNombre(id, nombre);
		

		request.setAttribute("lista", listaAlumnos);
		
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/alumno/actualizarAlumnos.jsp");
		d.forward(request, response);
	}

}
