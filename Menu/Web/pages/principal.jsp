<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<head>

<title>Modelo</title>
<link rel="stylesheet" type="text/css" href="style/shadowbox.css" />
<link rel="stylesheet" type="text/css" href="style/estilo_principal.css" />
<script src="js/shadowbox/shadowbox.js" type="text/javascript"></script>
<script src="js/jquery-1.7.1.min.js" type="text/javascript"></script>
<link rel="shortcut icon" href="images/iconos/favicon.ico">

<script type="text/javascript">
	Shadowbox.init({
		lang : 'es',
		players : [ 'img', 'html', 'iframe', 'qt', 'wmp', 'swf', 'flv' ],
		modal : true,
		viewportPadding : 50
	});
	
	function abrirLoginUsuarioWeb(){
		
		var sbx = window.Shadowbox;
		sbx.open({
		        content:    '<%=request.getContextPath()%>/loginAction.do?method=mostrarFormulario',
		        player:     "iframe",
		        height:     500,
		        width:      650
		    });
		
	}
function abrirLoginEmpleado(){
		
		var sbx = window.Shadowbox;
		sbx.open({
		        content:    '<%=request.getContextPath()%>/loginEjecutivoAction.do?method=mostrarFormulario',
		        player:     "iframe",
		        height:     500,
		        width:      650
		    });
		
	}
	
	function cerrarSesion(){
		window.location= '<%=request.getContextPath()%>/loginAction.do?method=cerrarSession';
	}

	function cargarActualizacionDatos() {
		var rutCliente = document.getElementById("rutCliente");
		var pagina = "actualizarInformacionAction.do?method=mostrarFormulario";
		document.getElementById('frameCentral').src = pagina;

	}
	function cargaHistorialPagos() {
		var pagina = "informacionPagosAction.do?method=mostrarFormulario";
		document.getElementById('frameCentral').src = pagina;

	}
	function cargaContratosActivos() {
		var pagina = "contratosActivosAction.do?method=mostrarFormulario";
		document.getElementById('frameCentral').src = pagina;
	}

	//	Ejecutivo
	function cargaEjecutivoAdjuntarRespaldo() {

		var pagina = "adjuntarRespaldosAction.do?method=mostrarFormulario";
		document.getElementById('frameCentral').src = pagina;
	}
	function cargaGenerarContrato() {

		var pagina = "generarContratoAction.do?method=mostrarFormulario";
		document.getElementById('frameCentral').src = pagina;
	}
	function cargaListadoCobranza() {

		var pagina = "reporteCobrosAction.do?method=mostrarFormulario";
		document.getElementById('frameCentral').src = pagina;
	}
	function cargaIngresoPago() {
		var pagina = "ingresoPagoAction.do?method=mostrarFormulario";
		document.getElementById('frameCentral').src = pagina;
	}
	function cargaIngresarRespaldo() {

		var pagina = "adjuntarRespaldosAction.do?method=mostrarFormulario";
		document.getElementById('frameCentral').src = pagina;
	}
	function cargaReporteArriendos() {

		var pagina = "reportePropiedadAction.do?method=mostrarFormulario";
		document.getElementById('frameCentral').src = pagina;
	}
	function cargaReporteContratos() {

		var pagina = "reporteContratosAction.do?method=mostrarFormulario";
		document.getElementById('frameCentral').src = serverPort + pagina;
	}

	function filtrarPropiedades() {

		var filtros = searchData();

		var loc = "busquedaAction.do";
		loc = loc + "?method=filterPropiedades";
		loc = loc + filtros;
		document.getElementById('frameCentral').src = loc

	}

	function searchData() {
		var operacion = document.getElementById("tipoBusquedaFiltro").value;
		var tipoPropiedad = document.getElementById("tipoPropiedadFiltro").value;
		var ubicacion = document.getElementById("txtComuna").value;

		var variables = "&filtroTipoOperacion=" + operacion
				+ "&filtroTipoPropiedad=" + tipoPropiedad + "&filtroUbicacion"
				+ ubicacion;
		return variables;
	}
	function closeAndReload() {
		var sbx = window.Shadowbox;
		sbx.close();
		window.location.reload();
	}
</script>
<style type="text/css">
.indicador {
	padding-left: 35px;
}

.menu_indicador {
	border: 3px solid #c2c2a3;
	height: 500px;
	width: 18%;
	float: left;
	display: block;
	margin-left: 10px;
	background-color: #e9e9e9;
	color: #666;
}

