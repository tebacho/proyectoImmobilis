<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="js/shadowbox/shadowbox.css" />
<link rel="stylesheet" type="text/css" href="style/busqueda.css" />
<script type="text/javascript" src="js/shadowbox/shadowbox.js"></script>
<script src="js/jquery-1.7.1.min.js" type="text/javascript"></script>
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

<script type="text/javascript">

	function buscarDatosReserva() {
		
		var txtReserva = "&txtReserva="+document.getElementById("txtReserva").value;
		var txtRut = "&txtRut=" + document.getElementById("txtRut").value;
		var frame = parent.document.getElementById('frameCentral');
		frame.src = 'generarContratoAction.do?method=mostrarFormulario'+ txtReserva + txtRut;
	}

	function guardarContrato() {
	alert("hola");
		var params = getData();
		$.ajax({
	        type:    "POST",
	        url:     "generarContratoAction.do",
	        data:    "method=guardarContrato"+params,
	        
	        success: function(data){
				if(""!=data){
					alert ("Ingreso exitoso");
					parent.location.reload();
					
				}else{
					
					alert("Error al guardar.");
					
				}
	        }
		});

	}

	function getData(){
		
		var txtReserva = 		"&txtReserva="+ document.getElementById("txtReserva").value;
		var rut = 		 		"&rut=" + document.getElementById("rut").value;
		var txtIdPropiedad = 	"&txtIdPropiedad="+document.getElementById("txtIdPropiedad").value;
		var txtIdServicio = 	"&txtIdServicio="+document.getElementById("txtIdServicio").value;
		var txtIdSeguro = 		"&txtIdSeguro="+document.getElementById("txtIdSeguro").value;
		var txtDescuento = 		"&descuento="+document.getElementById("txtDescuento").value;
		var txtOperacion = 		"&operacion="+document.getElementById("txtOperacion").value;

		return rut + txtIdPropiedad + txtIdServicio + txtIdSeguro + txtReserva + txtDescuento + txtOperacion;

	}
</script>

</head>

