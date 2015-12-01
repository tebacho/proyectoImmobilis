<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ingreso de Pago</title>
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

	<form align="center" action="#" autocomplete="on">
		<h1>Ingreso de Pagos</h1>
		<hr>
		<br>
		<table align="center">
			<tr>
				<td>N°Contrato</td>
				<td><input type="text" required="required"/></td>
				<td>Rut Cliente</td>
				<td><input type="text" required="required"/></td>
				<td><input type="submit" value="Buscar" style="width: 100px;" /></td>
			</tr>
		</table>
		<br>
		<hr>
		<br>
		<table align="center" class="table_grilla">
			<tr class="cabeza_grilla">
				<td>N°Contrato</td>
				<td>F.Contrato</td>
				<td>F.Vencimiento</td>
				<td>Cuota</td>
				<td>Estado</td>
				<td>Nombre</td>
				<td>A.Paterno</td>
				<td>A.Materno</td>
				<td>Rut</td>
			</tr>
			<tr class="contenido_grilla">
				<td>001</td>
				<td>28-11-2015</td>
				<td>28-12-2015</td>
				<td>$300.000</td>
				<td>Vencido</td>
				<td>Soila</td>
				<td>Concha</td>
				<td>De Piedra</td>
				<td>8.123.444-k</td>
			</tr>
		</table>
		<div algin="center">
		<br>
		<input type="submit" value="Pagar" style="width: 150px;"/>
		</div>
	</form>

</body>
</html>