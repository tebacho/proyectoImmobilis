
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@page import="java.util.Iterator"%>

<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="style/busqueda_1.css" />
<script src="js/jquery-1.7.1.min.js" type="text/javascript"></script>
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
<script type="text/javascript">
	function actualizar() {
		var params = getData();
		alert(params);
		$.ajax({
	        type:    "POST",
	        url:     "actualizarInformacionAction.do?",
	        data:    "method=actualizacionInformacionUsuario"+params,
	        
	        success: function(data){
				if(""!=data){
					alert("Usuario modificado");
					parent.location.reload();
					
				}else{
					
					alert("Error de modificacion.");
					
				}
	        }
		});
	}
	function getData(){
		var	passwordNuevo	=	"&passwordNuevo="+document.getElementById("passwordNuevo").value
		var	comuna	=			"&comuna="+document.getElementById("comuna").value
		var	selSexo	=			"&selSexo="+document.getElementById("selSexo").value
		var	email	=			"&email="+document.getElementById("email").value
		var	materno	=			"&materno="+document.getElementById("materno").value
		var	passwordActual	=	"&passwordActual="+document.getElementById("passwordActual").value
		var	region	=			"&region="+document.getElementById("region").value
		var	fechaNacimiento	=	"&fechaNacimiento="+document.getElementById("fechaNacimiento").value
		var	telefono	=		"&telefono="+document.getElementById("telefono").value
		var	paterno	=			"&paterno="+document.getElementById("paterno").value
		var	rut	=				"&rut="+document.getElementById("rut").value
		return passwordNuevo+comuna+selSexo+email+materno+passwordActual+region+fechaNacimiento+telefono+paterno+rut;

	}
</script>
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
						<bean:define name="actualizarInformacionFB" id="cliente"
							property="cliente" />
						<tr>
							<td>Rut</td>
							<td><input required="required" type="text" id="rut"
								value='<bean:write name="cliente" property="rut" />' /></td>
						<tr>
						<tr>
							<td>Apellido Paterno</td>
							<td><input required="required" type="text" id="paterno"
								value='<bean:write name="cliente" property="paterno" />' /></td>
						</tr>
						<tr>
							<td>Telefono</td>
							<td><input required="required" type="text" id="telefono"
								value='<bean:write name="cliente" property="telefono" />' /></td>
						</tr>
						<tr>
							<td>Fecha Nacimiento</td>
							<td><input required="required" type="text"
								id="fechaNacimiento"
								value='<bean:write name="cliente" property="fechaNacimientoString" />' /></td>
						</tr>
						<tr>
							<td>Region</td>
							<td><select name="cbxRegion" class="field" id="region"
								tabindex="9">
									<logic:iterate name="actualizarInformacionFB"
										property="listRegiones" id="regiones">
										<option
											value='<bean:write name="regiones" property="codigoRegion" format="#" />'>
											<bean:write name="regiones" property="nombreRegion" />
										</option>
									</logic:iterate>
							</select></td>
						</tr>
						<tr>
							<td>Contraseña actual</td>
							<td><input type="password" id="passwordActual"
								required="required" /></td>
						</tr>
					</table>
				</td>
				<td>
					<table align="right">
						<tr>
							<td>Nombres</td>
							<td><input required="required" type="text" id="nombre"
								value='<bean:write name="cliente" property="nombre" />' /></td>
						</tr>
						<tr>
							<td>Apellido Materno</td>
							<td><input required="required" type="text" id="materno"
								value='<bean:write name="cliente" property="materno" />' /></td>
						</tr>
						<tr>
							<td>Correo</td>
							<td><input type="text" required="required" id="email"
								value='<bean:write name="cliente" property="eMail" />'
								placeholder="correo@gmail.com" /></td>
						</tr>
						<tr>
							<td>Sexo</td>
							<td><select id="selSexo">
									<logic:equal name="cliente" value="H" property="sexo">
										<option value="H">Hombre</option>
										<option value="M">Mujer</option>
									</logic:equal>
									<logic:equal name="cliente" value="M" property="sexo">
										<option value="M">Mujer</option>
										<option value="H">Hombre</option>
									</logic:equal>
							</select></td>
						<tr>
						<tr>
							<td>Comuna</td>
							<td><select name="cbxComuna" class="field" id="comuna"
								tabindex="10">
									<logic:iterate name="actualizarInformacionFB"
										property="listComunas" id="comunas">
										<option
											value='<bean:write name="comunas" property="codigoComuna" format="#" />'>
											<bean:write name="comunas" property="nombreComuna" />
										</option>
									</logic:iterate>
							</select></td>
						</tr>
						<tr>
							<td>Contraseña nueva</td>
							<td><input type="password" id="passwordNuevo" required="required" /></td>
						</tr>
					</table>
				</td>
			</tr>
			<table align="center">
				<br>
				<br>
				<tr>
					<td><input type="button" value="Actualizar"
						onclick="actualizar();" style="width: 100px" /></td>
					<td><input type="button" style="width: 100px" value="Salir" /></td>
				</tr>
			</table>
		</table>
	</form>

</body>
</html>