<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Cliente" %>
<%@ page import="model.Habitacion" %>
<%@ page import="Dao.ClassClienteImp" %>
<%@ page import="Dao.ClassHabitacionImp" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Reserva</title>
    <link rel="stylesheet" href="estilos/registro.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            color: black;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .box-registro {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
            max-width: 100%;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        h2 {
            text-align: center;
            color: #666;
            margin-bottom: 20px;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin-bottom: 5px;
            color: black;
        }

        select, input[type="date"], button {
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
            color: black;
        }

        select:focus, input[type="date"]:focus, button:focus {
            border-color: #007bff;
            outline: none;
        }

        button {
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #0056b3;
        }

        .box-registro form select, .box-registro form input[type="date"] {
            background-color: #f9f9f9;
            color: black;
        }
    </style>
</head>
<body>
    <h1>Registro Reserva de Habitación</h1>
    <div class="box-registro">
        <form action="ControladorReserva" method="post">
            <h2>Registro de Reserva</h2>
            
            <label for="idc">Cliente:</label>
            <select id="idc" name="idc" required>
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

            <label for="ihab">Habitación:</label>
            <select id="ihab" name="ihab" required>
                <option value="">Seleccione la Habitación</option>
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

            <label for="fi">Fecha Inicio:</label>
            <input type="date" id="fi" name="fei" required>

            <label for="ff">Fecha Fin:</label>
            <input type="date" id="ff" name="fef" required>

            <button type="submit">Registrar</button>
        </form>
    </div>
</body>
</html>
