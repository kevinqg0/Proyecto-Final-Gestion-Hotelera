<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Cliente" %>
<%@ page import="model.Habitacion" %>
<%@ page import="Dao.ClassClienteImp" %>
<%@ page import="Dao.ClassHabitacionImp" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actualizar Reserva</title>
<link rel="stylesheet" href="estilos/registro.css">
</head>
<body>

<h1 align="center">Actualizar Reserva</h1>

<form action="ControladorReserva" method="post">
    <%
    String idReserva = (request.getAttribute("idReserva") != null) ? request.getAttribute("idReserva").toString() : "";
    String idCliente = (request.getAttribute("idCliente") != null) ? request.getAttribute("idCliente").toString() : "";
    String idHabitacion = (request.getAttribute("idHabitacion") != null) ? request.getAttribute("idHabitacion").toString() : "";
    String fechaInicio = (request.getAttribute("fechaInicio") != null) ? request.getAttribute("fechaInicio").toString() : "";
    String fechaFin = (request.getAttribute("fechaFin") != null) ? request.getAttribute("fechaFin").toString() : "";
    %>
    <table border="2" align="center">
        <tr>
            <td>ID RESERVA</td>
            <td><input type="text" name="idReserva" value="<%= idReserva %>" readonly></td>
        </tr>
        <tr>
            <td>Cliente</td>
            <td>
                <select name="idCliente" required>
                    <option value="">Seleccione el Cliente</option>
                <%
                ClassClienteImp clienteDAO = new ClassClienteImp();
                List<Cliente> clientes = clienteDAO.listaCliente();
                for(Cliente cliente: clientes){
                %>
                    <option value="<%=cliente.getID_Cliente()%>"><%=cliente.getNombreC()%></option>
                <%
                        }
                %>
                </select>
            </td>
        </tr>
        <tr>
            <td>Habitación</td>
            <td>
                <select name="idHabitacion" required>
                    <option value="">Seleccione el habitacion</option>
                <%
                ClassHabitacionImp habitacionDAO = new ClassHabitacionImp();
                List<Habitacion> habitaciones = habitacionDAO.listaHabitacion();
                for(Habitacion habitacion: habitaciones){
                %>
                    <option value="<%=habitacion.getID_Habitacion()%>"><%=habitacion.getID_Habitacion()%></option>
                <%
                        }
                %>
                </select>
            </td>
        </tr>
        <tr>
            <td>Fecha Inicio</td>
            <td><input type="date" name="fechaInicio" value="<%= fechaInicio %>" required></td>
        </tr>
        <tr>
            <td>Fecha Fin</td>
            <td><input type="date" name="fechaFin" value="<%= fechaFin %>" required></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Actualizar Reserva"></td>
        </tr>
    </table>
</form>

</body>
</html>
