package controlador;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ClassClienteImp;
import Dao.ClassHabitacionImp;
import Dao.ClassReservaImp;
import model.Cliente;
import model.Habitacion;
import model.Reserva;

@WebServlet("/ControladorReserva")
public class ControladorReserva extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ClassReservaImp reservaDAO = new ClassReservaImp();
    private ClassClienteImp clienteDAO = new ClassClienteImp();
    private ClassHabitacionImp habitacionDAO = new ClassHabitacionImp();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        
        if (accion != null) {
            switch (accion) {
                case "Actualizar":
                    actualizarReserva(request, response);
                    break;
                case "Eliminar":
                    eliminarReserva(request, response);
                    break;
                case "Listar":
                    listarReservas(request, response);
                    break;
                default:
                    listarReservas(request, response);
                    break;
            }
        } else {
            cargarFormularioRegistro(request, response);
        }
    }
    
    private void actualizarReserva(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Reserva re = new Reserva();
        re.setID_Reserva(id);
        Reserva buscarId = reservaDAO.BuscarReserva(re);

        request.setAttribute("idReserva", buscarId.getID_Reserva());
        request.setAttribute("idCliente", buscarId.getCliente().getID_Cliente());
        request.setAttribute("idHabitacion", buscarId.getHabitacion().getID_Habitacion());
        request.setAttribute("fechaInicio", buscarId.getFechaInicio());
        request.setAttribute("fechaFin", buscarId.getFechaFin());

        request.getRequestDispatcher("/ActualizarReserva.jsp").forward(request, response);
    }

    private void eliminarReserva(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idEliminar = Integer.parseInt(request.getParameter("id"));
        Reserva re = new Reserva();
        re.setID_Reserva(idEliminar);
        reservaDAO.EliminarReserva(re);

        listarReservas(request, response);
    }

    private void listarReservas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Reserva> listadoReserva = reservaDAO.listaReserva();
        request.setAttribute("listadoReservas", listadoReserva);
        request.getRequestDispatcher("/ListadoReserva.jsp").forward(request, response);
    }

    private void cargarFormularioRegistro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cliente> listaClientes = clienteDAO.listaCliente();
        List<Habitacion> listaHabitaciones = habitacionDAO.listaHabitacion();

        request.setAttribute("listaClientes", listaClientes);
        request.setAttribute("listaHabitaciones", listaHabitaciones);

        request.getRequestDispatcher("/ListadoReserva.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form parameters
        String idClienteStr = request.getParameter("idc");
        String idHabitacionStr = request.getParameter("ihab");
        String fechaInicio = request.getParameter("fei");
        String fechaFin = request.getParameter("fef");

        int idCliente = Integer.parseInt(idClienteStr);
        int idHabitacion = Integer.parseInt(idHabitacionStr);
        
        ClassHabitacionImp habitacionDAO = new ClassHabitacionImp();
        ClassClienteImp clienteDAO = new ClassClienteImp();
        
        Cliente cliente = clienteDAO.BuscarClientePorID(idCliente);
        Habitacion habitacion = habitacionDAO.BuscarHabitacionPorID(idHabitacion);

        Reserva reserva = new Reserva();
        reserva.setCliente(cliente);
        reserva.setHabitacion(habitacion);
        
     // Crear el formato para parsear las fechas
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            // Parsear las fechas de String a Date
            Date fiFormateada = formato.parse(fechaInicio);
            Date ffFormateada = formato.parse(fechaFin);
            
            reserva.setFechaInicio(fiFormateada);
            reserva.setFechaFin(ffFormateada);

            reservaDAO.RegistrarReserva(reserva);

            List<Reserva> listadoReserva = reservaDAO.listaReserva();
            request.setAttribute("listadoReservas", listadoReserva);
            request.getRequestDispatcher("/ListadoReserva.jsp").forward(request, response);
        } catch (ParseException e) {
            e.printStackTrace(); // Manejar la excepción apropiadamente
        }
        
    }
    
    
}
