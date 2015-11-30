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
						<bean:define id="vPropiedades" name="formularioReservaFB"
							property="propiedad" />
						<tr>
							<td>ID Propiedad</td>
							<td><input type="text" id="txtIdPropiedad"
								value='<bean:write name="vPropiedades" property="idPropiedad" format="#" />' /></td>
						</tr>
						<tr>
							<td>Nombre Región</td>
							<td><input typ="text" id="txtNombreRegion"
								value='<bean:write name="vPropiedades" property="nombreRegion"  />' /></td>
						</tr>
						<tr>
							<td>Tipo Propiedad</td>
							<td><input type="text" id="txtTipoPropiedad"
								value='<bean:write name="vPropiedades" property="tipoPropiedad"  />' /></td>
						</tr>
						<tr>
							<td>Descripción</td>
							<td><input type="text" id="txtDescripcion"
								value='<bean:write name="vPropiedades" property="descripcion" />' /></td>
						</tr>
						<tr>
							<td>Operación</td>
							<td><input type="text" id="txtOperacion"
								value='<bean:write name="vPropiedades" property="tipoOperacion"  />' /></td>
						</tr>
						<tr>
							<logic:present name="vPropiedades" property="altura">
								<td>Altura</td>
								<td><input type="text" id="txtAltura"
									value='<bean:write name="vPropiedades" property="altura" format="#" />' /></td>
							</logic:present>
							<logic:notPresent name="vPropiedades" property="altura">
								<td>-</td>
								<td><input type="text" id="txtDormitorio" value="-" /></td>
							</logic:notPresent>
						</tr>
						<tr>
							<logic:present name="vPropiedades" property="dormitorios">
								<td>Dormitorio</td>
								<td><input type="text" id="txtDormitorio"
									value='<bean:write name="vPropiedades" property="dormitorios" format="#" />' /></td>
							</logic:present>
							<logic:notPresent name="vPropiedades" property="dormitorios">
								<td>-</td>
								<td><input type="text" id="txtDormitorio" value="-" /></td>
							</logic:notPresent>
						</tr>
						<tr>
							<logic:present name="vPropiedades" property="edificio">
								<td>Edificio</td>
								<td><input type="text" id="txtEdificio"
									value='<bean:write name="vPropiedades" property="edificio" />' /></td>
							</logic:present>
							<logic:notPresent name="vPropiedades" property="edificio">
								<td>-</td>
								<td><input type="text" id="txtDormitorio" value="-" /></td>
							</logic:notPresent>
						</tr>
						<tr>
							<logic:present name="vPropiedades" property="patenteComercial">
								<td>Patente Comercial</td>
								<td><input type="text" id="txtPatenteComercial"
									value='<bean:write name="vPropiedades" property="patenteComercial" format="#" />' /></td>
							</logic:present>
							<logic:notPresent name="vPropiedades" property="patenteComercial">
								<td>-</td>
								<td><input type="text" id="txtDormitorio" value="-" /></td>
							</logic:notPresent>
						</tr>
					</table>
				</td>
				<td>
					<table class="table_iz">
						<tr>
							<td>Nombre Comuna</td>
							<td><input type="text" id="txtNombreComuna"
								value='<bean:write name="vPropiedades" property="nombreComuna" />' /></td>
						</tr>
						<tr>
							<td>Dirección</td>
							<td><input type="text" id="txtDireccion"
								value='<bean:write name="vPropiedades" property="direccion" />' /></td>
						</tr>
						<tr>
							<td>Nombre Constructora</td>
							<td><input type="text" id="txtNombreConstructora"
								value='<bean:write name="vPropiedades" property="nombreConstructora" />' />
							</td>
						</tr>
						<tr>
							<td>Precio</td>
							<td><input type="text" id="txtPrecio"
								value='<bean:write name="vPropiedades" property="precioUF" format="#"/>' /></td>
						</tr>
						<tr>
							<td>Disponible</td>
							<td><input type="text" id="txtDisponible"
								value='<bean:write name="vPropiedades" property="disponible" />' /></td>
						</tr>
						<tr>
							<logic:present name="vPropiedades" property="bannos">
								<td>Baño</td>
								<td><input type="text" id="txtBano"
									value='<bean:write name="vPropiedades" property="bannos" format="#" />' /></td>
							</logic:present>
							<logic:notPresent name="vPropiedades" property="bannos">
								<td>-</td>
								<td><input type="text" id="txtDormitorio" value="" /></td>
							</logic:notPresent>
						</tr>
						<tr>
							<logic:present name="vPropiedades" property="conjunto">
								<td>Conjunto</td>
								<td><input type="text" id="txtConjunto"
									value='<bean:write name="vPropiedades" property="conjunto" />' /></td>
							</logic:present>
							<logic:notPresent name="vPropiedades" property="conjunto">
								<td>-</td>
								<td><input type="text" id="txtDormitorio" value="-" /></td>
							</logic:notPresent>
						</tr>
						<tr>
							<logic:present name="vPropiedades" property="nivel">
								<td>Nivel</td>
								<td><input type="text" id="txtNivel"
									value='<bean:write name="vPropiedades" property="nivel" format="#" />' /></td>
							</logic:present>
							<logic:notPresent name="vPropiedades" property="nivel">
								<td>-</td>
								<td><input type="text" id="txtDormitorio" value="-" /></td>
							</logic:notPresent>
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
			<bean:define id="cliente" name="formularioReservaFB"
				property="cliente" />
			<tr>
				<td>
					<table class="table_iz">
						<tr>
							<td>Nombre</td>
							<td><input type="text" id="txtNombre"
								value='<bean:write name="cliente" property="nombre" />' /></td>
						</tr>
						<tr>
							<td>Apellido Materno</td>
							<td><input type="text" id="txtMaterno"
								value='<bean:write name="cliente" property="materno" />' /></td>
						</tr>
						<tr>
							<td>Rut</td>
							<td><input type="text" id="txtRut"
								value='<bean:write name="cliente" property="rut" />' /></td>
						</tr>
						<tr>
							<td>E-mail</td>
							<td><input type="text" id="txtEmail"
								value='<bean:write name="cliente" property="eMail" />' /></td>
						</tr>
						<tr>
							<td>Telefono</td>
							<td><input type="text" id="txtTelefono"
								value='<bean:write name="cliente" property="telefono" />' /></td>
						</tr>
						<tr>
							<td>Región</td>
							<td><html:select name="formularioReservaFB"
									property="regionSelect.codigoRegion">
									<html:option value="0">Region</html:option>
									<html:optionsCollection name="formularioReservaFB"
										property="listRegiones" label="nombreRegion"
										value="codigoRegion" />
								</html:select>
							<td>
						</tr>

					</table>
				</td>
				<td>
					<table class="table_iz">
						<tr>
							<td>Apellido Paterno</td>
							<td><input type="text" id="txtPaterno"
								value='<bean:write name="cliente" property="paterno" />' /></td>
						</tr>
						<tr>
							<td>Fecha Nacimiento</td>
							<td><input type="date" id="txtFechaNacimiento"
								value='<bean:write name="cliente" property="fechaNacimientoString" />' /></td>
						</tr>
						<tr>
							<td>Sexo</td>
							<td><input type="text" id="txtSexo"
								value='<bean:write name="cliente" property="sexo" />' /></td>
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
							<td><html:select name="formularioReservaFB"
									property="comunaSelect.codigoComuna">
									<html:option value="0">Region</html:option>
									<html:optionsCollection name="formularioReservaFB"
										property="listComunas" label="nombreComuna"
										value="codigoComuna" />
								</html:select></td>
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