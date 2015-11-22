<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>registrase</title>
<style type="text/css">
body{background-color: #d6d6c2;}
h1{
font-family: "Comic Sans MS", cursive, sans-serif;
text-shadow: 2px 2px 4px #000000;
color:white;
}
</style>
</head>
<body>
	<form>
	<div align="center">
	<h1>Registro</h1>
	<hr>
	</div>
		<table align="center">
			<tr>
				<td>
					<table align="left">
						<tr>
							<td>Rut</td>
							<td><input required="required"/></td>
						<tr>
						<tr>
							<td>Apellido Paterno</td>
							<td><input required="required"/></td>
						</tr>
						<tr>
							<td>Telefono</td>
							<td><input required="required"/></td>
						</tr>
						<tr>
							<td>Fecha Nacimiento</td>
							<td><input required="required" placeholder="22-04-1985"/></td>
						</tr>
						<tr>
							<td>Region</td>
							<td><select></select></td>
						</tr>
						<tr>
							<td>Contraseña</td>
							<td><input type="password" required="required"/></td>
						</tr>
					</table>
				</td>
				<td>
					<table align="right">
						<tr>
							<td>Nombres</td>
							<td><input required="required"/></td>
						</tr>
						<tr>
							<td>Apellido Materno</td>
							<td><input required="required"/></td>
						</tr>
						<tr>
							<td>Correo</td>
							<td><input type="text" required="required" placeholder="correo@gmail.com"/></td>
						</tr>
						<tr>
							<td>Sexo</td>
							<td><select></select></td>
						<tr>
						<tr>
							<td>Comuna</td>
							<td><select></select></td>
						</tr>
						<tr>
							<td>Repita Contraseña</td>
							<td><input type="password" required="required"/></td>
						</tr>
					</table>
				</td>
			</tr>
			<table align="center">
				<br>
				<br>
				<tr>
					<td><input type="submit" value="Registrar"
						style="width: 100px" /></td>
					<td><input type="button" style="width: 100px" value="Salir" /></td>
				</tr>
			</table>
			<table align="center">
				<tr>
					<td>
						<p class="change_link">
							¿Ya estas registrado? <a href="http://localhost:8080/UsuarioWeb/loginAction.do?method=mostrarFormulario">Ir a Ingreso</a>
						</p>
					<td>
				</tr>
			</table>
		</table>
	</form>
</body>
</html>