package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.ClassClienteImp;
import model.Cliente;

@WebServlet("/ControladorCliente")
public class ControladorCliente extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ControladorCliente() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        Cliente client = new Cliente();
        ClassClienteImp crud = new ClassClienteImp();

        if (accion != null) {
            switch (accion) {
                case "Actualizar":
                    int id = Integer.parseInt(request.getParameter("id"));
                    client.setID_Cliente(id);
                    Cliente buscarId = crud.BuscarCliente(client);

                    request.setAttribute("id", buscarId.getID_Cliente());
                    request.setAttribute("nom", buscarId.getNombreC());
                    request.setAttribute("ape", buscarId.getApellidoC());
                    request.setAttribute("email", buscarId.getEmail());
                    request.setAttribute("dni", buscarId.getDni());
                    request.setAttribute("telf", buscarId.getTelefono());

                    request.getRequestDispatcher("/ActualizarCliente.jsp").forward(request, response);
                    break;
                case "Eliminar":
                    int idEliminar = Integer.parseInt(request.getParameter("id"));
                    client.setID_Cliente(idEliminar);
                    crud.EliminarCliente(client);

                    List<Cliente> listado = crud.listaCliente();
                    request.setAttribute("listadoClientes", listado);
                    request.getRequestDispatcher("/ListadoClientes.jsp").forward(request, response);
                    break;
                case "Listar":
                    List<Cliente> listadoCliente = crud.listaCliente();
                    request.setAttribute("listadoClientes", listadoCliente);
                    request.getRequestDispatcher("/ListadoClientes.jsp").forward(request, response);
                    break;
            }
        } else {
            client = new Cliente();
            crud = new ClassClienteImp();
            List<Cliente> listadoClientes = crud.listaCliente();
            request.setAttribute("listadoClientes", listadoClientes);
            request.getRequestDispatcher("/ListadoClientes.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String nom = request.getParameter("nom");
        String ape = request.getParameter("ape");
        String email = request.getParameter("email");
        String dni = request.getParameter("dni");
        String telf = request.getParameter("telf");

        Cliente client = new Cliente();
        ClassClienteImp crud = new ClassClienteImp();

        client.setNombreC(nom);
        client.setApellidoC(ape);
        client.setEmail(email);
        client.setDni(dni);
        client.setTelefono(Integer.parseInt(telf));

        if (id != null) {
            int codigo = Integer.parseInt(id);
            client.setID_Cliente(codigo);
            crud.ActualizarCliente(client);
        } else {
            crud.RegistrarCliente(client);
        }

        List<Cliente> listadoClientes = crud.listaCliente();

        request.setAttribute("listadoClientes", listadoClientes);
        request.getRequestDispatcher("/ListadoClientes.jsp").forward(request, response);
    }
}
