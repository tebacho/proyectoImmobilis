<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<head>
<link rel="stylesheet" type="text/css" href="style/busqueda_1.css" />
<script src="js/jquery-1.7.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
	function abrirFormularioReserva(idPropiedad){
		var userRut = document.getElementById("sessionRut");
		
		var filtros = "&idPropiedad"+idPropiedad+"&userRut"+userRut;
		
		var loc="<%=request.getContextPath()%>/formularioReservaAction.do";
		loc = loc + "?method=mostrarFormulario";
		loc = loc + filtros;
		alert(loc);
		window.parent.document.getElementById('frameCentral').src=loc; 
		
		
	}
</script>

</head>

<body>
	<div class="contenedor_principal" align="center">

		<!--1 INICIO CONTENDOR -->
		<logic:notEmpty name="busquedaFB" property="propiedades">
			<logic:iterate name="busquedaFB" id="propiedades" property="propiedades">
				<bean:define id="vPropiedades" name="propiedades" property="value" />
				<section class="resultadoBusqueda resBorde">
					<div class="contenedor_iz">
						<div class="imgProyecto"
							style="background-image: url('images/1_.jpg')" align="left"></div>
					</div>
					<div class="contenedor_de">

						<div align="left" class="familia_1"><bean:write name="vPropiedades" property="nombreConstructora" /></div>
						<h2>
							<a href="#"><bean:write name="vPropiedades" property="proyecto" /></a>
						</h2>
						<p class="familia_2"><bean:write name="vPropiedades" property="direccion" /></p>

						<section class="resDatos">
							<section class="dato2">
								<figure>
									<img src="images/iconos/icon-propiedad-1.png" />
								</figure>
								<p><bean:write name="vPropiedades" property="tipoPropiedad" /></p>
							</section>
							
							<logic:present name="vPropiedades" property="dormitorios" >
							<section class="dato3">
								<figure>
									<img src="images/iconos/icon-dormitorios2.png" />
								</figure>
								<p><bean:write name="vPropiedades" property="dormitorios" format="#"/></p>
							</section>
							</logic:present>
							
							<logic:present name="vPropiedades" property="bannos" >
							<section class="dato4">
								<figure>
									<img src="images/iconos/icon-banios2.png" />
								</figure>
								<p><bean:write name="vPropiedades" property="bannos" format="#" /></p>
							</section>
							</logic:present>
							
							<logic:present name="vPropiedades" property="altura" >
							<section class="dato3">
								<figure>
									<img src="images/iconos/icon-altura.png" />
								</figure>
								<p> <bean:write name="vPropiedades" property="altura" format="#"/>m</p>
							</section>
							
							</logic:present>
							<section class="dato5">
								<figure>
									<img src="images/iconos/icon-medidas2.png" />
								</figure>
								<p>
									<logic:present name="vPropiedades" property="metrosTotal" >
										<bean:write name="vPropiedades" property="metrosTotal" />
									</logic:present>
									<logic:notPresent name="vPropiedades" property="metrosTotal" >
										<bean:write name="vPropiedades" property="metrosCuadrados" format="#" />
									</logic:notPresent>
									m<sup>2</sup>
								</p>
							</section>

						</section>

					</div>
					<section class="resultadoPrecios">
						<section id="resLineaAbajo">
							<p class="precio1">
								 UF <span><bean:write name="vPropiedades" property="precioUF" format="#" /></span>
							</p>
							<br>
							<!--  p class="precio2">
								dividendo mensual (*) <span>$ 120.000</span>
							</p -->
						</section>
						<section class="resBtnCotizar">
							<button class="btnCotizar" onclick="abrirFormularioReserva('<bean:write name="propiedades" property="key" />');">Cotizar</button>
						</section>
					</section>
				</section>
				<!--1 FIN CONTENEDOR-->

			</logic:iterate>
		</logic:notEmpty>

	</div>
</body>

</html>