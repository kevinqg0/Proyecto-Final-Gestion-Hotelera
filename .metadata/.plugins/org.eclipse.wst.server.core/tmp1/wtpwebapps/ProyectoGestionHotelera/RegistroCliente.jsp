<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Cliente</title>
    
    <link rel="stylesheet" href="estilos/registro.css">
</head>
<body>
    <h1>Registro de Clientes</h1>
    <div class="box-registro">
        <form action="ControladorCliente" method="post">
            
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nom" required>

            <label for="apellido">Apellido:</label>
            <input type="text" id="apellido" name="ape" required>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>

            <label for="dni">DNI:</label>
            <input type="text" id="dni" name="dni" required>

            <label for="telefono">Tel�fono:</label>
            <input type="tel" id="telefono" name="telf" required>

            <button type="submit">Registrar</button>
        </form>
    </div>
</body>
</html>

