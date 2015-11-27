<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<head>

<link rel="stylesheet" type="text/css" href="js/shadowbox/shadowbox.css" />
<link rel="stylesheet" type="text/css" href="style/busqueda.css" />
<script type="text/javascript" src="js/shadowbox/shadowbox.js"></script>
<script src="js/jquery-1.7.1.min.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario Reserva</title>

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

.cabeza {
	text-align: center;
	background-color: #c2c2a3;
	font-weight: bold;
	font-style: italic;
	font-size: 20px;
}

.table_iz {
	text-align: left;
}

.terminos {
	height: 100px;
}

a {
	text-decoration: none;
	color: red;
}
a:HOVER {
	color: white;
	background-color: red;
	font-size: 30px;
}
</style>

</head>
<body>

	<form action="">
		<div align="center">
			<h1>Formulario Reserva Propiedad</h1>
			<hr>
		</div>
		<div class="cabeza">Datos Propiedad</div>
		<br>
		<!-- INICIO DATOS PROPIEDAD -->
		<table align="center">
			<tr>
				<td>
					<table class="table_iz">
						<tr>
							<td>ID Propiedad</td>
							<td><input type="text" id="txtIdPropiedad" /></td>
						</tr>
						<tr>
							<td>Nombre Región</td>
							<td><input typ="text" id="txtNombreRegion" /></td>
						</tr>
						<tr>
							<td>Tipo Propiedad</td>
							<td><input type="text" id="txtTipoPropiedad" /></td>
						</tr>
						<tr>
							<td>Descripción</td>
							<td><input type="text" id="txtDescripcion" /></td>
						</tr>
						<tr>
							<td>Operación</td>
							<td><input type="text" id="txtOperacion" /></td>
						</tr>
						<tr>
							<td>Altura</td>
							<td><input type="text" id="txtAltura" /></td>
						</tr>
						<tr>
							<td>Dormitorio</td>
							<td><input type="text" id="txtDormitorio" /></td>
						</tr>
						<tr>
							<td>Edificio</td>
							<td><input type="text" id="txtEdificio" /></td>
						</tr>
						<tr>
							<td>Patente Comercial</td>
							<td><input type="text" id="txtPatenteComercial" /></td>
						</tr>
					</table>
				</td>
				<td>
					<table class="table_iz">
						<tr>
							<td>Nombre Comuna</td>
							<td><input type="text" id="txtNombreComuna" /></td>
						</tr>
						<tr>
							<td>Dirección</td>
							<td><input type="text" id="txtDireccion" /></td>
						</tr>
						<tr>
							<td>Nombre Constructora</td>
							<td><input type="text" id="txtNombreConstructora" /></td>
						</tr>
						<tr>
							<td>Precio</td>
							<td><input type="text" id="txtPrecio" /></td>
						</tr>
						<tr>
							<td>Disponible</td>
							<td><input type="text" id="txtDisponible" /></td>
						</tr>
						<tr>
							<td>Baño</td>
							<td><input type="text" id="txtBano" /></td>
						</tr>
						<tr>
							<td>Conjunto</td>
							<td><input type="text" id="txtConjunto" /></td>
						</tr>
						<tr>
							<td>Nivel</td>
							<td><input type="text" id="txtNivel" /></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- FIN DATOS PROPIEDAD -->
		<br>
		<hr>
		<div align="center" class="cabeza">Datos Usuario</div>
		<br>
		<!-- INICIO DATOS USUARIO -->
		<table align="center">
			<tr>
				<td>
					<table class="table_iz">
						<tr>
							<td>Nombre</td>
							<td><input type="text" id="txtNombre" /></td>
						</tr>
						<tr>
							<td>Apellido Materno</td>
							<td><input type="text" id="txtMaterno" /></td>
						</tr>
						<tr>
							<td>Rut</td>
							<td><input type="text" id="txtRut" /></td>
						</tr>
						<tr>
							<td>E-mail</td>
							<td><input type="text" id="txtEmail" /></td>
						</tr>
						<tr>
							<td>Telefono</td>
							<td><input type="text" id="txtTelefono" /></td>
						</tr>
						<tr>
							<td>Región</td>
							<td><select id="cbxRegiones"><option>Seleccione
										Región</option></select></td>
						</tr>

					</table>
				</td>
				<td>
					<table class="table_iz">
						<tr>
							<td>Apellido Paterno</td>
							<td><input type="text" id="txtPaterno" /></td>
						</tr>
						<tr>
							<td>Fecha Nacimiento</td>
							<td><input type="date" id="txtFechaNacimiento" /></td>
						</tr>
						<tr>
							<td>Sexo</td>
							<td><input type="text" id="txtSexo" /></td>
						</tr>
						<tr>
							<td>Password</td>
							<td><input type="password" id="txtPassword" /></td>
						</tr>
						<tr>
							<td>Repita Clave</td>
							<td><input type="password" id="txtPassIngreso" /></td>
						</tr>
						<tr>
							<td>Comuna</td>
							<td><select><option>Seleccione Comuna</option></select></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- FIN DATOS USUARIO -->
		<br>
		<hr>
		<div align="center" class="cabeza">Terminos y Condiciones de Uso</div>
		<br>
		<!-- INICIO TERMINO Y CONDICIONES DE USO -->
		<div class="terminos">
			<a href="#" id="txtCondicionesDeUso">Click para ir a Terminos y
				condiciones de uso.</a>
		</div>
		<!-- FIN TERMINO Y CONDICIONES DE USO -->
	</form>

</body>