.titulo_indicador {
	font-size: 19px;
	text-align: center;
	margin: 5px 0px 10px 0px;
	color: #ff6600;
	font-weight: bold;
	font-family: "Comic Sans MS", cursive, sans-serif;
}
</style>
</head>
<body>

	<div class="contenedor_principal">

		<div class="contenedor_1">
			<img alt="" src="images/logo.png" class="logo" align="left">

			<div class="ingreso" align="right">
				<logic:present name="cliente" property="rut" scope="session">
					<span> <input type="button" value="Cerrar Sesion"
						onclick="cerrarSesion();" /></span>
				</logic:present>
				<logic:notPresent name="cliente" property="rut" scope="session">
					<span> <input type="button" value="Usuario"
						onclick="abrirLoginUsuarioWeb();" style="width: 100px;" /></span>
					<span> <input type="button" value="Colaborador"
						onclick="abrirLoginEmpleado();" style="width: 100px;" /></span>
				</logic:notPresent>
			</div>

		</div>


		<div class="contenedor_2">
			<div class="buscador">
				<div align="center" style="display: inline; widht: 100%;">
					<p align="center">
						<span> <select name="tipoBusqueda" class="field"
							id="tipoBusquedaFiltro">
								<logic:iterate name="principalFB" property="tipoBusqueda"
									id="tipoBusqueda">
									<option
										value='<bean:write name="tipoBusqueda" property="key" />'>
										<bean:write name="tipoBusqueda" property="value" />
									</option>
								</logic:iterate>
						</select>
						</span> <span> <select name="tipoPropiedad" class="field"
							id="tipoPropiedadFiltro">
								<logic:iterate name="principalFB" property="tipoPropiedad"
									id="tipoPropiedad">
									<option
										value='<bean:write name="tipoPropiedad" property="key" />'>
										<bean:write name="tipoPropiedad" property="value" />
									</option>
								</logic:iterate>
						</select>

						</span> <span> <input type="text" placeholder="Ingrese ubicacion"
							id="txtComuna" required="required">
						</span> <span><input type="button" value="Buscar"
							onclick="filtrarPropiedades()" /></span>
					</p>
				</div>
			</div>
		</div>
		<%
			if (request.getSession().getAttribute("cliente") != null) {
		%>
		<div class="contenedor_4">


			<div class="menu_usuario">
				<div class="menu">
					<h1>Menu Cliente</h1>
					<hr>
					<div class="menu_boton">
						<input type="button" value="Actualizar Datos"
							style="width: 150px; height: 25px"
							onclick="cargarActualizacionDatos();" /><br> <input
							type="button" value="Historial de Pagos"
							style="width: 150px; height: 25px"
							onclick="cargaReporteContratos();" /><br> <input
							type="button" value="Ver Contratos"
							style="width: 150px; height: 25px"
							onclick="cargaContratosActivos();" />
					</div>
				</div>
			</div>
			<%
				}
			%>
			<%
				if (request.getSession().getAttribute("empleado") != null) {
			%>
			<div class="menu_empleado">
				<div class="menu">
					<h1>Menu Empleado</h1>
					<hr>
					<div class="menu_boton">
						<!--input type="button" value="Actualizar Datos" style="width: 150px; height: 25px" onclick="cargaEjecutivoAdjuntarRespaldo();" /-->
						<input type="button" value="Generar Contrato"
							style="width: 150px; height: 25px"
							onclick="cargaGenerarContrato();" /> <input type="button"
							value="Listado Cobranza" style="width: 150px; height: 25px"
							onclick="cargaListadoCobranza();" /> <input type="button"
							value="Ingreso Pago" style="width: 150px; height: 25px"
							onclick="cargaIngresoPago();" /> <input type="button"
							value="Ingresar Respaldos" style="width: 150px; height: 25px;"
							onclick="cargaIngresarRespaldo();" /> <input type="button"
							value="Reporte Arriendos" style="width: 150px; height: 25px;"
							onclick="cargaReporteArriendos();" />
					</div>
				</div>
			</div>
			<%
				}
			%>

			<!-- INIDCADOR INICIO -->

			<div class="menu_indicador">
				<div class="titulo_indicador">Indicadores Economicos</div>
				<div class="titulo_indicador">Hoy</div>
				<br>
				<hr>
				<br>
				<div class="indicador">
					<p></p>
				</div>
			</div>

			<!-- INDICADOR FIN -->
			<div class="frame">
				<iframe id="frameCentral"
					src="<%=request.getContextPath()%>/busquedaAction.do?method=iniciarPagina"
					width="100%" height="500px"
					style="display: inline-block; scrollable: true;"> </iframe>
			</div>

		</div>








		<div class="contenedor_3" style="width: 100%">
			<div class="pie_1" style="width: 100%">
				<img src="images/pie.png" />
			</div>
			<div class="pie_2" style="width: 100%">
				<strong>INMOBILIARIA IMMOBILIS LTDA</strong><br>
				<p>AV. SIEMPRE VIVA 742, SANTIAGO - CHILE (+560)0000000</p>
			</div>
			<div class="pie_3" style="width: 100%">
				<p>Copyright &copy; 2015 - Todos los derechos reservados.</p>
				<br>
			</div>
		</div>

	</div>
	<script type="text/javascript">
		$.getJSON(
				'http://mindicador.cl/api',
				function(data) {
					var dailyIndicators = data;
					$(
							"<p/>",
							{
								html : 'Valor UF $' + dailyIndicators.uf.valor
										+ '<br><br><br>' + 'Valor UTM $'
										+ dailyIndicators.utm.valor
										+ '<br><br><br>' + 'Valor Dólar O.$'
										+ dailyIndicators.dolar.valor
										+ '<br><br><br>' + 'Valor Euro $'
										+ dailyIndicators.euro.valor
										+ '<br><br><br>' + 'Valor IPC $'
										+ dailyIndicators.ipc.valor
										+ '<br><br><br>' + 'Valor IVP $'
										+ dailyIndicators.ivp.valor
										+ '<br><br><br>' + 'Valor Imacec '
										+ dailyIndicators.imacec.valor

							}).appendTo(".indicador");
				}).fail(function() {
			console.log('Error al consumir la API!');
		});
	</script>
</body>
