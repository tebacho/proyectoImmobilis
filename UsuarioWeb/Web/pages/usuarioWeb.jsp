
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@page import="java.util.Iterator"%>

<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuario</title>
<link rel="stylesheet" type="text/css" href="js/shadowbox/shadowbox.css" />
<script type="text/javascript" src="js/shadowbox/shadowbox.js"></script>
<script src="js/jquery-1.7.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
function addUser(){
		
		bloquearBotones();
		
		var parametros = getParamUser();

		$.ajax({
	        type:    "POST",
	        url:     "<%=request.getContextPath()%>/usuarioWebAction.do",
			data : "method=addNewUser" + parametros,

			success : function(data) {
				alert(data);
				window.parent.closeAndReload();
			}
		});

	}
	
function loginUsuario(){
	
	bloquearBotones();
	var rut = document.getElementById("txtRutLogin").value;
	var pass = document.getElementById("txtPassLogin").value;
	var parametros = "&txtRutLogin="+rut+"&txtPassLogin="+pass;
	

	$.ajax({
        type:    "POST",
        url:     "<%=request.getContextPath()%>/usuarioWebAction.do",
		data : "method=login" + parametros,

		success : function(data) {
				if(data==""){
					alert("error de ingreso");
				}else{
					alert("Bienvenido "+data);					
				}
				window.parent.closeAndReload();
				return;
			
		}
	});

}

	
	function getParamUser() {
		var rut = document.getElementById("txtRut").value;
		var nombre = document.getElementById("txtNombre").value;
		var paterno = document.getElementById("txtPaterno").value;
		var materno = document.getElementById("txtMaterno").value;
		var fechaNacimiento = document.getElementById("txtFechaNacimiento").value;
		var eMail = document.getElementById("txtEmail").value;
		var sexo = document.getElementById("txtSexo").value;
		var password = document.getElementById("txtPassword").value;
		var telefono = document.getElementById("txtTelefono").value;
		var region = document.getElementById("txtRegion").value;
		var comuna = document.getElementById("txtComuna").value;
		var params = "&txtRut=" + rut + "&txtNombre=" + nombre + "&txtPaterno="
				+ paterno + "&txtMaterno=" + materno + "&txtFechanacimiento="
				+ fechaNacimiento + "&txtEmail=" + eMail + "&txtSexo=" + sexo
				+ "&txtPassword=" + password + "&txtTelefono=" + telefono
				+ "&txtRegion=" + region + "&txtComuna=" + comuna;
		return params;
	}
	function bloquearBotones() {
		document.getElementById("btnIngresar").disable = true;

	}
	function desbloquearBotones() {
		document.getElementById("btnIngresar").disable = false;
	}
	function mostrarLogin(){
		document.getElementById("divLogin").style.display = 'block';
		document.getElementById("divIngreso").style.display = 'none';		
	}
	function mostrarIngreso(){
		document.getElementById("divLogin").style.display = 'none';
		document.getElementById("divIngreso").style.display = 'block';		
	}
	function closeAndReload() {
		var sbx = window.Shadowbox;
		sbx.close();
		window.location.reload();
	}
</script>
</head>
<style>
span {
	display: block;
}
</style>
<body>
	<div id="divIngreso" style='display:none' >
		<h3>INGRESO</h3>
		<span>Rut: <input type="text"
			value='<bean:write name="usuarioWebFB" property="rut" />' id="txtRut" /></span>
		<span>Nombre: <input type="text"
			value='<bean:write name="usuarioWebFB" property="nombre" />'
			id="txtNombre" /></span> <span>Apellido Paterno: <input type="text"
			value='<bean:write name="usuarioWebFB" property="paterno" />'
			id="txtPaterno" /></span> <span>Apellido Materno: <input type="text"
			value='<bean:write name="usuarioWebFB" property="materno" />'
			id="txtMaterno" /></span> <span>Fecha Nacimiento: <input type="text"
			value='<bean:write name="usuarioWebFB" property="fechaNacimiento" />'
			id="txtFechaNacimiento" /></span> <span>E-Mail: <input type="text"
			value='<bean:write name="usuarioWebFB" property="eMail" />'
			id="txtEmail" /></span> 
			<span>Sexo: <select name="sexo" class="field"
			id="txtSexo">
					<option value='M'>Mujer</option>
					<option value='H'>Hombre</option>
			</select>
		</span> 
		<span>Password: <input type="password"
			value='<bean:write name="usuarioWebFB" property="password" />'
			id="txtPassword" /></span> <span>Reingresar Password: <input
			type="password" value='' id="txtConfirmacion" /></span> <span>Teléfono:
			<input type="text"
			value='<bean:write name="usuarioWebFB" property="telefono" />'
			id="txtTelefono" />
		</span> <span>Region: <select name="tipoBusqueda" class="field"
			id="txtRegion">
				<logic:iterate name="usuarioWebFB" property="regiones" id="regiones">
					<option value='<bean:write name="regiones" property="key" />'>
						<bean:write name="regiones" property="value" />
					</option>
				</logic:iterate>
		</select>
		</span> <span>Comuna: <select name="tipoBusqueda" class="field"
			id="txtComuna">
				<logic:iterate name="usuarioWebFB" property="comunas" id="comunas">
					<option value='<bean:write name="comunas" property="key" />'>
						<bean:write name="comunas" property="value" />
					</option>
				</logic:iterate>
		</select>


		</span> <span><input type="button" value="Ingresar" id="btnIngresar"
			onclick="addUser();" /></span>
	</div>
	<div id="divLogin" style='display:none'>
	<h3>LOGIN</h3>
		<span>Rut: <input type="text"
			value='<bean:write name="usuarioWebFB" property="rutIngreso" />'
			id="txtRutLogin" /></span> <span>Password: <input type="text"
			value='<bean:write name="usuarioWebFB" property="passIngreso" />'
			id="txtPassLogin" /></span> <span><input type="button"
			onclick="loginUsuario();" value="Ingresar" /> </span>
	</div>
	<div>
	&nbsp;
	</div>
	<div id="divSwitchIngreso">
		<span><input type="button" onclick="mostrarLogin();"
			value="Mostrar login" /> 
		</span> <span><input type="button"
			onclick="mostrarIngreso();" value="Mostrar Ingreso" /> </span>
		<span><input type="button" name="cerrar" id="btnCerrar"
						value="Cerrar" onclick="window.parent.Shadowbox.close();"></span>	
	</div>
</body>
</html>