
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@page import="java.util.Iterator"%>

<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Datos Usuario</title>
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

	<form>
		<div align="center">
			<h1>Actualizar Datos</h1>
			<hr>
		</div>
		<table align="center">
			<tr>
				<td>
					<table align="left">
						<tr>
							<td>Rut</td>
							<td><input required="required" type="text"/></td>
						<tr>
						<tr>
							<td>Apellido Paterno</td>
							<td><input required="required" type="text"/></td>
						</tr>
						<tr>
							<td>Telefono</td>
							<td><input required="required" type="text"/></td>
						</tr>
						<tr>
							<td>Fecha Nacimiento</td>
							<td><input required="required" type="date" /></td>
						</tr>
						<tr>
							<td>Region</td>
							<td><select name="cbxRegion" class="field" id="region">
									<logic:iterate name="actualizarInformacionFB" property="regiones"
										id="regiones">
										<bean:define name="regiones" id="nRegion" property="value" />
										<option value='<bean:write name="regiones" property="key" />'>
											<bean:write name="nRegion" property="nombreRegion" />
										</option>

									</logic:iterate>
							</select></td>
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
							<td><input required="required" type="text"/></td>
						</tr>
						<tr>
							<td>Apellido Materno</td>
							<td><input required="required" type="text"/></td>
						</tr>
						<tr>
							<td>Correo</td>
							<td><input type="text" required="required"
								placeholder="correo@gmail.com" /></td>
						</tr>
						<tr>
							<td>Sexo</td>
							<td>
							<select>
							<option></option>
							</select>
							</td>
						<tr>
						<tr>
							<td>Comuna</td>
							<td><select name="cbxRegion" class="field" id="region">
									<logic:iterate name="actualizarInformacionFB" property="comunas"
										id="comunas">
										<bean:define name="comunas" id="nComuna" property="value" />
										<option value='<bean:write name="comunas" property="key" />'>
											<bean:write name="nComuna" property="nombreComuna" />
										</option>
									</logic:iterate>
							</select></td>
						</tr>
						<tr>
							<td>Repita Contraseña</td>
							<td><input type="password" required="required" /></td>
						</tr>
					</table>
				</td>
			</tr>
			<table align="center">
				<br>
				<br>
				<tr>
					<td><input type="submit" value="Actualizar"
						style="width: 100px" /></td>
					<td><input type="button" style="width: 100px" value="Salir" /></td>
				</tr>
			</table>
		</table>
	</form>

</body>
</html>