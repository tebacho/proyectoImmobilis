--------------------------------------------------------
-- Archivo creado  - miércoles-octubre-28-2015   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package PKG_COMUNA
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "IMMOBILIS"."PKG_COMUNA" 		AS				

TYPE RefCursor is REF CURSOR;

procedure						
INSERTAR_COMUNA	(					
		COD_RESULTADO	OUT	NUMBER	,	
		MSG_ERROR	OUT	varchar2	,	
		CURSOR_COMUNA	OUT	PKG_COMUNA.REFCURSOR	,	
		SP_ID_COMUNA	IN	NUMBER	,	
		SP_NOMBRE_COMUNA	IN	VARCHAR2	,	
		SP_ID_REGION	IN	NUMBER	);

procedure						
ACTUALIZAR_COMUNA	(					
		COD_RESULTADO	OUT	NUMBER	,	
		MSG_ERROR	OUT	varchar2	,	
		CURSOR_COMUNA	OUT	PKG_COMUNA.REFCURSOR	,	
		SP_ID_COMUNA	IN	NUMBER	,	
		SP_NOMBRE_COMUNA	IN	VARCHAR2	,	
		SP_ID_REGION	IN	NUMBER);
    
    procedure						
BUSCAR_COMUNA	(					
		COD_RESULTADO	OUT	NUMBER	,	
		MSG_ERROR	OUT	varchar2	,	
		CURSOR_COMUNA	OUT	PKG_COMUNA.REFCURSOR	,	
		SP_ID_COMUNA	IN	NUMBER	,	
		SP_NOMBRE_COMUNA	IN	VARCHAR2	,	
		SP_ID_REGION	IN	NUMBER		
);

procedure FILTRAR_COMUNAS(					
		COD_RESULTADO	OUT	NUMBER	,	
		MSG_ERROR	OUT	varchar2	,	
		CURSOR_COMUNA	OUT	PKG_COMUNA.REFCURSOR	,	
		SP_ID_COMUNA	IN	NUMBER	,	
		SP_NOMBRE_COMUNA	IN	VARCHAR2	,	
		SP_ID_REGION	IN	NUMBER		
);

				
END PKG_COMUNA;

/
