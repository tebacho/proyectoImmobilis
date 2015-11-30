
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/estilo_principal.css" />
<script src="js/jquery-1.7.1.min.js" type="text/javascript"></script>
<title>Contratos Activos</title>
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
</style>
</head>
<body>
	<form action="" autocomplete="on">
		<h1>Contratos Activos</h1>
		<hr>
		<br>
		<div>
			<label>Numero Contrato</label><input type="text" required="required"/> 
			<label>Fecha Contrato</label><input type="date" /> 
			<br><br> 
			<input type="submit" value="Buscar" style="width: 100px;" /> 
			<input type="button" value="Cancelar" style="width: 100px;" />
			<br><br>
			<hr>

		</div>
		<table classe="grilla" align="center" width="600px">
			
			<tr id="cabeza_grilla">
				<td>N°Contrato</td>
				<td>Fecha Contrato</td>
				<td>Cuotas pendientes</td>
				<td>Monto Pendiente</td>
			</tr>
			<logic:notEmpty name="contratosActivosFB" property="contratos"> 
			<logic:iterate name="contratosActivosFB" property="HashContratos" id="contrato">
			<bean:define name="contratosActivosFB" id="contratos" property="values" />
			<tr>
				<td><bean:write name="contratos" property="numeroContrato" /></td>
				<td><bean:write name="contratos" property="fechaContrato" /></td>
				<td><bean:write name="contratos" property="cuotasPendientes" /></td>
				<td><bean:write name="contratos" property="fechaContrato" /></td>
				<td>UF<bean:write name="contratos" property="montoPendiente" /></td>
			</tr>
			</logic:iterate>
			</logic:notEmpty>
		</table>
	</form>
</body>
</html>