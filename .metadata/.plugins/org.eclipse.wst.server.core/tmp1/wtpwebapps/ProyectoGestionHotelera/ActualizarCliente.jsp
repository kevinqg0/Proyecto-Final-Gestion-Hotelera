<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Actualizar Cliente</title>
    
    <link rel="stylesheet" href="estilos/registro.css">
</head>
<body>
    <%
        String id = request.getParameter("id");
        String nombre = request.getParameter("nom");
        String apellido = request.getParameter("ape");
        String email = request.getParameter("email");
        String dni = request.getParameter("dni");
        String telefono = request.getParameter("telf");
    %>
    <h1>Actualizar Cliente</h1>
    <div class="box-registro">
        <form action="ControladorCliente" method="post">
            <!-- Campo oculto para el ID -->
            <input type="hidden" name="id" value="<%=id%>">
            
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nom" value="<%=nombre%>" required>
            
            <label for="apellido">Apellido:</label>
            <input type="text" id="apellido" name="ape" value="<%=apellido%>" required>
            
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="<%=email%>" required>
            
            <label for="dni">DNI:</label>
            <input type="text" id="dni" name="dni" value="<%=dni%>" required>
            
            <label for="telefono">Teléfono:</label>
            <input type="tel" id="telefono" name="telf" value="<%=telefono%>" required>
            
            <button type="submit">Actualizar</button>
            
            <!-- Botón opcional para cancelar y volver al listado -->
            <a href="ControladorCliente?accion=Listar" style="
                display: block;
                text-align: center;
                margin-top: 10px;
                padding: 10px;
                background-color: #f44336;
                color: white;
                text-decoration: none;
                border-radius: 4px;
            ">Cancelar</a>
        </form>
    </div>
</body>
</html>

