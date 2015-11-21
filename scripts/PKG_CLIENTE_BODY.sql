--------------------------------------------------------
-- Archivo creado  - miércoles-octubre-28-2015   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package Body PKG_CLIENTE
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "IMMOBILIS"."PKG_CLIENTE" AS

procedure SP_INGRESA_NUEVO_CLIENTE( 
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
                              sp_password in varchar2,
                              cod_resultado out number,
                              msg_error out varchar2
                              )
IS
  coincidencias number(9);
BEGIN
  cod_resultado:=1;
  
 /* select count(per.RUT) into coincidencias from PERSONA per where per.RUT=sp_rut;
  
  IF coincidencias > 0 then
  
  raise NO_DATA_FOUND;
  
  end if;
  */
INSERT
INTO PERSONA
  (
    RUT,
    ID_COMUNA,
    NOMBRE,
    PATERNO,
    MATERNO,
    SEXO,
    DIRECCION,
    FECHA_NACIMIENTO,
    MAIL,
    FECHA_INGRESO,
    TELEFONO
  )
  VALUES
  (
    sp_rut,
    sp_comuna,
    sp_nombre,
    sp_paterno,
    sp_materno,
    sp_sexo,
    sp_direccion,
    sp_fechaNacimiento,
    sp_email,
    sysdate,
    sp_telefono
    );
    cod_resultado:=2;
  
  INSERT INTO 
    REGISTROUSUARIO
  (RUT, ACTIVO, PASSWORD ) 
  VALUES
  (sp_rut, 1, sp_password);
    
  cod_resultado:=0;
  

  EXCEPTION WHEN OTHERS THEN
  msg_error := 'ERROR: ' || SQLERRM || ' (' || SQLCODE  || ')';
END;

procedure SP_ACTUALIZA_CLIENTE(  sp_rut in varchar2,
                              sp_nombre in varchar2,
                              sp_paterno in varchar2,
                              sp_materno in varchar2,
                              sp_sexo in varchar2,
                              sp_direccion in varchar2,
                              sp_fechaNacimiento in DATE,
                              sp_telefono in varchar2,
                              sp_email in varchar2,
                              sp_comuna in number,
                              sp_password in varchar2,
                              cod_resultado out number,
                              msg_error out varchar2
                              )
IS
 coincidencias number(9);
BEGIN
  cod_resultado:=1;
  select count(per.RUT) into coincidencias from PERSONA per where per.RUT=sp_rut;
  IF (coincidencias = 0) then
  
  raise TOO_MANY_ROWS;
  
  end if;
  
  update 
    persona 
  set 	
    RUT	=	sp_RUT	,			
    ID_COMUNA	=	sp_COMUNA	,			
    NOMBRE	=	sp_NOMBRE	,			
    PATERNO	=	sp_PATERNO	,			
    MATERNO	=	sp_MATERNO	,			
    SEXO	=	sp_SEXO	,			
    DIRECCION	=	sp_DIRECCION	,			
    FECHA_NACIMIENTO	=	sp_FECHANACIMIENTO	,			
    MAIL	=	sp_eMAIL	,					
    TELEFONO	=	sp_TELEFONO	
  where	
    RUT	=sp_RUT;
    
UPDATE 
  REGISTROUSUARIO
SET  
  PASSWORD = sp_password
where 
  rut=sp_rut
and 
    ACTIVO=1;

INSERT INTO CLIENTE
  (RUT, CONVENIO
  ) VALUES
  (sp_rut, 'A'
  );
    
  cod_resultado:=0;
  
  EXCEPTION WHEN OTHERS THEN
  msg_error := 'ERROR: ' || SQLERRM || ' (' || SQLCODE  || ')';
END;
                              
procedure SP_BUSCAR_CLIENTE ( sp_rut varchar2,
                              cod_resultado out number,
                              msg_error out varchar2,
                              cursorUsuario out PKG_CLIENTE.RefCursor
                              )
IS
BEGIN
  cod_resultado:=0;
 open cursorUsuario for 
SELECT 
  PER.RUT,
  PER.ID_COMUNA,
  PER.NOMBRE,
  PER.PATERNO,
  PER.MATERNO,
  PER.SEXO,
  PER.DIRECCION,
  PER.FECHA_NACIMIENTO,
  PER.MAIL,
  PER.FECHA_INGRESO,
  PER.TELEFONO
  

FROM 
  PERSONA PER
join 
  REGISTROUSUARIO reg on PER.RUT = reg.RUT
where 
  reg.activo =1
AND 
  per.rut=sp_rut;
  
  cod_resultado:=0;
  
 EXCEPTION WHEN OTHERS THEN
  msg_error :='Ha ocurrido un error al buscar al cliente '||sp_rut;  
  
END;

procedure SP_VALIDAR_CLIENTE( sp_rut varchar2,
                              sp_password varchar2,
                              cod_resultado out number,
                              msg_error out varchar2,
                              cursorUsuario out PKG_CLIENTE.RefCursor
                              )
 IS
BEGIN
  cod_resultado:=0;
 open cursorUsuario for 
SELECT 
  PER.RUT,
  PER.NOMBRE,
  PER.PATERNO,
  PER.MATERNO,
  PER.SEXO,
  PER.DIRECCION,
  PER.FECHA_NACIMIENTO,
  PER.MAIL,
  PER.FECHA_INGRESO,
  PER.TELEFONO
FROM 
  PERSONA PER
join 
  REGISTROUSUARIO reg on PER.RUT = reg.RUT
where 
  reg.activo =1
AND 
  per.rut=sp_rut
AND
  reg.PASSWORD=sp_password;
  
  cod_resultado:=0;
  
 EXCEPTION WHEN OTHERS THEN
  msg_error :='Ha ocurrido un error al buscar al cliente '||sp_rut;  
  
END;                             

END "PKG_CLIENTE";

/
