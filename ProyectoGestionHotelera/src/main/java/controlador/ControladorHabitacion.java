package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ClassEstadohabitacionImp;
import Dao.ClassHabitacionImp;
import Dao.ClassTipohabitacionImp;
import Dao.EstadohabitacionDAO;
import Dao.TipohabitacionDAO;
import model.Estadohabitacion;
import model.Habitacion;
import model.Tipohabitacion;

@WebServlet("/ControladorHabitacion")
public class ControladorHabitacion extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ClassHabitacionImp habitacionDAO = new ClassHabitacionImp();
    private TipohabitacionDAO tipoHabitacionDAO = new TipohabitacionDAO();
    private EstadohabitacionDAO estadoHabitacionDAO = new EstadohabitacionDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        
        if (accion != null) {
            switch (accion) {
                case "Actualizar":
                    actualizarHabitacion(request, response);
                    break;
                case "Eliminar":
                    eliminarHabitacion(request, response);
                    break;
                case "Listar":
                    listarHabitaciones(request, response);
                    break;
                default:
                    listarHabitaciones(request, response);
                    break;
            }
        } else {
            cargarFormularioRegistro(request, response);
        }
    }
    
    private void actualizarHabitacion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if ("show".equals(action)) {
            // Cargar el formulario de actualización
            int id = Integer.parseInt(request.getParameter("id"));
            Habitacion hab = new Habitacion();
            hab.setID_Habitacion(id);
            Habitacion habitacion = habitacionDAO.BuscarHabitacion(hab);
            
            // Cargar las listas necesarias para los dropdowns
            List<Tipohabitacion> tiposHabitacion = tipoHabitacionDAO.findAll();
            List<Estadohabitacion> estadosHabitacion = estadoHabitacionDAO.findAll();
            
            request.setAttribute("habitacion", habitacion);
            request.setAttribute("tiposHabitacion", tiposHabitacion);
            request.setAttribute("estadosHabitacion", estadosHabitacion);
            
            request.getRequestDispatcher("/ActualizarHabitacion.jsp").forward(request, response);
        } else {
            // Procesar la actualización
            int id = Integer.parseInt(request.getParameter("id"));
            int idTipo = Integer.parseInt(request.getParameter("tipo"));
            double precio = Double.parseDouble(request.getParameter("precio"));
            String comodidades = request.getParameter("comodidades");
            int idEstado = Integer.parseInt(request.getParameter("estado"));
            
            // Crear objeto habitación con los nuevos datos
            Habitacion habitacion = new Habitacion();
            habitacion.setID_Habitacion(id);
            
            // Configurar tipo de habitación
            Tipohabitacion tipo = tipoHabitacionDAO.findById(idTipo);
            habitacion.setTipohabitacion(tipo);
            
            // Configurar estado
            Estadohabitacion estado = estadoHabitacionDAO.findById(idEstado);
            habitacion.setEstadohabitacion(estado);
            
            habitacion.setPrecio(precio);
            habitacion.setComodidades(comodidades);
            
            // Actualizar en la base de datos
            habitacionDAO.ActualizarHabitacion(habitacion);
            
            // Redireccionar al listado
            response.sendRedirect(request.getContextPath() + "/ControladorHabitacion?accion=Listar");
        }
    }

    private void eliminarHabitacion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idEliminar = Integer.parseInt(request.getParameter("id"));
        Habitacion hab = new Habitacion();
        hab.setID_Habitacion(idEliminar);
        habitacionDAO.EliminarHabitacion(hab);

        listarHabitaciones(request, response);
    }

    private void listarHabitaciones(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Habitacion> listadoHabitacion = habitacionDAO.listaHabitacion();
        request.setAttribute("listadoHabitaciones", listadoHabitacion);
        request.getRequestDispatcher("/ListadoHabitaciones.jsp").forward(request, response);
    }

    private void cargarFormularioRegistro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Tipohabitacion> listaTiposHabitacion = tipoHabitacionDAO.findAll();
        List<Estadohabitacion> listaEstadosHabitacion = estadoHabitacionDAO.findAll();

        request.setAttribute("listaTiposHabitacion", listaTiposHabitacion);
        request.setAttribute("listaEstadosHabitacion", listaEstadosHabitacion);

        request.getRequestDispatcher("/ListadoHabitaciones.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("update".equals(action)) {
            // Procesar la actualización
            try {
                int id = Integer.parseInt(request.getParameter("id")); // ID de la habitación
                int idTipo = Integer.parseInt(request.getParameter("tipo")); // ID del tipo de habitación
                double precio = Double.parseDouble(request.getParameter("precio")); // Precio
                String comodidades = request.getParameter("comodidades"); // Comodidades
                int idEstado = Integer.parseInt(request.getParameter("estado")); // ID del estado

                // Crear objeto habitación con los nuevos datos
                Habitacion habitacion = new Habitacion();
                habitacion.setID_Habitacion(id);
                habitacion.setPrecio(precio);
                habitacion.setComodidades(comodidades);
                habitacion.setTipohabitacion(tipoHabitacionDAO.findById(idTipo));
                habitacion.setEstadohabitacion(estadoHabitacionDAO.findById(idEstado));

                // Actualizar en la base de datos
                habitacionDAO.ActualizarHabitacion(habitacion);

                // Redireccionar al listado
                response.sendRedirect(request.getContextPath() + "/ControladorHabitacion?accion=Listar");
            } catch (Exception e) {
                e.printStackTrace(); // Imprimir la excepción en la consola
                request.setAttribute("error", "Error al actualizar la habitación. " + e.getMessage());
                request.getRequestDispatcher("/ActualizarHabitacion.jsp").forward(request, response);
            }
        } else {
            // Si no es la acción de actualización, manejar como desees
            response.sendRedirect(request.getContextPath() + "/ControladorHabitacion?accion=Listar");
        }
    }
}

