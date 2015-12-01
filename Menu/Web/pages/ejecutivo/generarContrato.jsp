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
	<form name="form1" action="#" autocomplete="on">
		<div align="center" action="#" autocomplete="on">
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
							<td><input type="text" required="required" /></td>
						<tr>
						<tr>
							<td>Apellido Paterno</td>
							<td><input type="text" required="required" /></td>
						</tr>
						<tr>
							<td>Telefono</td>
							<td><input type="tel" required="required" /></td>
						</tr>
						<tr>
							<td>Fecha Nacimiento</td>
							<td><input type="text" placeholder="dd-mm-aaaa" required="required" /></td>
						</tr>
						<tr>
							<td>Region</td>
							<td><select>
									<option></option>
							</select></td>
						</tr>
						<tr>
							<td>Comuna</td>
							<td><select>
									<option></option>
							</select></td>

						</tr>
					</table>
				</td>
				<td>
					<table align="right">
						<tr>
							<td>Nombres</td>
							<td><input type="text" required="required" /></td>
						</tr>
						<tr>
							<td>Apellido Materno</td>
							<td><input type="text" required="required" /></td>
						</tr>
						<tr>
							<td>Correo</td>
							<td><input type="email" name="email" required="required"
								placeholder="correo@gmail.com" /></td>
						</tr>
						<tr>
							<td>Sexo</td>
							<td><select>
									<option></option>
							</select></td>
						<tr>
						<tr>


							<td>Contraseña</td>
							<td><input type="password" name="password" id="password"
								required></td>
						</tr>
						<tr>
							<td>Repita Contraseña</td>
							<td><input type="password" name="password" id="password2"
								required></td>
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
							<td><input type="text" required="required"
								id="txtIdPropiedad" /></td>
						</tr>
						<tr>
							<td>Región</td>
							<td><select>
									<option></option>
							</select></td>
						</tr>
						<tr>
							<td>Tipo Propiedad</td>
							<td><input type="text" required="required"
								id="txtTipoPropiedad" /></td>
						</tr>
						<tr>
							<td>Precio</td>
							<td><input type="text" required="required" id="txtPrecio" /></td>
						</tr>
						<tr>
							<td>Disponible</td>
							<td><select>
									<option></option>
							</select></td>
						</tr>
						<tr>
							<td>Baño</td>
							<td><input type="text" required="required" id="txtBano" /></td>
						</tr>
						<tr>
							<td>Conjunto</td>
							<td><input type="text" required="required" id="txtConjunto" /></td>
						</tr>
						<tr>
							<td>Nivel</td>
							<td><input type="text" required="required" id="txtNivel" /></td>
						</tr>
					</table>
				</td>
				<td>
					<table align="right">
						<tr>
							<td>Comuna</td>
							<td><select>
									<option></option>
							</select></td>
						</tr>
						<tr>
							<td>Constructora</td>
							<td><input type="text" required="required"
								id="txtNombreConstructora" /></td>
						</tr>
						<tr>
							<td>Descripción</td>
							<td><input type="text" required="required"
								id="txtDescripcion" /></td>
						</tr>
						<tr>
							<td>Operación</td>
							<td><input type="text" required="required" id="txtOperacion" /></td>
						</tr>
						<tr>
							<td>Altura</td>
							<td><input type="text" required="required" id="txtAltura" /></td>
						</tr>
						<tr>
							<td>Dormitorio</td>
							<td><input type="text" required="required"
								id="txtDormitorio" /></td>
						</tr>
						<tr>
							<td>Edificio</td>
							<td><input type="text" required="required" id="txtEdificio" /></td>
						</tr>
						<tr>
							<td>Patente Comercial</td>
							<td><input type="text" required="required"
								id="txtPatenteComercial" /></td>
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
							<td><input required="required" type="text" id="txtIdSeguro" /></td>
						</tr>
						<tr>
							<td>Valor</td>
							<td><input type="text" required="required" id="txtValor" /></td>
						</tr>
					</table>
				</td>
				<td>
					<table align="right">
						<tr>
							<td>Fecha</td>
							<td><input type="text" placeholder="dd-mm-aaaa" required="required" id="txtFecha" /></td>
						</tr>
						<tr>
							<td>Compañia</td>
							<td><select>
									<option>Seleccione Aseguradora</option>
									<option>Aseguradora A</option>
									<option>Aseguradora B</option>
							</select></td>
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
				<td><input type="submit" value="Confirmar"
					style="width: 100px;" onclick="comparar(clave1,clave2)" /></td>
				<td><input type="button" value="Cancelar" style="width: 100px;" /></td>
			</tr>
		</table>
		<br> <br>
	</form>

	<script type="text/javascript">
		var password, password2;

		password = document.getElementById('password');
		password2 = document.getElementById('password2');

		password.onchange = password2.onkeyup = passwordMatch;

		function passwordMatch() {
			if (password.value !== password2.value)
				password2.setCustomValidity('Las contraseñas no coinciden.');
			else
				password2.setCustomValidity('');
		}
	</script>

</body>

</html>