<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<head>

<link rel="stylesheet" type="text/css" href="js/shadowbox/shadowbox.css" />
<link rel="stylesheet" type="text/css" href="style/busqueda.css" />
<script type="text/javascript" src="js/shadowbox/shadowbox.js"></script>
<script src="js/jquery-1.7.1.min.js" type="text/javascript"></script>
<script src="js/Validaciones.js" type="text/javascript"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
Shadowbox.init({
		lang : 'es',
		players : [ 'img', 'html', 'iframe', 'qt', 'wmp', 'swf', 'flv' ],
		modal : true,
		viewportPadding : 50
	});
function abrirFormulario(idPropiedad){
		
		parametros ="&idPropiedad=idPropiedad";
		var sbx = window.Shadowbox;
		sbx.open({
		        content:    '<%=request.getContextPath()%>/formularioReservaAction.do?method=mostrarFormulario&'+parametros,
		        player:     "iframe",
		        height:     450,
		        width:      700
		    });
	}

</script>

</head>
<body>
	<logic:empty name="busquedaFB" property="propiedades">
		No hay Resultados que Mostrar
	</logic:empty>
	<!--  logic:notEmpty name="busquedaFB" property="propiedades"-->
	<logic:iterate name ="busquedaFB" property="propiedades" id="propiedades">
	
	                <section class="resultadoBusqueda">
                    <div class="imgProyecto">
                    	<a href=null>
                    		<div class="srcImgProyecto" style="background-image:url(null);" >
                    		</div>
                    	</a>
                    </div>
                    <article class="resultadoProyecto">
                        <p class="resInmobiliaria"> 
                        	IMMOBILIS
                        </p>
                        <a target="_blank" href='http://www.mientorno.cl/informe?radio=1000&lat=-29.898889&lng=-71.259970&direccion=Avenida Libertad con calle Cruz de Molino'>
                        	<section original-title="Índice de calidad de barrio habitacional (de 1 a 10), basado en criterios sociales, comerciales y de calidad de vida." class='iconoScore'>
                        		<span>
                        			4.1
                        		</span>
                        	</section>
                        </a>
                        <h2 class="resSegundaL">
                        	<a href="/ficha_proyecto.php?id=3754">Alto Serena III
                        	</a>
                        </h2>
                        <p class="resDireccion">
                        	Avenida Libertad con calle Cruz de Molino, La Serena
                        </p>
                        <section class="resDatos">
                            <section class="dato2">
                                <figure><img src="/img/v3/icon-propiedad-1.png" /></figure>
                                <p class="resTipoProp">Deptos.</p>
                            </section><section class="dato3">
                                <figure><img src='./img/v3/icon-dormitorios2.png' /></figure>
                                <p class="resDormitorios">1 a 4</p>
                            </section><section class="dato4">
                                <figure><img src='./img/v3/icon-banios2.png' /></figure>
                                <p class="resBanios">1 a 3</p>
                            </section><section class="dato5" original-title="De 35m<sup>2</sup> a 166,2m<sup>2</sup> útiles." >
                                <figure><img src="/img/v3/icon-medidas2.png"></figure>
                                <p class="resMetraje">35 a 166,2m<sup>2</sup></p>
                            </section>

                        </section>

                        <section class="resultadoPrecios">
                            <section class="resIconos">
                                <a class="iconoChico2"  onmouseover="return overlib('<img class=\'previewMapa\' src=\'http://maps.googleapis.com/maps/api/staticmap?zoom=15&size=450x300&maptype=roadmap&markers=color:red|color:red|-29.898889,-71.259970&sensor=false\' />',ABOVE,FULLHTML);" onmouseout="return nd();"   href="./ficha_proyecto.php?id=3754&tipo=1"><img id='iconoPreviewMapa' src="./img/v3/icono-mapa.png" />
                                </a>                                
                            </section>
	                            <section id="resLineaAbajo">
	                                <p class="resPrecio1L">
	                                	desde UF 
	                                	<span>1.408</span></p>
	                               <p class="resPrecio2L">
	                               		dividendo mensual (*) 
	                               			<span>
	                               				$ 179.400
	                               			</span> 
	                               		con 
	                               			<img class='logoBBVA' src='/img/v3/bbva/logo.png' />
	                               	</p>
	                            </section>
                            <section class="resBotonCotizar" style="">
                                <button onclick="abrirFormulario(1);" >Cotizar</button>
                            </section>
                        </section>
                    </article>

                </section>
	
	
	</logic:iterate>
	<!--  /logic:notEmpty -->
	
	
</body>