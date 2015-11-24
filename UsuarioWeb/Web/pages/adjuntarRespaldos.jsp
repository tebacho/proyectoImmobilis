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

.image-upload>input {
	display: none;
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
							<td><input id="txtIdContrato" /></td>
						</tr>
						<tr>
							<td>Nombre</td>
							<td><input id="txtNombre" /></td>
						</tr>
						<tr>
							<td>Apellido Materno</td>
							<td><input id="txtMaterno" /></td>
						</tr>
						<tr>
							<td>Tipo Adjunto</td>
							<td><select></select></td>
						</tr>
					</table>
				</td>
				<td>
					<table align="right">
						<tr>
							<td>Fecha Contrato</td>
							<td><input id="txtFechaContrato" /></td>
						</tr>
						<tr>
							<td>Apellido Paterno</td>
							<td><input id="txtPaterno" /></td>
						</tr>
						<tr>
							<td>Rut</td>
							<td><input id="txtRut" /></td>
						</tr>
						<tr>
							<td>Adjunto</td>
							<td>
								<div class="image-upload">
									<label for="file-input"> 
									<img alt="" src="images/Adjuntar.png">
									</label> 
									<input id="file-input" type="file" width="92px" height="28px"/>
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>