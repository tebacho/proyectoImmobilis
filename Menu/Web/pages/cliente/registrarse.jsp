
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@page import="java.util.Iterator"%>

<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/estilo_principal.css" />
<script src="js/jquery-1.7.1.min.js" type="text/javascript"></script>
<script src="js/validaciones.js" type="text/javascript"></script>

<title>Registrarse</title>
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
 function registrar(){
	 
	 var params = getData();
	if(params==""){
		return;
	}

		$.ajax({
	        type:    "POST",
	        url:     '<%=request.getContextPath()%>/registroAction.do',
	        data:    "method=registroUsuario"+params,
	        
	        success: function(data){
				if(""!=data){
					alert(data);
					parent.location.reload();
					
				}else{
					
					alert("Error de ingreso.");
					
				}
	        }
		});
 }		
 function getData(){
	var fechaNacimiento = document.getElementById("fechaNacimiento").value;
	 if(!validarFecha(fechaNacimiento)){
		 alert("fecha invalida");
		 return "";
	 }
	 if( Valida_Rut(document.getElementById("rut"))){
		 return "";
	 }
	var rut="&rut="+document.getElementById("rut").value;
	var apellidoPaterno="&apellidoPaterno="+document.getElementById("apellidoPaterno").value;
	var telefono="&telefono="+document.getElementById("telefono").value;
 	fechaNacimiento="&fechaNacimiento="+ encodeURIComponent(fechaNacimiento);
	var region="&region="+document.getElementById("region").value;
	var password="&password="+document.getElementById("password").value;
	var nombre="&nombre="+document.getElementById("nombre").value;
	var apellidoMaterno="&apellidoMaterno="+document.getElementById("apellidoMaterno").value;
	var email="&email="+document.getElementById("email").value;
	var sexo="&sexo="+document.getElementById("sexo").value;
	var comuna="&comuna="+document.getElementById("comuna").value;
	return fechaNacimiento+rut+apellidoPaterno+telefono+region+password+nombre+apellidoMaterno+email+sexo+comuna;

	}
 
 function validaFecha(fecha){
	 if(!validarFormatoFecha(fecha)){
		 alert("fecha invalida");
	 }
	 
	
 }
</script>
</head>
<body>
	<form >
		<input type="hidden" id="method" name="method" value="registroUsuario" />
		<input type="hidden" value="hiddenvalue1" name="Hidden1" />
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
							<td><input required="required" id="rut" tabindex="1" /></td>
						<tr>
						<tr>
							<td>Apellido Paterno</td>
							<td><input required="required" id="apellidoPaterno"
								 tabindex="3" /></td>
						</tr>
						<tr>
							<td>Telefono</td>
							<td><input required="required" id="telefono" tabindex="5" /></td>
						</tr>
						<tr>
							<td>Fecha Nacimiento</td>

							<td><input type="text"
								id="fechaNacimiento" tabindex="7" type="date" onblur="validaFecha(this.value);" placeholder="AAAA-MM-DD"/></td>
						</tr>
						<tr>
							<td>Region</td>
							<td><select name="cbxRegion" class="field" id="region"
								tabindex="9">
									<logic:iterate name="registroFB" property="listRegiones"
										id="regiones">
										<option value='<bean:write name="regiones" property="codigoRegion" format="#" />'>
											<bean:write name="regiones" property="nombreRegion" />
										</option>


									</logic:iterate>
							</select></td>
							
							
						</tr>
						<tr>
							<td>Contraseña</td>
							<td><input type="password" required="required" id="password"
								tabindex="11" /></td>
						</tr>
					</table>
				</td>
				<td>
					<table align="right">
						<tr>
							<td>Nombres</td>
							<td><input required="required" id="nombre" tabindex="2" /></td>
						</tr>
						<tr>
							<td>Apellido Materno</td>
							<td><input required="required" id="apellidoMaterno"
								tabindex="4" /></td>
						</tr>
						<tr>
							<td>Correo</td>
							<td><input type="text" required="required"
								placeholder="correo@gmail.com" id="email" tabindex="6" /></td>
						</tr>
						<tr>
							<td>Sexo:</td>
							<td><select id="sexo" tabindex="8">
									<option value='H'>Hombre</option>
									<option value='M'>Mujer</option>
							</select></td>
						<tr>
						<tr>

							<td>Comuna</td>
							<td><select name="cbxComuna" class="field" id="comuna"
								tabindex="10">
									<logic:iterate name="registroFB" property="listComunas"
										id="comunas">
										<option value='<bean:write name="comunas" property="codigoComuna" format="#" />'>
											<bean:write name="comunas" property="nombreComuna" />
										</option>
									</logic:iterate>
							</select></td>
						</tr>

						<tr>
							<td>Repita Contraseña</td>
							<td><input type="password" required="required" tabindex="12" /></td>
						</tr>
					</table>
				</td>
			</tr>
			<table align="center">
				<br>
				<br>
				<tr>
					<td><input type="button" value="Registrar"
						style="width: 100px" onclick="registrar();" /></td>
						
					<td><input type="button" style="width: 100px" value="Salir"
						onclick="window.parent.Shadowbox.close();" /></td>
				</tr>
			</table>
			<table align="center">
				<tr>
					<td>
						<p class="change_link">
							¿Ya estas registrado? <a
								href="<%=request.getContextPath()%>/loginAction.do?method=mostrarFormulario">Ir
								a Ingreso</a>
						</p>
					<td>
				</tr>
			</table>
		</table>
	</form>
</body>
</html>