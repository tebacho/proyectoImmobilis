--------------------------------------------------------
-- Archivo creado  - miércoles-octubre-28-2015   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package Body PKG_COMUNA
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "IMMOBILIS"."PKG_COMUNA" 		AS				

procedure						
INSERTAR_COMUNA	(					
		COD_RESULTADO	OUT	NUMBER	,	
		MSG_ERROR	OUT	varchar2	,	
		CURSOR_COMUNA	OUT	PKG_COMUNA.REFCURSOR	,	
		SP_ID_COMUNA	IN	NUMBER	,	
		SP_NOMBRE_COMUNA	IN	VARCHAR2	,	
		SP_ID_REGION	IN	NUMBER	)
  as
  begin 
  COD_RESULTADO:=1;
  
INSERT
INTO COMUNA
  (
    ID_COMUNA,
    NOMBRE_COMUNA,
    ID_REGION
  )
  VALUES
  (
    SP_ID_COMUNA,
    SP_NOMBRE_COMUNA,
    SP_ID_REGION
  );
  COD_RESULTADO:=0;

exception
  when others then
    MSG_ERROR:='Error al ingresar comuna';
  end;

procedure						
ACTUALIZAR_COMUNA	(					
		COD_RESULTADO	OUT	NUMBER	,	
		MSG_ERROR	OUT	varchar2	,	
		CURSOR_COMUNA	OUT	PKG_COMUNA.REFCURSOR	,	
		SP_ID_COMUNA	IN	NUMBER	,	
		SP_NOMBRE_COMUNA	IN	VARCHAR2	,	
		SP_ID_REGION	IN	NUMBER)
  as
  begin
  COD_RESULTADO:=1;
UPDATE 
  COMUNA
SET 
  NOMBRE_COMUNA = SP_NOMBRE_COMUNA,
  ID_REGION=SP_ID_REGION
WHERE ID_COMUNA = SP_ID_COMUNA;
COD_RESULTADO:=0;
exception
  when others then
    MSG_ERROR:='Error al actualizar comuna';
  end;
  
    procedure						
Buscar_COMUNA	(					
		COD_RESULTADO	OUT	NUMBER	,	
		MSG_ERROR	OUT	varchar2	,	
		CURSOR_COMUNA	OUT	PKG_COMUNA.REFCURSOR	,	
		SP_ID_COMUNA	IN	NUMBER	,	
		SP_NOMBRE_COMUNA	IN	VARCHAR2	,	
		SP_ID_REGION	IN	NUMBER		
)
as
  
  begin
  COD_RESULTADO:=1;
  open cursor_comuna for
  SELECT 
    ID_COMUNA, NOMBRE_COMUNA, ID_REGION 
  FROM 
    COMUNA
  WHERE 
    ID_REGION like NVL(SP_ID_REGION,'%')
  AND
    NOMBRE_COMUNA like NVL(SP_NOMBRE_COMUNA,'%')
  AND
    ID_COMUNA=NVL(SP_ID_COMUNA,ID_COMUNA);
    COD_RESULTADO:=0;
  Exception
   when others then
    MSG_ERROR:='Error al Buscar comunas';  
  end;
  
procedure FILTRAR_COMUNAS(					
		COD_RESULTADO	OUT	NUMBER	,	
		MSG_ERROR	OUT	varchar2	,	
		CURSOR_COMUNA	OUT	PKG_COMUNA.REFCURSOR	,	
		SP_ID_COMUNA	IN	NUMBER	,	
		SP_NOMBRE_COMUNA	IN	VARCHAR2	,	
		SP_ID_REGION	IN	NUMBER		
)
as
  
  begin
  COD_RESULTADO:=1;
  open cursor_comuna for
  SELECT 
    ID_COMUNA, NOMBRE_COMUNA, ID_REGION 
  FROM 
    COMUNA
  WHERE ID_REGION like NVL(SP_ID_REGION,'%')
  AND 
  NOMBRE_COMUNA LIKE NVL(SP_NOMBRE_COMUNA,'%')
  ;
  COD_RESULTADO:=0;
  exception
  when others then
    MSG_ERROR:='Error al listar comunas';
    
  end;
				
END PKG_COMUNA;

/
