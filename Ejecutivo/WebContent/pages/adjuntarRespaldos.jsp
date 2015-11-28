<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adjuntar Respaldos</title>
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
</style>
</head>
<body>
	<form action="">
		<div align="center">
			<h1>Adjuntar Respaldos</h1>
			<hr>
		</div>
		<table align="center">
			<tr>
				<td>
					<table align="left">
						<tr>
							<td>ID Contrato</td>
							<td><input type="text" id="txtIdContrato" required="required"/></td>
						</tr>
						<tr>
							<td>Nombre</td>
							<td><input type="text" id="txtNombre" required="required"/></td>
						</tr>
						<tr>
							<td>Apellido Materno</td>
							<td><input type="text" id="txtMaterno" required="required"/></td>
						</tr>
						<tr>
							<td>Tipo Adjunto</td>
							<td><select>
									<option></option>
							</select></td>
						</tr>
					</table>
				</td>
				<td>
					<table align="right">
						<tr>
							<td>Fecha Contrato</td>
							<td><input type="date" id="txtFechaContrato" required="required"/></td>
						</tr>
						<tr>
							<td>Apellido Paterno</td>
							<td><input text="text" id="txtPaterno" required="required"/></td>
						</tr>
						<tr>
							<td>Rut</td>
							<td><input text="text" id="txtRut" required="required"/></td>
						</tr>
						<tr>
							<td>Adjuntar</td>
							<td><input type="file" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<table align="center">
			<tr>
				<td><input type="submit" value="Confirmar"
					style="width: 100px;" /></td>
				<td><input type="button" value="Salir" style="width: 100px;" /></td>
			</tr>
		</table>

	</form>
</body>
</html>