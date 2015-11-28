/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     28-11-2015 18:27:08                          */
/*==============================================================*/


alter table IMMOBILIS.BODEGA
   drop constraint FK_BODEGA_REFERENCE_PROPIEDA;

alter table IMMOBILIS.CASA
   drop constraint FK_CASA_REFERENCE_PROPIEDA;

alter table IMMOBILIS.CLIENTE
   drop constraint FK_CLIENTE_REFERENCE_CONVENIO;

alter table IMMOBILIS.CLIENTE
   drop constraint FK_CLIENTE_REFERENCE_PERSONA;

alter table IMMOBILIS.COMUNA
   drop constraint FK_COMUNA_REFERENCE_REGION;

alter table IMMOBILIS.CONTRATO
   drop constraint FK_CONTRATO_REFERENCE_CLIENTE;

alter table IMMOBILIS.CONTRATO
   drop constraint FK_CONTRATO_REFERENCE_EMPLEADO;

alter table IMMOBILIS.CONTRATO
   drop constraint FK_CONTRATO_REFERENCE_RESERVAP;

alter table IMMOBILIS.DEPARTAMENTO
   drop constraint FK_DEPARTAM_REFERENCE_PROPIEDA;

alter table IMMOBILIS.DOCUMENTO_CONTRATO
   drop constraint FK_DOCUMENT_REFERENCE_CONTRAT2;

alter table IMMOBILIS.DOCUMENTO_RESPALDO
   drop constraint FK_DOCUMENT_REFERENCE_CONTRATO;

alter table IMMOBILIS.EMPLEADO
   drop constraint FK_EMPLEADO_REFERENCE_PERSONA;

alter table IMMOBILIS.ESTACIONAMIENTO
   drop constraint FK_ESTACION_REFERENCE_PROPIEDA;

alter table IMMOBILIS.OFICINA
   drop constraint FK_OFICINA_REFERENCE_PROPIEDA;

alter table IMMOBILIS.PAGO
   drop constraint FK_PAGO_REFERENCE_CONTRATO;

alter table IMMOBILIS.PAGO
   drop constraint FK_PAGO_REFERENCE_CONVERSI;

alter table IMMOBILIS.PERSONA
   drop constraint FK_PERSONA_REFERENCE_COMUNA;

alter table IMMOBILIS.PROPIEDAD
   drop constraint FK_PROPIEDA_REFERENCE_COMUNA;

alter table IMMOBILIS.PROPIEDAD
   drop constraint FK_PROPIEDA_REFERENCE_CONSTRUC;

alter table IMMOBILIS.PROPIEDAD
   drop constraint FK_PROPIEDA_REFERENCE_CONVERSI;

alter table IMMOBILIS.REGISTROUSUARIO
   drop constraint FK_REGISTRO_REFERENCE_PERSONA;

alter table IMMOBILIS.RESERVAPROPIEDAD
   drop constraint FK_RESERVAP_REFERENCE_PROPIEDA;

alter table IMMOBILIS.RESERVAPROPIEDAD
   drop constraint FK_RESERVAP_REFERENCE_TIPORESE;

alter table IMMOBILIS.SEGURO
   drop constraint FK_SEGURO_REFERENCE_CONTRATO;

alter table IMMOBILIS.SEGURO
   drop constraint FK_SEGURO_REFERENCE_RESERVAP;

drop table IMMOBILIS.BODEGA cascade constraints;

drop table IMMOBILIS.CASA cascade constraints;

drop table IMMOBILIS.CLIENTE cascade constraints;

drop table IMMOBILIS.COMUNA cascade constraints;

drop table IMMOBILIS.CONSTRUCTORA cascade constraints;

drop table IMMOBILIS.CONTRATO cascade constraints;

drop table IMMOBILIS.CONVENIO cascade constraints;

drop table CONVERSION cascade constraints;

drop table IMMOBILIS.DEPARTAMENTO cascade constraints;

drop table IMMOBILIS.DOCUMENTO_CONTRATO cascade constraints;

