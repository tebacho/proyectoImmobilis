--------------------------------------------------------
-- Archivo creado  - miércoles-diciembre-02-2015   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package PKG_CLIENTE
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "IMMOBILIS"."PKG_CLIENTE" AS

TYPE RefCursor is REF CURSOR;

procedure SP_INGRESA_NUEVO_CLIENTE(cod_resultado out number,
                              msg_error out varchar2,
                              cursorUsuario out PKG_CLIENTE.RefCursor, 
                              sp_rut in varchar2,
                              sp_nombre in varchar2,
                              sp_paterno in varchar2,
                              sp_materno in varchar2,
                              sp_sexo in varchar2,
                              sp_direccion in varchar2,
                              sp_fechaNacimiento in DATE,
                              sp_telefono in varchar2,
                              sp_email in varchar2,
                              sp_comuna in number,
                              sp_password in varchar2
                              );
                              
procedure SP_ACTUALIZA_CLIENTE( 
                              cod_resultado out number,
                              msg_error out varchar2,
                              cursorUsuario out PKG_CLIENTE.RefCursor,
                              sp_rut in varchar2,
                              sp_nombre in varchar2,
                              sp_paterno in varchar2,
                              sp_materno in varchar2,
                              sp_sexo in varchar2,
                              sp_fechaNacimiento in DATE,
                              sp_telefono in varchar2,
                              sp_email in varchar2,
                              sp_comuna in number,
                              sp_password in varchar2,
                              sp_passwordNuevo in varchar
                              );
                              
procedure SP_BUSCAR_CLIENTE(  cod_resultado out number,
                              msg_error out varchar2,
                              cursorUsuario out PKG_CLIENTE.RefCursor,
                              sp_rut varchar2
                              );
procedure SP_VALIDAR_CLIENTE( cod_resultado out number,
                              msg_error out varchar2,
                              cursorUsuario out PKG_CLIENTE.RefCursor,
                              sp_rut varchar2,
                              sp_password varchar2
                              );                              
END "PKG_CLIENTE";

/
--------------------------------------------------------
--  DDL for Package PKG_COMUNA
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "IMMOBILIS"."PKG_COMUNA" 		AS				

TYPE RefCursor is REF CURSOR;

procedure						
SP_INSERTAR_COMUNA	(					
		COD_RESULTADO	OUT	NUMBER	,	
		MSG_ERROR	OUT	varchar2	,	
		CURSOR_COMUNA	OUT	PKG_COMUNA.REFCURSOR	,	
		SP_ID_COMUNA	IN	NUMBER	,	
		SP_NOMBRE_COMUNA	IN	VARCHAR2	,	
		SP_ID_REGION	IN	NUMBER	);

procedure						
SP_ACTUALIZAR_COMUNA	(					
		COD_RESULTADO	OUT	NUMBER	,	
		MSG_ERROR	OUT	varchar2	,	
		CURSOR_COMUNA	OUT	PKG_COMUNA.REFCURSOR	,	
		SP_ID_COMUNA	IN	NUMBER	,	
		SP_NOMBRE_COMUNA	IN	VARCHAR2	,	
		SP_ID_REGION	IN	NUMBER);
    
    procedure						
SP_FILTRAR_COMUNAS	(					
		COD_RESULTADO	OUT	NUMBER	,	
		MSG_ERROR	OUT	varchar2	,	
		CURSOR_COMUNA	OUT	PKG_COMUNA.REFCURSOR	,	
		SP_ID_COMUNA	IN	NUMBER	,	
		SP_NOMBRE_COMUNA	IN	VARCHAR2	,	
		SP_ID_REGION	IN	NUMBER		
);

procedure						
SP_LISTAR_COMUNAS	(					
		COD_RESULTADO	OUT	NUMBER	,	
		MSG_ERROR	OUT	varchar2	,	
		CURSOR_COMUNA	OUT	PKG_COMUNA.REFCURSOR	
);


				
END PKG_COMUNA;

/
--------------------------------------------------------
--  DDL for Package PKG_CONTRATO
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "IMMOBILIS"."PKG_CONTRATO" 		AS				

TYPE RefCursor is REF CURSOR;

procedure						
SP_GRABAR_CONTRATO	(					
                      COD_RESULTADO	OUT	NUMBER	,	
                      MSG_ERROR	OUT	varchar2	,	
                      CURSOR_REGION	OUT	PKG_CONTRATO.REFCURSOR	,	
                      SP_ID_RESERVA	NUMBER,
                      SP_DESCUENTO	NUMBER,
                      SP_RUT	VARCHAR2,
                      SP_EMP_RUT	VARCHAR2,
                      SP_ID_SERVICIO	NUMBER,
                      SP_ID_SEGURO	NUMBER,
                      SP_ID_PROPIEDAD VARCHAR,
                      SP_OPERACION VARCHAR
                      
		);
END;

