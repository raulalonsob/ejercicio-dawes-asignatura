package com.kike.colegio.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kike.colegio.dao.AlumnoDAO;
import com.kike.colegio.dao.CombosDAO;
import com.kike.colegio.dao.impl.AlumnoDAOImpl;
import com.kike.colegio.dao.impl.CombosDAOImpl;
import com.kike.colegio.dtos.ComboDTO;
import com.kike.colegio.utils.ComboUtils;

/**
 * Servlet implementation class InsertarAlumnosController
 */

@WebServlet("/insertaralumno")
public class InsertarAlumnosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarAlumnosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-Recuperar de la BBDD todos los municipios y meterlos en una lista
		
		ComboUtils.recuperacionComboMunicipios(request);	
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/alumno/insertarAlumnos.jsp");
		d.forward(request, response);
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		// Recupero los datos del formulario
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String municipios = request.getParameter("municipios");
		
		AlumnoDAO a = new AlumnoDAOImpl();		
		Integer resultado = a.insertarAlumno(id, nombre, municipios);
		
		request.setAttribute("resultado", resultado);
		
		ComboUtils.recuperacionComboMunicipios(request);
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/alumno/insertarAlumnos.jsp");
		d.forward(request, response);
		
		
	}

}