drop table IMMOBILIS.DOCUMENTO_RESPALDO cascade constraints;

drop table IMMOBILIS.EMPLEADO cascade constraints;

drop table IMMOBILIS.ESTACIONAMIENTO cascade constraints;

drop table IMMOBILIS.OFICINA cascade constraints;

drop table IMMOBILIS.PAGO cascade constraints;

drop table IMMOBILIS.PERSONA cascade constraints;

drop table IMMOBILIS.PROPIEDAD cascade constraints;

drop table IMMOBILIS.REGION cascade constraints;

drop table IMMOBILIS.REGISTROUSUARIO cascade constraints;

drop table IMMOBILIS.RESERVAPROPIEDAD cascade constraints;

drop table IMMOBILIS.SEGURO cascade constraints;

drop table IMMOBILIS.TIPORESERVA cascade constraints;

drop user IMMOBILIS;

/*==============================================================*/
/* User: IMMOBILIS                                              */
/*==============================================================*/
create user IMMOBILIS 
  identified by "";

/*==============================================================*/
/* Table: BODEGA                                                */
/*==============================================================*/
create table IMMOBILIS.BODEGA 
(
   ID_PROPIEDAD         NUMBER(5,0)          not null,
   ALTURA               NUMBER(2,1),
   constraint PK_BODEGA primary key (ID_PROPIEDAD)
         USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
        STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
        PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
        TABLESPACE "SYSTEM"  ENABLE
)
SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM";

/*==============================================================*/
/* Table: CASA                                                  */
/*==============================================================*/
create table IMMOBILIS.CASA 
(
   ID_PROPIEDAD         NUMBER(5,0)          not null,
   BANO                 NUMBER(1,0),
   DORMITORIO           NUMBER(1,0),
   CONJUNTO             VARCHAR2(20 BYTE),
   METROSCUADRADOSHABITABLES NUMBER(3,0),
   constraint PK_CASA primary key (ID_PROPIEDAD)
         USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
        STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
        PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
        TABLESPACE "SYSTEM"  ENABLE
)
SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM";

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table IMMOBILIS.CLIENTE 
(
   RUT                  VARCHAR2(10 BYTE)    not null,
   CONVENIO             VARCHAR2(4 BYTE),
   constraint PK_CLIENTE primary key (RUT)
         USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
        STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
        PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
        TABLESPACE "SYSTEM"  ENABLE
)
SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM";

/*==============================================================*/
/* Table: COMUNA                                                */
/*==============================================================*/
create table IMMOBILIS.COMUNA 
(
   ID_COMUNA            NUMBER(5,0)          not null,
   NOMBRE_COMUNA        VARCHAR2(50 BYTE),
   ID_REGION            NUMBER(2,0),
   constraint PK_COMUNA primary key (ID_COMUNA)
         USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
        STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
        PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
        TABLESPACE "SYSTEM"  ENABLE
)
SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM";

/*==============================================================*/
/* Table: CONSTRUCTORA                                          */
/*==============================================================*/
create table IMMOBILIS.CONSTRUCTORA 
(
   ID_CONSTRUCTORA      NUMBER(6,0)          not null,
   NOMBRE               VARCHAR2(50 BYTE),
   constraint PK_CONSTRUCTORA primary key (ID_CONSTRUCTORA)
         USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
        STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
        PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
        TABLESPACE "SYSTEM"  ENABLE
)
SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM";

/*==============================================================*/
/* Table: CONTRATO                                              */
/*==============================================================*/
create table IMMOBILIS.CONTRATO 
(
   ID_CONTRATO          NUMBER(6,0)          not null,
   ID_RESERVA           NUMBER(6,0),
   SEGURO               VARCHAR2(20 BYTE),
   SERVICIO             VARCHAR2(20 BYTE),
   DESCUENTO            NUMBER(3,1),
   RUT                  VARCHAR2(12 BYTE),
   EMP_RUT              VARCHAR2(12 BYTE),
   constraint PK_CONTRATO primary key (ID_CONTRATO)
         USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
        STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
        PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
        TABLESPACE "SYSTEM"  ENABLE
)
SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM";

