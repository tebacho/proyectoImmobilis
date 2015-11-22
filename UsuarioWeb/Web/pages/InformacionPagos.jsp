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
table{border-spacing: 25px;}
</style>
</head>
<body>

	<form align="center" action="#" autocomplete="on">
		<h1>Historial de Pagos</h1>
		<hr>
		<br>
		<div>
			<label>Desde</label> <input type="text" placeholder="02-12-2014" /> <label>Hasta</label>
			<input type="text" placeholder="02-12-2015" /> <input type="button"
				value="Buscar" style="width: 100px" /> <input type="button"
				value="Cancelar" style="width: 100px" />
		</div>
		<br>
		<hr>
		<table classe="grilla" align="center">
		<tr>
		<td>N°Contrato</td>
		<td>Fecha Contrato</td>
		<td>Cuota</td>
		<td>Fecha Vencimiento</td>
		<td>Monto Cuota</td>
		<td>Estado</td>
		</tr>
		<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		</tr>
		</table>
		<div>
		<input type="button" value="Imprimir" style="width: 100px"/>
		<input type="button" value="Cerrar" style="width: 100px"/>
		</div>
	</form>

</body>
</html>