<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Historial de Pagos Usuario</title>
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

table {
	border-spacing: 25px;
	border-style: solid;
	border-color: #c2c2a3;
	background-color: #fff;
}

#cabeza_grilla {
	font-weight: bold;
	font-style: italic;
}
</style>
</head>
<body>

	<form align="center" action="#" autocomplete="on">
		<h1>Historial de Pagos</h1>
		<hr>
		<br>
		<div>
			<label>Desde</label> <input type="date" /> <label>Hasta</label> <input
				type="date" /> <input type="submit" value="Buscar"
				style="width: 100px" />
		</div>
		<br>
		<hr>
		<table classe="grilla" align="center" width="600px">
			<tr id="cabeza_grilla">
				<td>N°Contrato</td>
				<td>Fecha Contrato</td>
				<td>Cuota</td>
				<td>Fecha Vencimiento</td>
				<td>Monto Cuota</td>
				<td>Estado</td>
			</tr>
			<tr>
				<td>0001</td>
				<td>22-11-2015</td>
				<td>12</td>
				<td>22-12-2015</td>
				<td>$400.000</td>
				<td>Pagado</td>
			</tr>
		</table>
		<div>
			<br> <input type="button" onclick="window:print();"
				value="Imprimir" style="width: 100px" /> <input type="button"
				value="Cerrar" style="width: 100px" />
		</div>
	</form>

</body>
</html>