/*==============================================================*/
/* Table: CONVENIO                                              */
/*==============================================================*/
create table IMMOBILIS.CONVENIO 
(
   ID                   VARCHAR2(4 BYTE)     not null,
   NOMBRE               VARCHAR2(10 BYTE),
   DESCRIPCION          VARCHAR2(40 BYTE),
   DESCUENTO            NUMBER(3,2),
   FECHA_VIGENCIA       DATE,
   constraint PK_CONVENIO primary key (ID)
         USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
        STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
        PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
        TABLESPACE "SYSTEM"  ENABLE
)
SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM";

/*==============================================================*/
/* Table: CONVERSION                                            */
/*==============================================================*/
create table CONVERSION 
(
   ID_CONVERSION        number(10)           not null,
   FECHA_CONVERSION     date                 not null,
   MONEDA_ORIGEN        char(3)              not null,
   MONEDA_DESTINO       CHAR(3)              not null,
   CONVERSION           NUMBER(8,2),
   constraint PK_CONVERSION primary key (ID_CONVERSION)
);

/*==============================================================*/
/* Table: DEPARTAMENTO                                          */
/*==============================================================*/
create table IMMOBILIS.DEPARTAMENTO 
(
   ID_PROPIEDAD         NUMBER(5,0)          not null,
   EDIFICIO             VARCHAR2(20 BYTE),
   BANO                 NUMBER(2,0),
   DORMITORIO           NUMBER(2,0),
   constraint PK_DEPARTAMENTO primary key (ID_PROPIEDAD)
         USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
        STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
        PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
        TABLESPACE "SYSTEM"  ENABLE
)
SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM";

/*==============================================================*/
/* Table: DOCUMENTO_CONTRATO                                    */
/*==============================================================*/
create table IMMOBILIS.DOCUMENTO_CONTRATO 
(
   ID_CONTRATO          NUMBER(6,0)          not null,
   URL_BANCO            VARCHAR2(100 BYTE),
   URL_CONSERVADOR_BIENES_RAICES VARCHAR2(100 BYTE),
   URL_NOTARIA          VARCHAR2(100 BYTE),
   URL_TASACION         VARCHAR2(100 BYTE),
   constraint PK_DOCUMENTO_CONTRATO primary key (ID_CONTRATO)
         USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
        STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
        PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
        TABLESPACE "SYSTEM"  ENABLE
)
SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM";

/*==============================================================*/
/* Table: DOCUMENTO_RESPALDO                                    */
/*==============================================================*/
create table IMMOBILIS.DOCUMENTO_RESPALDO 
(
   ID_CONTRATO          NUMBER(6,0)          not null,
   URL_AVAL             VARCHAR2(100 BYTE),
   URL_BOLETA_HONORARIO VARCHAR2(100 BYTE),
   URL_CONTRATO_TRABAJO VARCHAR2(100 BYTE),
   URL_FOTOCOPIA_CEDULA_IDENTIDAD VARCHAR2(100 BYTE),
   URL_LIQUIDACION_SUELDO VARCHAR2(100 BYTE),
   constraint PK_DOCUMENTO_RESPALDO primary key (ID_CONTRATO)
         USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
        STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
        PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
        TABLESPACE "SYSTEM"  ENABLE
)
SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM";

/*==============================================================*/
/* Table: EMPLEADO                                              */
/*==============================================================*/
create table IMMOBILIS.EMPLEADO 
(
   RUT                  VARCHAR2(12 BYTE)    not null,
   CARGO                VARCHAR2(12 BYTE),
   constraint PK_EMPLEADO primary key (RUT)
         USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
        STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
        PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
        TABLESPACE "SYSTEM"  ENABLE
)
SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM";