/
--------------------------------------------------------
--  DDL for Package PKG_EMPLEADO
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "IMMOBILIS"."PKG_EMPLEADO" AS

TYPE RefCursor is REF CURSOR;

procedure SP_VALIDAR_EMPLEADO( cod_resultado out number,
                              msg_error out varchar2,
                              cursorUsuario out PKG_CLIENTE.RefCursor,
                              sp_rut varchar2,
                              sp_password varchar2
                              );                              
END "PKG_EMPLEADO";

/
--------------------------------------------------------
--  DDL for Package PKG_PROPIEDADES
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "IMMOBILIS"."PKG_PROPIEDADES" 		AS				

TYPE RefCursor is REF CURSOR; 

procedure SP_FILTER_PROPIEDADES (
                              COD_RESULTADO	OUT	NUMBER	,	
                              MSG_ERROR	OUT	varchar2	,	
                              CURSOR_PROPIEDAD	OUT	PKG_PROPIEDADES.REFCURSOR	,
                              SP_TIPO_OPERACION IN VARCHAR2,
                              SP_TIPO_PROPIEDAD IN VARCHAR2,
                              SP_UBICACION IN VARCHAR2);
procedure SP_FETCH_BY_ID (
                              COD_RESULTADO	OUT	NUMBER	,	
                              MSG_ERROR	OUT	varchar2	,	
                              CURSOR_PROPIEDAD	OUT	PKG_PROPIEDADES.REFCURSOR	,
                              SP_ID_PROPIEDAD IN NUMBER);
procedure SP_RESERVA_PROPIEDAD (
                              COD_RESULTADO	OUT	NUMBER	,	
                              MSG_ERROR	OUT	varchar2	,	
                              CURSOR_PROPIEDAD	OUT	PKG_PROPIEDADES.REFCURSOR,
                              SP_ID_PROPIEDAD	NUMBER,
                              SP_ID_TIPO_RESERVA	NUMBER,
                              SP_ID_SEGURO	NUMBER,
                              SP_RUT	VARCHAR2
                              );                              
 procedure SP_FETCH_RESERVAS (
                              COD_RESULTADO	OUT	NUMBER	,	
                              MSG_ERROR	OUT	varchar2	,	
                              CURSOR_PROPIEDAD	OUT	PKG_PROPIEDADES.REFCURSOR,
                              SP_ID_RESERVA	NUMBER,
                              SP_RUT	VARCHAR2
                              );                                               
END;

/
--------------------------------------------------------
--  DDL for Package PKG_REGION
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "IMMOBILIS"."PKG_REGION" 		AS				

TYPE RefCursor is REF CURSOR;

procedure						
SP_INSERTAR_REGION	(					
		COD_RESULTADO	OUT	NUMBER	,	
		MSG_ERROR	OUT	varchar2	,	
		CURSOR_REGION	OUT	PKG_REGION.REFCURSOR	,	
		SP_ID_REGION	IN	NUMBER	,	
		SP_NOMBRE_REGION	IN	VARCHAR2
		);

procedure						
SP_ACTUALIZAR_REGION	(					
		COD_RESULTADO	OUT	NUMBER	,	
		MSG_ERROR	OUT	varchar2	,	
		CURSOR_REGION	OUT	PKG_REGION.REFCURSOR	,	
		SP_ID_REGION	IN	NUMBER	,	
		SP_NOMBRE_REGION	IN	VARCHAR2
		);
    
    procedure						
SP_FILTRAR_REGION	(					
		COD_RESULTADO	OUT	NUMBER	,	
		MSG_ERROR	OUT	varchar2	,	
		CURSOR_REGION	OUT	PKG_REGION.REFCURSOR	,	
		SP_ID_REGION	IN	NUMBER	,	
		SP_NOMBRE_REGION	IN	VARCHAR2
		);
    procedure
SP_LISTAR_REGIONES	(					
		COD_RESULTADO	OUT	NUMBER	,	
		MSG_ERROR	OUT	varchar2	,	
		CURSOR_REGION	OUT	PKG_REGION.REFCURSOR
		);
				
END PKG_REGION;

/
--------------------------------------------------------
--  DDL for Package PKG_SERVICIOS
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "IMMOBILIS"."PKG_SERVICIOS" AS

TYPE RefCursor is REF CURSOR;

procedure SP_FETCH_ALL(cod_resultado out number,
                              msg_error out varchar2,
                              cursorServicio out PKG_SERVICIOS.RefCursor
                              );
                              
procedure SP_FETCH_SEGURO(cod_resultado out number,
                          msg_error out varchar2,
                          cursorServicio out PKG_SERVICIOS.RefCursor,
                          SP_ID_SEGURO in number
                          );
procedure SP_FETCH_ALL_CONVENIOS(cod_resultado out number,
                          msg_error out varchar2,
                          cursorServicio out PKG_SERVICIOS.RefCursor
                          );                        
                                                    
END "PKG_SERVICIOS";

/
