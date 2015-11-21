--------------------------------------------------------
-- Archivo creado  - miércoles-octubre-28-2015   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package PKG_CLIENTE
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "IMMOBILIS"."PKG_CLIENTE" AS

TYPE RefCursor is REF CURSOR;

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
                              );
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
                              );
                              
procedure SP_BUSCAR_CLIENTE( sp_rut varchar2,
                              cod_resultado out number,
                              msg_error out varchar2,
                              cursorUsuario out PKG_CLIENTE.RefCursor
                              );
procedure SP_VALIDAR_CLIENTE( sp_rut varchar2,
                              sp_password varchar2,
                              cod_resultado out number,
                              msg_error out varchar2,
                              cursorUsuario out PKG_CLIENTE.RefCursor
                              );                              
END "PKG_CLIENTE";

/
