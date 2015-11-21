--------------------------------------------------------
-- Archivo creado  - miércoles-octubre-28-2015   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package PKG_PROPIEDADES
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "IMMOBILIS"."PKG_PROPIEDADES" 		AS				

TYPE RefCursor is REF CURSOR;

procedure FILTER_PROPIEDADES (
                              COD_RESULTADO	OUT	NUMBER	,	
                              MSG_ERROR	OUT	varchar2	,	
                              CURSOR_PROPIEDAD	OUT	PKG_PROPIEDADES.REFCURSOR	,
                              SP_TIPO_OPERACION IN VARCHAR2,
                              SP_TIPO_PROPIEDAD IN VARCHAR2,
                              SP_UBICACION IN VARCHAR2);
END;

/
