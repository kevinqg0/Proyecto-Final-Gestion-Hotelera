package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ClassUsuarioImp;
import interfaces.IUsuario;
import model.Usuario;

@WebServlet("/ControladorUsuario")
public class ControladorUsuario extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ControladorUsuario() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        IUsuario usuarioDAO = new ClassUsuarioImp();
        Usuario user = usuarioDAO.validate(username, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("ListadoReserva.jsp");
        } else {
            response.sendRedirect("Login.jsp?error=1");
        }
    }
}