<body>
	<form name="form1" autocomplete="on">
		<div align="center" action="#" autocomplete="on">
			<h1>Generar Contrato</h1>
			<hr>
		</div>
		<div class="cabeza">Reserva</div>
		<br>
		<table align="center">
			<tr>
				<td>N° Reserva <select name="cbxReserva" class="field"
					id="txtReserva">
						<logic:iterate name="generarContratoFB" property="listReserva"
							id="reservas">
							<option
								value='<bean:write name="reservas" property="idReserva" format="#" />'>
								<bean:write name="reservas" property="idReserva" format="#" />
							</option>


						</logic:iterate>
				</select></td>
			</tr>
			<tr>
				<td>Rut Cliente <input type="text" id="txtRut"
					value='<bean:write name="generarContratoFB" property="cliente.rut" />' />
				</td>
			</tr>

			<tr>
				<td><input type="button" value="buscar" onclick="buscarDatosReserva();" /></td>
			</tr>
		</table>
		<br>
		<div class="cabeza">Datos Usuario</div>
		<br>
		<!-- INICIO DATOS USUARIO -->

		<table align="center">
			<bean:define id="cliente" name="generarContratoFB" property="cliente" />
			<tr>
				<td>
					<table class="table_iz">
						<tr>
							<td>Nombre</td>
							<td><input type="text" id="nombre"
								value='<bean:write name="cliente" property="nombre" />' /></td>
						</tr>
						<tr>
							<td>Apellido Materno</td>
							<td><input type="text" id="materno"
								value='<bean:write name="cliente" property="materno" />' /></td>
						</tr>
						<tr>
							<td>Rut</td>
							<td><input type="text" id="rut"
								value='<bean:write name="cliente" property="rut" />' /></td>
						</tr>
						<tr>
							<td>E-mail</td>
							<td><input type="text" id="email"
								value='<bean:write name="cliente" property="eMail" />' /></td>
						</tr>
						<tr>
							<td>Telefono</td>
							<td><input type="text" id="telefono"
								value='<bean:write name="cliente" property="telefono" />' /></td>
						</tr>


					</table>
				</td>
				<td>
					<table class="table_iz">
						<tr>
							<td>Apellido Paterno</td>
							<td><input type="text" id="paterno"
								value='<bean:write name="cliente" property="paterno" />' /></td>
						</tr>
						<tr>
							<td>Fecha Nacimiento</td>
							<td><input type="text" id="fechaNacimiento"
								value='<bean:write name="cliente" property="fechaNacimientoString" />' /></td>
						</tr>
						<tr>
							<td>Sexo</td>
							<td><input type="text" id="sexo"
								value='<bean:write name="cliente" property="sexo" />' /></td>
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
					<table class="table_iz">
						<bean:define id="vPropiedades" name="generarContratoFB"
							property="propiedad" />
						<tr>
							<td>ID Propiedad</td>
							<td><input type="text" id="txtIdPropiedad" readonly
								value='<bean:write name="vPropiedades" property="idPropiedad" format="#" />' /></td>
						</tr>
						<tr>
							<td>Nombre Región</td>
							<td><input type="text" id="txtNombreRegion" readonly
								value='<bean:write name="vPropiedades" property="nombreRegion"  />' /></td>
						</tr>
						<tr>
							<td>Tipo Propiedad</td>
							<td><input type="text" id="txtTipoPropiedad" readonly
								value='<bean:write name="vPropiedades" property="tipoPropiedad"  />' /></td>
						</tr>
						<tr>
							<td>Descripción</td>
							<td><input type="text" id="txtDescripcion" readonly
								value='<bean:write name="vPropiedades" property="descripcion" />' /></td>
						</tr>
						<tr>
							<td>Operación</td>
							<td><input type="text" id="txtOperacion" readonly
								value='<bean:write name="vPropiedades" property="tipoOperacion"  />' /></td>
						</tr>
						<tr>
							<logic:present name="vPropiedades" property="altura">
								<td>Altura</td>
								<td><input type="text" id="txtAltura" readonly
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
								<td><input type="text" id="txtDormitorio" readonly
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
								<td><input type="text" id="txtEdificio" readonly
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
								<td><input type="text" id="txtPatenteComercial" readonly
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
							<td><input type="text" id="txtNombreComuna" readonly
								value='<bean:write name="vPropiedades" property="nombreComuna" />' /></td>
						</tr>
						<tr>
							<td>Dirección</td>
							<td><input type="text" id="txtDireccion" readonly
								value='<bean:write name="vPropiedades" property="direccion" />' /></td>
						</tr>
						<tr>
							<td>Nombre Constructora</td>
							<td><input type="text" id="txtNombreConstructora" readonly
								value='<bean:write name="vPropiedades" property="nombreConstructora" />' />
							</td>
						</tr>
						<tr>
							<td>Precio</td>
							<td><input type="text" id="txtPrecio" readonly
								value='<bean:write name="vPropiedades" property="precioUF" format="#"/>' /></td>
						</tr>
						<tr>
							<td>Disponible</td>
							<td><input type="text" id="txtDisponible" readonly
								value='<bean:write name="vPropiedades" property="disponible" />' /></td>
						</tr>
						<tr>
							<logic:present name="vPropiedades" property="bannos">
								<td>Baño</td>
								<td><input type="text" id="txtBano" readonly
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
								<td><input type="text" id="txtConjunto" readonly
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
								<td><input type="text" id="txtNivel" readonly
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
		<div class="cabeza">Adicionales</div>
		<br>
		<!-- INICIO DATOS SEGURO -->
		<table align="center">
			<tr>
				<td>
					<table>
						<tr>
							<td>Seguro</td>
							<td><input type="text" id="txtSeguro"
								value='<bean:write name="generarContratoFB" property="seguro.glosa" />'><input type="hidden" id="txtIdSeguro"
								value='<bean:write name="generarContratoFB" property="seguro.seguro" format="#" />'></td>
							
						</tr>
						<tr>
							<td>Servicio Adicional</td>
							<td><select name="Servicios" class="field"
								id="txtIdServicio">
									<logic:iterate name="generarContratoFB"
										property="listServicios" id="servicios">
										<option
											value='<bean:write name="servicios" property="idServicio" format="#" />'>
											<bean:write name="servicios" property="descripcion"
												format="#" />
										</option>
									</logic:iterate>
							</select></td>
						</tr>
						<tr>
							<td>Convenio</td>
							<td><select name="Servicios" class="field" id="txtDescuento">
									<logic:iterate name="generarContratoFB" property="listConvenio" id="convenios">
										<option
											value='<bean:write name="convenios" property="descuento" format="#" />'>
											<bean:write name="convenios" property="descripcion"
												format="#" />
										</option>
									</logic:iterate>
							</select></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<table align="center">

			
		</table>
		<table align="center">
			<tr>
				<td><input type="button" value="Confirmar"
					style="width: 100px;" onclick="guardarContrato();" /></td>
				<td><input type="button" value="Cancelar" style="width: 100px;" /></td>
			</tr>
		</table>
		<br> <br>
	</form>

</body>

</html>