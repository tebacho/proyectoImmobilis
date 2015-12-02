
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html>
<head>

<link rel="stylesheet" type="text/css" href="style/estilo_principal.css" />
<script src="js/jquery-1.7.1.min.js" type="text/javascript"></script>

<title>login</title>
<style type="text/css">
body{background-color: #d6d6c2;}
h1{
font-family: "Comic Sans MS", cursive, sans-serif;
text-shadow: 2px 2px 4px #000000;
color:white;
font-size: 30px;
}
input:focus {background-color:#ffff99;}
a:hover{
color: #fff;
background-color: #ff6600;
</style>

<script type="text/javascript">

function login(){

	var rut = document.getElementById("rut").value;
	var pass = document.getElementById("password").value;
	var params = "&rut="+rut+"&password="+pass;

	$.ajax({
        type:    "POST",
        url:     "<%=request.getContextPath()%>/loginAction.do",
        data:    "method=login"+params,
        
        success: function(data){
			if(""!=data){
				
				parent.location.reload();
				
			}else{
				
				alert("Error de ingreso.");
				
			}
        }
	});
}
</script>
</head>
<body>
	<%request.getSession().getValue("nombre");%>
	<form align="center" autocomplete="on">
		<h1>Iniciar Sesión</h1>
		<hr>
		<p>
			<label for="username" class="uname" data-icon="u">Ingrese su
				Rut </label><br> <input id="rut" name="username" required="required"
				name="username" required="required" type="text" value="15413610k"
				placeholder="ejm:12345678-9" size='25' />
		</p>
		<p>
			<label for="password" class="youpasswd" data-icon="p">Su
				contraseña </label><br> <input id="password" name="password"
				required="required" type="password" placeholder="ej. 1234" size='25' value="15413" />
		</p>
		<p class="keeplogin">
			<input type="checkbox" name="loginkeeping" id="loginkeeping"
				value="loginkeeping" /> <label for="loginkeeping">Mantenerme
				conectado</label>
		</p>
		<p class="login button">
			<input type="button" value="Iniciar Sesión" style="width: 100px" onclick="login();"/> 
			<input type='button' value='Salir' style="width: 100px" onclick="window.parent.Shadowbox.close();" />
			
		</p>
		<p class="change_link">
			¿No esta registrado? <a href=<%=request.getContextPath()%>/registroAction.do?method=mostrarFormulario class="to_register">Registrarse</a>
		</p>
	</form>
</body>
</html>