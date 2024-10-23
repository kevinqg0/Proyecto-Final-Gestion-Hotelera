<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Estadohabitacion" %>
<%@ page import="model.Tipohabitacion" %>
<%@ page import="Dao.ClassTipohabitacionImp" %>
<%@ page import="Dao.ClassEstadohabitacionImp" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Habitaciones</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }
        .box-registro {
            background-color: #ffffff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            width: 400px;
          
        }
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            margin-bottom: 5px;
            color: #333;
        }
        input[type="text"], input[type="number"], select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 5px;
            font-size: 16px;
            margin-top: 10px;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Registro de Habitaciones</h1>
    <div class="box-registro">
        <form action="ControladorHabitacion" method="post">
            
            <label for="idtipo">Tipo Habitación:</label>
            <select id="idtipo" name="idtipo" required>
                <option value="">Seleccione el tipo de habitación</option>
                <%
                ClassTipohabitacionImp tipoHabitacionDAO = new ClassTipohabitacionImp();
                List<Tipohabitacion> tipoHabitaciones = tipoHabitacionDAO.listaTipoHabitacion();
                for(Tipohabitacion tipoHabitacion: tipoHabitaciones){
                %>
                    <option value="<%=tipoHabitacion.getID_TipoH()%>"><%=tipoHabitacion.getNom_TipoH()%></option>
                <%
                }
                %>
            </select>

            <label for="precio">Precio:</label>
            <input type="number" id="precio" name="pre" required>

            <label for="comodidades">Comodidades:</label>
            <input type="text" id="comodidades" name="comodidades" required>

            <label for="estado">Estado:</label>
            <select id="estado" name="est" required>
                <option value="">Seleccione el estado de la habitación</option>
                <%
                ClassEstadohabitacionImp estadoHabitacionDAO = new ClassEstadohabitacionImp();
                List<Estadohabitacion> estadoHabitaciones = estadoHabitacionDAO.listaEstadoHabitacion();
                for(Estadohabitacion estadoHabitacion: estadoHabitaciones){
                %>
                    <option value="<%=estadoHabitacion.getID_EstadoH() %>"><%=estadoHabitacion.getNom_EstadoH() %></option>
                <%
                }
                %>
            </select>

            <button type="submit">Registrar</button>
        </form>
    </div>
</body>
</html>
