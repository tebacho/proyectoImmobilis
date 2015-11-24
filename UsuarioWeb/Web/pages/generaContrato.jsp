<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Generar Contrato</title>

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

textarea:focus {
	background-color: #ffff99;
}

textarea {
	resize: none;
}
</style>

</head>

<body>
	<form>
		<div align="center">
			<h1>Generar Contrato</h1>
			<hr>
		</div>
		<div class="cabeza">Datos Usuario</div>
		<br>
		<!-- INICIO DATOS USUARIO -->
		<table align="center">
			<tr>
				<td>
					<table align="left">
						<tr>
							<td>Rut</td>
							<td><input required="required" /></td>
						<tr>
						<tr>
							<td>Apellido Paterno</td>
							<td><input required="required" /></td>
						</tr>
						<tr>
							<td>Telefono</td>
							<td><input required="required" /></td>
						</tr>
						<tr>
							<td>Fecha Nacimiento</td>
							<td><input required="required" placeholder="22-04-1985" /></td>
						</tr>
						<tr>
							<td>Region</td>
							<td><select></select></td>
						</tr>
						<tr>
							<td>Contraseña</td>
							<td><input type="password" required="required" /></td>
						</tr>
					</table>
				</td>
				<td>
					<table align="right">
						<tr>
							<td>Nombres</td>
							<td><input required="required" /></td>
						</tr>
						<tr>
							<td>Apellido Materno</td>
							<td><input required="required" /></td>
						</tr>
						<tr>
							<td>Correo</td>
							<td><input type="text" required="required"
								placeholder="correo@gmail.com" /></td>
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
							<td><input type="password" required="required" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- FIN DATOS USUARIO -->
		<br>
		<hr>
		<div class="cabeza">Datos Propiedad</div>
		<br>
		<!-- INICIO DATOS PROPIEDAD -->
		<table align="center">
			<tr>
				<td>
					<table align="left">
						<tr>
							<td>ID Propiedad</td>
							<td><input id="txtIdPropiedad" /></td>
						</tr>
						<tr>
							<td>Nombre Región</td>
							<td><input id="txtNombreRegion" /></td>
						</tr>
						<tr>
							<td>Tipo Propiedad</td>
							<td><input id="txtTipoPropiedad" /></td>
						</tr>
						<tr>
							<td>Precio</td>
							<td><input id="txtPrecio" /></td>
						</tr>
						<tr>
							<td>Disponible</td>
							<td><input id="txtDisponible" /></td>
						</tr>
						<tr>
							<td>Baño</td>
							<td><input id="txtBano" /></td>
						</tr>
						<tr>
							<td>Conjunto</td>
							<td><input id="txtConjunto" /></td>
						</tr>
						<tr>
							<td>Nivel</td>
							<td><input id="txtNivel" /></td>
						</tr>
					</table>
				</td>
				<td>
					<table align="right">
						<tr>
							<td>Nombre Comuna</td>
							<td><input id="txtNombreComuna" /></td>
						</tr>
						<tr>
							<td>Nombre Constructora</td>
							<td><input id="txtNombreConstructora" /></td>
						</tr>
						<tr>
							<td>Descripción</td>
							<td><input id="txtDescripcion" /></td>
						</tr>
						<tr>
							<td>Operación</td>
							<td><input id="txtOperacion" /></td>
						</tr>
						<tr>
							<td>Altura</td>
							<td><input id="txtAltura" /></td>
						</tr>
						<tr>
							<td>Dormitorio</td>
							<td><input id="txtDormitorio" /></td>
						</tr>
						<tr>
							<td>Edificio</td>
							<td><input id="txtEdificio" /></td>
						</tr>
						<tr>
							<td>Patente Comercial</td>
							<td><input id="txtPatenteComercial" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- FIN DATOS PROPIEDAD -->
		<br>
		<hr>
		<div class="cabeza">Seguro</div>
		<br>
		<!-- INICIO DATOS SEGURO -->
		<table align="center">
			<tr>
				<td>
					<table align="left">
						<tr>
							<td>ID Seguro</td>
							<td><input id="txtIdSeguro" /></td>
						</tr>
						<tr>
							<td>Valor</td>
							<td><input id="txtValor" /></td>
						</tr>
					</table>
				</td>
				<td>
					<table align="right">
						<tr>
							<td>Compañia</td>
							<td><input id="txtCompania" /></td>
						</tr>
						<tr>
							<td>Fecha</td>
							<td><input id="txtFecha" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<table align="center">
			<br>
			<tr>
				<td><textarea rows="10" cols="70">Ingrese un comentario aquí</textarea></td>
			</tr>
		</table>
		<table align="center">
			<tr>
				<td><input type="button" value="Confirmar"
					style="width: 100px;" /></td>
				<td><input type="button" value="Cancelar" style="width: 100px;" /></td>
			</tr>
		</table>
		<br><br>
	</form>

</body>

</html>