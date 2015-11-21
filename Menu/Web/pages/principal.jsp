<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modelo</title>
<link rel="stylesheet" type="text/css" href="style/shadowbox.css" />
<link rel="stylesheet" type="text/css" href="style/estilo_principal.css" />
<script src="js/shadowbox/shadowbox.js" type="text/javascript"></script>
<script src="js/jquery-1.7.1.min.js" type="text/javascript"></script>

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
		        content:    "http://localhost:8080/UsuarioWeb/loginAction.do?method=mostrarFormulario",
		        player:     "iframe",
		        height:     500,
		        width:      650
		    });
		
	}
	
	function filtrarPropiedades(){
		
		var sbx = window.Shadowbox;
		var filtros = searchData();
		
		var loc="<%=request.getContextPath()%>/busquedaAction.do";
		loc = loc + "?method=filterPropiedades";
		loc = loc + filtros;
		alert(loc);
		window.frames.frameCentral.location = loc;
	}

	function searchData() {
		var operacion = document.getElementById("tipoBusquedaFiltro").value;
		var tipoPropiedad = document.getElementById("tipoPropiedadFiltro").value;
		var comuna = document.getElementById("txtComuna").value;
		var variables = "&filtroTipoOperacion=" + operacion
				+ "&filtroTipoPropiedadBuscada=" + tipoPropiedad
				+ "&filtroUbicacion" + comuna;
		return variables;
	}
	function closeAndReload() {
		var sbx = window.Shadowbox;
		sbx.close();
		window.location.reload();
	}
</script>
<style>
</style>
</head>
<body>
	<div class="contenedor_principal">
		<%
			HttpSession sesion = request.getSession();
			String nombreUsuario = (String) sesion.getAttribute("usuario");
		%>
		<div class="contenedor_1">
			<img alt="" src="images/logo.png" class="logo" align="left">

			<div class="ingreso" align="right">
				<logic:notEmpty name="nombreUsuario">
					<span> <input type="button" value="Cerrar Sesion"
						onclick="cerrarSession();" /></span>
				</logic:notEmpty>
				<logic:empty name="nombreUsuario">
					<span> <input type="button" value="Ingresar"
						onclick="abrirLoginUsuarioWeb();" /></span>
				</logic:empty>
			</div>

		</div>

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

					</span> <span> <input type="text" placeholder="Ingrese comuna"
						id="txtComuna">
					</span> <span><input type="button" value="Buscar"
						onclick="filtrarPropiedades()" /></span>
				</p>
			</div>
		</div>

		<logic:notEmpty name="nombreUsuario">
			<ul id="ulUsuario"
				style="display: inline-block; width: 20%; vertical-align: top; height: 500px">
				<li><span><button>Actualizar Datos Personales</button></span></li>
				<li>&nbsp;</li>
				<li><span><button>Ver Historial de Pagos</button></span></li>
				<li>&nbsp;</li>
				<li><span><button>Ver Contratos Activos</button></span></li>
			</ul>
		</logic:notEmpty>
		<iframe id="frameCentral"
			src="<%=request.getContextPath()%>/busquedaAction.do?method=iniciarPagina"
			width="75%" height="500px"
			style="display: inline-block; scrollable: true;"> 
		</iframe>
		
		<div class="contenedor_3" style="width:100%">
		<div class="pie_1" style="width:100%"><img src="images/pie.png"/></div>
		<div class="pie_2" style="width:100%">
		<strong>INMOBILIARIA IMMOBILIS LTDA</strong><br>
		<p>AV. SIEMPRE VIVA 742, SANTIAGO - CHILE (+560)0000000</p>
		</div>
		<div class="pie_3" style="width:100%">
		<p>Copyright &copy; 2015 - Todos los derechos reservados.</p>
		</div>
		</div>
		
	</div>
</body>
