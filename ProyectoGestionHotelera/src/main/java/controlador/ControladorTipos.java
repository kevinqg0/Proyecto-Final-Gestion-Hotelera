package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ClassEstadohabitacionImp;
import Dao.ClassTipohabitacionImp;
import model.Estadohabitacion;
import model.Tipohabitacion;

/**
 * Servlet implementation class ControladorTipos
 */
public class ControladorTipos extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ClassTipohabitacionImp daoTH = new ClassTipohabitacionImp();
	ClassEstadohabitacionImp daoEH = new ClassEstadohabitacionImp();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorTipos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Tipohabitacion> listaTipoHabitacion = daoTH.listaTipoHabitacion();
		if(listaTipoHabitacion.isEmpty()) {
			request.setAttribute("ERROR", "No se encuentrał lista");
			request.getRequestDispatcher("/RegistroHabitacion.jsp").forward(request, response);
		}
		
		List<Estadohabitacion> listaEstadoHabitacion = daoEH.listaEstadoHabitacion();
		if(listaEstadoHabitacion.isEmpty()) {
			request.setAttribute("ERROR", "No se enconuentrał lista");
			request.getRequestDispatcher("/RegistroHabitacion.jsp").forward(request, response);
		}
		
		request.setAttribute("listaTiposHabitacion", listaTipoHabitacion);
		request.setAttribute("listaEstadosHabitacion", listaEstadoHabitacion);
		request.getRequestDispatcher("/RegistroHabitacion.jsp").forward(request, response);
	}

}
