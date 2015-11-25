<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagos</title>
<style type="text/css">
body {
	background-color: #d6d6c2;
	text-align: center;
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

.cabeza_grilla {
	font-weight: bold;
	font-style: italic;
}

.contenido_grilla {
	font-family: "Courier New", Courier, monospace;
}

.table_grilla {
	border-spacing: 25px;
	border-style: solid;
	border-color: #c2c2a3;
	background-color: #fff;
}
</style>
</head>
<body>

	<form action="">
		<div align="center">
			<h1>Pagos</h1>
			<hr>
		</div>
		<table align="center">
			<tr>
				<td>Fecha Inicio</td>
				<td><input type="date" id="calFechaInicio" /></td>
				<td>Fecha Termino</td>
				<td><input type="date" id="calFechaTermino" /></td>
			</tr>
		</table>
		<br>
		<table align="center">
			<tr>
				<td><input type="button" value="Filtrar" id="btnFiltrar"
					style="width: 100px;" /></td>
				<td><input type="button" value="Cerrar" id="btnCerrar"
					style="width: 100px;" /></td>
			</tr>
		</table>
		<hr>
		<br>
		<table align="center" class="table_grilla">
			<tr class="cabeza_grilla">
				<td>N°Contrato</td>
				<td>F Contrato</td>
				<td>Cuota</td>
				<td>F Vencimiento</td>
				<td>Monto Cuota</td>
				<td>Estado</td>
			</tr>
			<tr class="contenido_grilla">
				<td>001</td>
				<td>25-11-2015</td>
				<td>48</td>
				<td>25-10-2015</td>
				<td>$400.000</td>
				<td>Pendiente</td>
			</tr>
		</table>
		<br>
		<table align="center">
		<tr>
		<td><input type="button" value="Imprimir" style="width: 100px;"/></td>
		<td><input type="button" value="Cerrar" style="width: 100px;"/></td>
		</tr>
		</table>
	</form>

</body>
</html>