/*==============================================================*/
/* Table: ESTACIONAMIENTO                                       */
/*==============================================================*/
create table IMMOBILIS.ESTACIONAMIENTO 
(
   ID_PROPIEDAD         NUMBER(5,0)          not null,
   NIVEL                NUMBER(2,0),
   constraint PK_ESTACIONAMIENTO primary key (ID_PROPIEDAD)
         USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
        STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
        PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
        TABLESPACE "SYSTEM"  ENABLE
)
SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM";

/*==============================================================*/
/* Table: OFICINA                                               */
/*==============================================================*/
create table IMMOBILIS.OFICINA 
(
   ID_PROPIEDAD         NUMBER(5,0)          not null,
   PATENTECOMERCIAL     NUMBER(10,0),
   constraint PK_OFICINA primary key (ID_PROPIEDAD)
         USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
        STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
        PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
        TABLESPACE "SYSTEM"  ENABLE
)
SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM";

/*==============================================================*/
/* Table: PAGO                                                  */
/*==============================================================*/
create table IMMOBILIS.PAGO 
(
   ESTADO_PAGO          VARCHAR2(8 BYTE),
   FECHA_VENCIMIENTO    DATE,
   ID_VENCIMIENTO       NUMBER(5,0)          not null,
   ID_CONTRATO          NUMBER(5,0),
   ID_CONVERSION        number(10),
   MONTO_CUOTA          NUMBER(10,2),
   N_CUOTA              NUMBER(2,0),
   COMISION             NUMBER(3,2),
   FECHA_PAGADA         DATE,
   constraint PK_PAGO primary key (ID_VENCIMIENTO)
         USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
        STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
        PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
        TABLESPACE "SYSTEM"  ENABLE
)
SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM";

/*==============================================================*/
/* Table: PERSONA                                               */
/*==============================================================*/
create table IMMOBILIS.PERSONA 
(
   RUT                  VARCHAR2(10 BYTE)    not null,
   ID_COMUNA            NUMBER(5,0),
   NOMBRE               VARCHAR2(30 BYTE),
   PATERNO              VARCHAR2(15 BYTE),
   MATERNO              VARCHAR2(15 BYTE),
   SEXO                 CHAR(1 BYTE),
   DIRECCION            VARCHAR2(30 BYTE),
   FECHA_NACIMIENTO     DATE,
   MAIL                 VARCHAR2(50 BYTE),
   FECHA_INGRESO        DATE,
   TELEFONO             VARCHAR2(12 BYTE),
   constraint PK_PERSONA primary key (RUT)
         USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
        STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
        PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
        TABLESPACE "SYSTEM"  ENABLE
)
SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM";

/*==============================================================*/
/* Table: PROPIEDAD                                             */
/*==============================================================*/
create table IMMOBILIS.PROPIEDAD 
(
   ID_PROPIEDAD         NUMBER(5,0)          not null,
   ID_COMUNA            NUMBER(5,0),
   ID_CONSTRUCTORA      NUMBER(6,0),
   ID_CONVERSION        number(10),
   TIPO_PROPIEDAD       VARCHAR2(20 BYTE),
   DESCRIPCION          VARCHAR2(400 BYTE),
   OPERACION            VARCHAR2(10 BYTE),
   DISPONIBLE           CHAR(1 BYTE),
   PROYECTO             VARCHAR2(20 BYTE),
   METROS_CUADRADOS     NUMBER(5,0),
   PRECIO_UF            NUMBER(6,0),
   DIRECCION            VARCHAR(50),
   constraint PK_PROPIEDAD primary key (ID_PROPIEDAD)
         USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
        STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
        PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
        TABLESPACE "SYSTEM"  ENABLE
)
SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM";

/*==============================================================*/
/* Table: REGION                                                */
/*==============================================================*/
create table IMMOBILIS.REGION 
(
   ID_REGION            NUMBER(2,0)          not null,
   NOMBRE_REGION        VARCHAR2(100 BYTE),
   constraint PK_REGION primary key (ID_REGION)
         USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
        STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
        PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
        TABLESPACE "SYSTEM"  ENABLE
)
SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM";

