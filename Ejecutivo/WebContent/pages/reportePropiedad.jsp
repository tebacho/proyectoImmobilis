<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reporte Arriendos Propiedad</title>
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
			<h1>Reporte Arriendos Propiedad</h1>
			<hr>
		</div>
		<table align="center">
			<tr>
				<td>ID Propiedad</td>
				<td><input type="text" id="txtIdPropiedad" required="required"/></td>
				<td>Región</td>
				<td><select>
						<option>Selecione Región</option>
				</select></td>
			</tr>
			<tr>
				<td>Dirección</td>
				<td><input type="text" id="txtDireccion" required="required"/></td>
				<td>Comuna</td>
				<td><select>
						<option>Seleccione Comuna</option>
				</select></td>

			</tr>
			<tr>
				<td>Tipo Propiedad</td>
				<td><input type="text" id="txtTipoPropiedad" required="required"/></td>
			</tr>
		</table>
		<br>
		<table align="center">
			<tr>
				<td><input type="submit" value="Filtrar" style="width: 100px;" /></td>
			</tr>
		</table>
		<hr>
		<br>
		<table align="center" class="table_grilla">
			<tr class="cabeza_grilla">
				<td>N°Contrato</td>
				<td>F Contrato</td>
				<td>Monto</td>
				<td>F Vencimiento</td>
				<td>Estado</td>
				<td>Nombre</td>
				<td>A Paterno</td>
				<td>A Materno</td>
				<td>Rut</td>
			</tr>
			<tr>
			</tr>
			<tr class="contenido_grilla">
				<td>001</td>
				<td>24-11-2015</td>
				<td>$400.000</td>
				<td>24-12-2015</td>
				<td>Pendiente</td>
				<td>Silvia</td>
				<td>Saint</td>
				<td>Electra</td>
				<td>16.111.222-k</td>
			</tr>
		</table>
		<br>
		<table align="center">
			<tr>
				<td><input type="button" onclick='window:print();' value="Imprimir" style="width: 100px;" /></td>
				<td><input type="button" value="Cerrar" style="width: 100px;" /></td>
			</tr>
		</table>
	</form>

</body>
</html>


