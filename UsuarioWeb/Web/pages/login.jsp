<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
</head>
<body>
	<form align="center" action="#" autocomplete="on">
		<h1>Iniciar Sesión</h1>
		<hr>
		<p>
			<label for="username" class="uname" data-icon="u">Su correo
				electrónico o nombre de usuario </label><br> <input id="username"
				name="username" required="required" type="text"
				placeholder="usuario o micorreo@mail.com" size='25' />
		</p>
		<p>
			<label for="password" class="youpasswd" data-icon="p">Su
				contraseña </label><br> <input id="password" name="password"
				required="required" type="password" placeholder="ej. 1234" size='25' />
		</p>
		<p class="keeplogin">
			<input type="checkbox" name="loginkeeping" id="loginkeeping"
				value="loginkeeping" /> <label for="loginkeeping">Mantenerme
				conectado</label>
		</p>
		<p class="login button">
			<input type="submit" value="Iniciar Sesión" /> <input type='button'
				value='Salir' onclick='CLOSE();' />

		</p>
		<p class="change_link">
			¿No esta registrado? <a href="http://localhost:8080/UsuarioWeb/registroAction.do?method=mostrarFormulario" class="to_register">Registrarse</a>
		</p>
	</form>
</body>
</html>