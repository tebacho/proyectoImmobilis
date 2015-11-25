<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reserva Ok</title>
<style type="text/css">
body {
	background-color: #d6d6c2;
}

h1 {
	font-family: "Comic Sans MS", cursive, sans-serif;
	text-shadow: 2px 2px 4px #000000;
	color: white;
}

input:focus {
	background-color: #ffff99;
}

select:hover {
	background-color: #ffff99;
}

.cabeza {
	text-align: center;
	background-color: #c2c2a3;
	font-weight: bold;
	font-style: italic;
	font-size: 20px;
}

.fondo {
	background-color: white;
}

.a1 {
	font-style: italic;
	font-weight: bold;
}

label {
	font-family: "Courier New", Courier, monospace;
}
</style>
</head>
<body>

	<div>
		<div align="center">
			<h1>Reserva Ok</h1>
			<hr>
			<br>
		</div>
		<div class="cabeza">Datos Cliente</div>
		<br>
		<div class="fondo">
			<table align="center">
				<tr>
					<td>
						<table>
							<tr>
								<td class="a1">Rut</td>
								<td><label id="txtRut">18.111.222-k</label></td>
							</tr>
							<tr>
								<td class="a1">Apellido Paterno</td>
								<td><label id="txtPaterno">Hubert</label></td>
							</tr>
						</table>
					</td>
					<td>
						<table>
							<tr>
								<td class="a1">Nombre</td>
								<td><label id="txtNombre">Maria</label></td>
							</tr>
							<tr>
								<td class="a1">Apellido Materno</td>
								<td><label id="txtApellidoMaterno">Osandon</labe></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
		<br>
		<hr>
		<div class="cabeza">Datos Reserva</div>
		<br>
		<div class="fondo">
			<table align="center">
				<tr>
					<td>
						<table>
							<tr>
								<td class="a1">ID Reserva</td>
								<td><label id="txtIdReserva">001</label></td>
							</tr>
							<tr>
								<td class="a1">ID Propiedad</td>
								<td><label id="txtIdPropiedad">223344</label></td>
							</tr>
							<tr>
								<td class="a1">Nombre Región</td>
								<td><label id="txtNombreRegion">Metropolitana</label></td>
							</tr>
						</table>
					</td>
					<td>
						<table>
							<tr>
								<td class="a1">Fecha Reserva</td>
								<td><label id="txtFechaReserva">25-11-2015</label></td>
							</tr>
							<tr>
								<td class="a1">Nombre Comuna</td>
								<td><label id="txtNombreComuna">Vitacumbia</label></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
		<hr>
		<br>
		<div align="center">
			<input type="button" value="OK" style="width: 100px;">
		</div>
	</div>

</body>
</html>