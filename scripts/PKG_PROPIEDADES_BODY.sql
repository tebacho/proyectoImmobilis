--------------------------------------------------------
-- Archivo creado  - mi�rcoles-octubre-28-2015   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package Body PKG_PROPIEDADES
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "IMMOBILIS"."PKG_PROPIEDADES" 		AS				


procedure FILTER_PROPIEDADES (
                              COD_RESULTADO	OUT	NUMBER	,	
                              MSG_ERROR	OUT	varchar2	,	
                              CURSOR_PROPIEDAD	OUT	PKG_COMUNA.REFCURSOR	,
                              SP_TIPO_OPERACION IN VARCHAR2,
                              SP_TIPO_PROPIEDAD IN VARCHAR2,
                              SP_UBICACION IN VARCHAR2)
AS 

BEGIN


COD_RESULTADO:=1;

OPEN CURSOR_PROPIEDAD FOR


SELECT ID_PROPIEDAD,
  PRO.ID_COMUNA,
  PRO.ID_INMOBILIARIA,
  PRO.TIPO_PROPIEDAD,
  PRO.DESCRIPCION,
  PRO.PRECIO,
  PRO.OPERACION,
  PRO.DISPONIBLE,
  CO.NOMBRE_COMUNA,
  RE.NOMBRE_REGION
  
FROM 
  PROPIEDAD PRO
JOIN 
  COMUNA CO ON CO.ID_COMUNA = PRO.ID_COMUNA
JOIN 
  REGION RE ON RE.ID_REGION=CO.ID_REGION
JOIN 
  INMOBILIARIA IMM ON PRO.ID_INMOBILIARIA = IMM.ID_INMOBILIARIA
WHERE
  PRO.TIPO_PROPIEDAD LIKE NVL(SP_TIPO_PROPIEDAD,'%')
AND
  PRO.OPERACION LIKE NVL(SP_TIPO_OPERACION,'%')
  
AND (CO.NOMBRE_COMUNA LIKE NVL(SP_UBICACION,'%') OR RE.NOMBRE_REGION LIKE NVL(SP_UBICACION,'%') )

AND PRO.DISPONIBLE = 'Y';

COD_RESULTADO:=0;

EXCEPTION 
WHEN OTHERS THEN

MSG_ERROR:= 'ERROR AL FILTRAR';
END;
END;

/