/*==============================================================*/
/* Table: REGISTROUSUARIO                                       */
/*==============================================================*/
create table IMMOBILIS.REGISTROUSUARIO 
(
   RUT                  VARCHAR2(12 BYTE)    not null,
   ACTIVO               NUMBER(1,0),
   PASSWORD             VARCHAR2(7 BYTE),
   constraint REGISTROUSUARIO primary key (RUT)
         USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
        STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
        PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
        TABLESPACE "SYSTEM"  ENABLE
)
SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM";

/*==============================================================*/
/* Table: RESERVAPROPIEDAD                                      */
/*==============================================================*/
create table IMMOBILIS.RESERVAPROPIEDAD 
(
   ID_RESERVA           NUMBER(5,0)          not null,
   ID_PROPIEDAD         NUMBER(5,0),
   ID_TIPO_RESERVA      NUMBER(1,0),
   FECHA                DATE,
   RUT                  VARCHAR2(10 BYTE),
   constraint PK_RESERVAPROPIEDAD primary key (ID_RESERVA)
         USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
        STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
        PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
        TABLESPACE "SYSTEM"  ENABLE
)
SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM";

/*==============================================================*/
/* Table: SEGURO                                                */
/*==============================================================*/
create table IMMOBILIS.SEGURO 
(
   ID_RESERVA           NUMBER(5,0)          not null,
   ID_CONTRATO          NUMBER(5,0),
   ID_SEGURO            NUMBER(5,0)          not null,
   COMPANIA             VARCHAR2(20 BYTE),
   MONTO                NUMBER(6,0),
   GLOSA                VARCHAR2(400 BYTE),
   constraint PK_SEGURO primary key (ID_RESERVA, ID_SEGURO)
         USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
        STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
        PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
        TABLESPACE "SYSTEM"  ENABLE
)
SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM";

/*==============================================================*/
/* Table: TIPORESERVA                                           */
/*==============================================================*/
create table IMMOBILIS.TIPORESERVA 
(
   ID_TIPO_RESERVA      NUMBER(1,0)          not null,
   DESCRIPCION          VARCHAR2(10 BYTE),
   constraint PK_TIPORESERVA primary key (ID_TIPO_RESERVA)
         USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
        STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
        PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
        TABLESPACE "SYSTEM"  ENABLE
)
SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM";

alter table IMMOBILIS.BODEGA
   add constraint FK_BODEGA_REFERENCE_PROPIEDA foreign key (ID_PROPIEDAD)
      references IMMOBILIS.PROPIEDAD (ID_PROPIEDAD);

alter table IMMOBILIS.CASA
   add constraint FK_CASA_REFERENCE_PROPIEDA foreign key (ID_PROPIEDAD)
      references IMMOBILIS.PROPIEDAD (ID_PROPIEDAD);

alter table IMMOBILIS.CLIENTE
   add constraint FK_CLIENTE_REFERENCE_CONVENIO foreign key (CONVENIO)
      references IMMOBILIS.CONVENIO (ID);

alter table IMMOBILIS.CLIENTE
   add constraint FK_CLIENTE_REFERENCE_PERSONA foreign key (RUT)
      references IMMOBILIS.PERSONA (RUT);

alter table IMMOBILIS.COMUNA
   add constraint FK_COMUNA_REFERENCE_REGION foreign key (ID_REGION)
      references IMMOBILIS.REGION (ID_REGION);

alter table IMMOBILIS.CONTRATO
   add constraint FK_CONTRATO_REFERENCE_CLIENTE foreign key (RUT)
      references IMMOBILIS.CLIENTE (RUT);

alter table IMMOBILIS.CONTRATO
   add constraint FK_CONTRATO_REFERENCE_EMPLEADO foreign key (EMP_RUT)
      references IMMOBILIS.EMPLEADO (RUT);

alter table IMMOBILIS.CONTRATO
   add constraint FK_CONTRATO_REFERENCE_RESERVAP foreign key (ID_RESERVA)
      references IMMOBILIS.RESERVAPROPIEDAD (ID_RESERVA);

