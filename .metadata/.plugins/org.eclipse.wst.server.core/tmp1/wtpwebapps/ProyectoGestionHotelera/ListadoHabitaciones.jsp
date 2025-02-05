<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Habitacion"%>


<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Listado de Habitaciones</title>
<link rel="stylesheet" href="estilos/lis-habitacion.css">

<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	background-color: #121212;
	color: #ffffff;
}

.contenedor {
	display: flex;
	width: 90%;
	max-width: 1600px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.5);
	border-radius: 8px;
	overflow: hidden;
}

.izqUsuario {
	background-color: #1e1e1e;
	width: 30%;
	padding: 20px;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: space-between;
}

.imgUsu-nameUsu {
	display: flex;
	flex-direction: column;
	align-items: center;
}

.imgUsu-nameUsu img {
	border-radius: 50%;
	margin-bottom: 10px;
}

.imgUsu-nameUsu h2 {
	color: #ffcc00;
}

.actionsUsu a, .listados a {
	display: block;
	width: 100%;
	max-width: 300px;
	padding: 15px;
	margin: 10px 0;
	text-align: center;
	text-decoration: none;
	border-radius: 4px;
	background-color: #ffcc00;
	color: #000;
	font-size: 16px;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

.actionsUsu a:hover, .listados a:hover {
	background-color: gray;
}

.derAcciones {
	background-color: #2e2e2e;
	width: 70%;
	padding: 20px;
	display: flex;
	flex-direction: column;
	justify-content: flex-start;
	align-items: center;
}

.listados {
	width: 100%;
	display: flex;
	flex-direction: row;
	align-items: center;
	gap: 30px;
}

.listado-clientes {
	width: 100%;
	margin-top: 0;
	display: flex;
	flex-direction: column;
	gap: 10px;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin: 0;
	font-size: 18px;
	min-width: 600px;
	background-color: #3e3e3e;
}

th, td {
	padding: 12px 15px;
	border: 1px solid #ddd;
}

th {
	background-color: #ffcc00;
	color: #000;
	text-align: left;
}

td {
	color: #fff;
}

.btn-editar, .btn-eliminar {
	padding: 8px 12px;
	margin-right: 5px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

.btn-editar {
	background-color: #4CAF50;
	color: rgb(0, 0, 0);
}

.btn-eliminar {
	background-color: #f44336;
	color: rgb(0, 0, 0);
}

.btn-editar:hover, .btn-eliminar:hover {
	opacity: 0.8;
}
</style>
</head>
<body>
	<div class="contenedor">
		<div class="izqUsuario">
			<div class="imgUsu-nameUsu">
				<img src="images/usuario.1.png" alt="Usuario" width="200px">
				<h2>Usuario: Kevin Quintero</h2>
			</div>
			<div class="actionsUsu">
				<a href="RegistroReserva.jsp">Registrar Reserva</a> <a
					href="RegistroCliente.jsp">Registrar Cliente</a> <a
					href="RegistroHabitacion.jsp">Registrar Habitación</a>
			</div>
		</div>

		<div class="derAcciones">
			<div class="listados">
				<a href="ControladorReserva?accion=Listar">Listado de Reservas</a> <a
					href="ControladorCliente?accion=Listar">Listado de Clientes</a> <a
					href="ControladorHabitacion?accion=Listar">Listado de
					Habitaciones</a>
			</div>

			<div class="listado-habitaciones">
				<h1>Listado de Habitaciones</h1>
				<table border="2" align="center">
					<thead>
						<tr>
							<th>ID Habitación</th>
							<th>Tipo de Habitación</th>
							<th>Precio</th>
							<th>Comodidades</th>
							<th>Estado</th>
							<th colspan="2" align="center">Acciones</th>
						</tr>
					</thead>
					<tbody>
						<%
						List<Habitacion> listadoHabitaciones = (List<Habitacion>) request.getAttribute("listadoHabitaciones");
						if (listadoHabitaciones != null && !listadoHabitaciones.isEmpty()) {
							for (Habitacion habitacion : listadoHabitaciones) {
						%>
						<tr>
							<td><%=habitacion.getID_Habitacion()%></td>
							<td><%=habitacion.getTipohabitacion().getNom_TipoH()%></td>
							<td><%=habitacion.getPrecio()%></td>
							<td><%=habitacion.getComodidades()%></td>
							<td><%=habitacion.getEstadohabitacion().getNom_EstadoH()%></td>

							<td><a class="btn-eliminar"
								href="ControladorHabitacion?accion=Eliminar&id=<%=habitacion.getID_Habitacion()%>">Eliminar</a></td>
						<td>
    <a class="btn-editar" href="ControladorHabitacion?accion=Actualizar&action=show&id=<%=habitacion.getID_Habitacion()%>">Actualizar</a>
</td>

						</tr>
						<%
						}
						} else {
						%>
						<tr>
							<td colspan="7" align="center">No hay habitaciones
								registradas</td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