alter table IMMOBILIS.DEPARTAMENTO
   add constraint FK_DEPARTAM_REFERENCE_PROPIEDA foreign key (ID_PROPIEDAD)
      references IMMOBILIS.PROPIEDAD (ID_PROPIEDAD);

alter table IMMOBILIS.DOCUMENTO_CONTRATO
   add constraint FK_DOCUMENT_REFERENCE_CONTRAT2 foreign key (ID_CONTRATO)
      references IMMOBILIS.CONTRATO (ID_CONTRATO);

alter table IMMOBILIS.DOCUMENTO_RESPALDO
   add constraint FK_DOCUMENT_REFERENCE_CONTRATO foreign key (ID_CONTRATO)
      references IMMOBILIS.CONTRATO (ID_CONTRATO);

alter table IMMOBILIS.EMPLEADO
   add constraint FK_EMPLEADO_REFERENCE_PERSONA foreign key (RUT)
      references IMMOBILIS.PERSONA (RUT);

alter table IMMOBILIS.ESTACIONAMIENTO
   add constraint FK_ESTACION_REFERENCE_PROPIEDA foreign key (ID_PROPIEDAD)
      references IMMOBILIS.PROPIEDAD (ID_PROPIEDAD);

alter table IMMOBILIS.OFICINA
   add constraint FK_OFICINA_REFERENCE_PROPIEDA foreign key (ID_PROPIEDAD)
      references IMMOBILIS.PROPIEDAD (ID_PROPIEDAD);

alter table IMMOBILIS.PAGO
   add constraint FK_PAGO_REFERENCE_CONTRATO foreign key (ID_CONTRATO)
      references IMMOBILIS.CONTRATO (ID_CONTRATO);

alter table IMMOBILIS.PAGO
   add constraint FK_PAGO_REFERENCE_CONVERSI foreign key (ID_CONVERSION)
      references CONVERSION (ID_CONVERSION);

alter table IMMOBILIS.PERSONA
   add constraint FK_PERSONA_REFERENCE_COMUNA foreign key (ID_COMUNA)
      references IMMOBILIS.COMUNA (ID_COMUNA);

alter table IMMOBILIS.PROPIEDAD
   add constraint FK_PROPIEDA_REFERENCE_COMUNA foreign key (ID_COMUNA)
      references IMMOBILIS.COMUNA (ID_COMUNA);

alter table IMMOBILIS.PROPIEDAD
   add constraint FK_PROPIEDA_REFERENCE_CONSTRUC foreign key (ID_CONSTRUCTORA)
      references IMMOBILIS.CONSTRUCTORA (ID_CONSTRUCTORA);

alter table IMMOBILIS.PROPIEDAD
   add constraint FK_PROPIEDA_REFERENCE_CONVERSI foreign key (ID_CONVERSION)
      references CONVERSION (ID_CONVERSION);

alter table IMMOBILIS.REGISTROUSUARIO
   add constraint FK_REGISTRO_REFERENCE_PERSONA foreign key (RUT)
      references IMMOBILIS.PERSONA (RUT);

alter table IMMOBILIS.RESERVAPROPIEDAD
   add constraint FK_RESERVAP_REFERENCE_PROPIEDA foreign key (ID_PROPIEDAD)
      references IMMOBILIS.PROPIEDAD (ID_PROPIEDAD);

alter table IMMOBILIS.RESERVAPROPIEDAD
   add constraint FK_RESERVAP_REFERENCE_TIPORESE foreign key (ID_TIPO_RESERVA)
      references IMMOBILIS.TIPORESERVA (ID_TIPO_RESERVA);

alter table IMMOBILIS.SEGURO
   add constraint FK_SEGURO_REFERENCE_CONTRATO foreign key (ID_CONTRATO)
      references IMMOBILIS.CONTRATO (ID_CONTRATO);

alter table IMMOBILIS.SEGURO
   add constraint FK_SEGURO_REFERENCE_RESERVAP foreign key (ID_RESERVA)
      references IMMOBILIS.RESERVAPROPIEDAD (ID_RESERVA);

