/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     24-11-2015 0:37:15                           */
/*==============================================================*/


alter table BODEGA
   drop constraint FK_BODEGA_REFERENCE_PROPIEDA;

alter table CASA
   drop constraint FK_CASA_REFERENCE_PROPIEDA;

alter table CLIENTE
   drop constraint FK_CLIENTE_REFERENCE_PERSONA;

alter table CLIENTE
   drop constraint FK_CLIENTE_REFERENCE_CONVENIO;

alter table COMUNA
   drop constraint FK_COMUNA_REFERENCE_REGION;

alter table CONTRATO
   drop constraint FK_CONTRATO_REFERENCE_CLIENTE;

alter table CONTRATO
   drop constraint FK_CONTRATO_REFERENCE_EMPLEADO;

alter table CONTRATO
   drop constraint FK_CONTRATO_REFERENCE_RESERVAP;

alter table DEPARTAMENTO
   drop constraint FK_DEPARTAM_REFERENCE_PROPIEDA;

alter table DOCUMENTO_CONTRATO
   drop constraint FK_DOCUMENT_REFERENCE_CONTRAT2;

alter table DOCUMENTO_RESPALDO
   drop constraint FK_DOCUMENT_REFERENCE_CONTRATO;

alter table EMPLEADO
   drop constraint FK_EMPLEADO_REFERENCE_PERSONA;

alter table ESTACIONAMIENTO
   drop constraint FK_ESTACION_REFERENCE_PROPIEDA;

alter table OFICINA
   drop constraint FK_OFICINA_REFERENCE_PROPIEDA;

alter table PAGO
   drop constraint FK_PAGO_REFERENCE_CONTRATO;

alter table PERSONA
   drop constraint FK_PERSONA_REFERENCE_COMUNA;

alter table PROPIEDAD
   drop constraint FK_PROPIEDA_REFERENCE_COMUNA;

alter table PROPIEDAD
   drop constraint FK_PROPIEDA_REFERENCE_CONSTRUC;

alter table REGISTROUSUARIO
   drop constraint FK_REGISTRO_REFERENCE_PERSONA;

alter table RESERVAPROPIEDAD
   drop constraint FK_RESERVAP_REFERENCE_PROPIEDA;

alter table RESERVAPROPIEDAD
   drop constraint FK_RESERVAP_REFERENCE_TIPORESE;

alter table SEGURO
   drop constraint FK_SEGURO_REFERENCE_CONTRATO;

alter table SEGURO
   drop constraint FK_SEGURO_REFERENCE_RESERVAP;

drop table BODEGA cascade constraints;

drop table CASA cascade constraints;

drop table CLIENTE cascade constraints;

drop table COMUNA cascade constraints;

drop table CONSTRUCTORA cascade constraints;

drop table CONTRATO cascade constraints;

drop table CONVENIO cascade constraints;

drop table DEPARTAMENTO cascade constraints;

drop table DOCUMENTO_CONTRATO cascade constraints;

drop table DOCUMENTO_RESPALDO cascade constraints;

drop table EMPLEADO cascade constraints;

drop table ESTACIONAMIENTO cascade constraints;

drop table OFICINA cascade constraints;

drop table PAGO cascade constraints;

drop table PERSONA cascade constraints;

drop table PROPIEDAD cascade constraints;

drop table REGION cascade constraints;

drop table REGISTROUSUARIO cascade constraints;

drop table RESERVAPROPIEDAD cascade constraints;

drop table SEGURO cascade constraints;

drop table TIPORESERVA cascade constraints;

/*==============================================================*/
/* Table: BODEGA                                                */
/*==============================================================*/
create table BODEGA 
(
   ID_PROPIEDAD         Number(5)            not null,
   ALTURA               Number(2,1),
   constraint PK_BODEGA primary key (ID_PROPIEDAD)
);

/*==============================================================*/
/* Table: CASA                                                  */
/*==============================================================*/
create table CASA 
(
   ID_PROPIEDAD         Number(5)            not null,
   BANO                 Number(1),
   DORMITORIO           Number(1),
   CONJUNTO             VARCHAR2(20),
   METROSCUADRADOSHABITABLES Number(3),
   constraint PK_CASA primary key (ID_PROPIEDAD)
);

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE 
(
   RUT                  VARCHAR2(10)         not null,
   CONVENIO             VARCHAR2(4),
   constraint PK_CLIENTE primary key (RUT)
);

/*==============================================================*/
/* Table: COMUNA                                                */
/*==============================================================*/
create table COMUNA 
(
   ID_COMUNA            Number(4)            not null,
   NOMBRE_COMUNA        VARCHAR(50),
   ID_REGION            number(2),
   constraint PK_COMUNA primary key (ID_COMUNA)
);

/*==============================================================*/
/* Table: CONSTRUCTORA                                          */
/*==============================================================*/
create table CONSTRUCTORA 
(
   ID_CONSTRUCTORA      Number(6)            not null,
   NOMBRE               VARCHAR(50),
   constraint PK_CONSTRUCTORA primary key (ID_CONSTRUCTORA)
);

/*==============================================================*/
/* Table: CONTRATO                                              */
/*==============================================================*/
create table CONTRATO 
(
   ID_CONTRATO          Number(6)            not null,
   ID_RESERVA           Number(6),
   SEGURO               VARCHAR(20),
   SERVICIO             VARCHAR(20),
   DESCUENTO            Number(3,1),
   RUT                  VARCHAR2(12),
   EMP_RUT              VARCHAR2(12),
   constraint PK_CONTRATO primary key (ID_CONTRATO)
);

/*==============================================================*/
/* Table: CONVENIO                                              */
/*==============================================================*/
create table CONVENIO 
(
   ID                   varchar2(4),
   NOMBRE               varchar2(10),
   DESCRIPCION          varchar2(40),
   DESCUENTO            number(3,2),
   FECHA_VIGENCIA       date
);

/*==============================================================*/
/* Table: DEPARTAMENTO                                          */
/*==============================================================*/
create table DEPARTAMENTO 
(
   ID_PROPIEDAD         Number(5)            not null,
   EDIFICIO             VARCHAR2(20),
   BANO                 Number(2),
   DORMITORIO           Number(2),
   constraint PK_DEPARTAMENTO primary key (ID_PROPIEDAD)
);

/*==============================================================*/
/* Table: DOCUMENTO_CONTRATO                                    */
/*==============================================================*/
create table DOCUMENTO_CONTRATO 
(
   ID_CONTRATO          Number(6)            not null,
   URL_BANCO            VARCHAR2(100),
   URL_CONSERVADOR_BIENES_RAICES VARCHAR2(100),
   URL_NOTARIA          VARCHAR2(100),
   URL_TASACION         VARCHAR2(100),
   constraint PK_DOCUMENTO_CONTRATO primary key (ID_CONTRATO)
);

/*==============================================================*/
/* Table: DOCUMENTO_RESPALDO                                    */
/*==============================================================*/
create table DOCUMENTO_RESPALDO 
(
   ID_CONTRATO          Number(6)            not null,
   URL_AVAL             VARCHAR2(100),
   URL_BOLETA_HONORARIO VARCHAR2(100),
   URL_CONTRATO_TRABAJO VARCHAR2(100),
   URL_FOTOCOPIA_CEDULA_IDENTIDAD VARCHAR2(100),
   URL_LIQUIDACION_SUELDO VARCHAR2(100),
   constraint PK_DOCUMENTO_RESPALDO primary key (ID_CONTRATO)
);

/*==============================================================*/
/* Table: EMPLEADO                                              */
/*==============================================================*/
create table EMPLEADO 
(
   RUT                  VARCHAR2(12)         not null,
   CARGO                VARCHAR2(12),
   constraint PK_EMPLEADO primary key (RUT)
);

/*==============================================================*/
/* Table: ESTACIONAMIENTO                                       */
/*==============================================================*/
create table ESTACIONAMIENTO 
(
   ID_PROPIEDAD         Number(5)            not null,
   NIVEL                Number(2),
   constraint PK_ESTACIONAMIENTO primary key (ID_PROPIEDAD)
);

/*==============================================================*/
/* Table: OFICINA                                               */
/*==============================================================*/
create table OFICINA 
(
   ID_PROPIEDAD         Number(5)            not null,
   PATENTECOMERCIAL     Number(10),
   constraint PK_OFICINA primary key (ID_PROPIEDAD)
);

/*==============================================================*/
/* Table: PAGO                                                  */
/*==============================================================*/
create table PAGO 
(
   ESTADO_PAGO          VARCHAR2(8),
   FECHA_VENCIMIENTO    DATE,
   ID_VENCIMIENTO       Number(5)            not null,
   ID_CONTRATO          Number(5),
   MONTO_CUOTA          Number(10,2),
   N_CUOTA              Number(2),
   COMISION             Numeber(3,2),
   constraint PK_PAGO primary key (ID_VENCIMIENTO)
);

/*==============================================================*/
/* Table: PERSONA                                               */
/*==============================================================*/
create table PERSONA 
(
   RUT                  VARCHAR2(10)         not null,
   ID_COMUNA            Number(4),
   NOMBRE               VARCHAR2(30),
   PATERNO              VARCHAR2(15),
   MATERNO              VARCHAR2(15),
   SEXO                 CHAR(1),
   DIRECCION            VARCHAR2(30),
   FECHA_NACIMIENTO     DATE,
   MAIL                 VARCHAR2(50),
   FECHA_INGRESO        DATE,
   TELEFONO             VARCHAR2(12),
   constraint PK_PERSONA primary key (RUT)
);

/*==============================================================*/
/* Table: PROPIEDAD                                             */
/*==============================================================*/
create table PROPIEDAD 
(
   ID_PROPIEDAD         Number(5)            not null,
   ID_COMUNA            Number(3),
   ID_CONSTRUCTORA      Number(6),
   TIPO_PROPIEDAD       VARCHAR2(20),
   DESCRIPCION          VARCHAR(400),
   PRECIO               Number(12),
   OPERACION            VARCHAR2(10),
   DISPONIBLE           CHAR(1),
   constraint PK_PROPIEDAD primary key (ID_PROPIEDAD)
);

/*==============================================================*/
/* Table: REGION                                                */
/*==============================================================*/
create table REGION 
(
   ID_REGION            Number(2)            not null,
   NOMBRE_REGION        VARCHAR(100),
   constraint PK_REGION primary key (ID_REGION)
);

/*==============================================================*/
/* Table: REGISTROUSUARIO                                       */
/*==============================================================*/
create table REGISTROUSUARIO 
(
   RUT                  VARCHAR2(12)         not null,
   ACTIVO               number(1),
   PASSWORD             VARCHAR2(7)          not null,
   constraint REGISTROUSUARIO primary key (RUT)
);

/*==============================================================*/
/* Table: RESERVAPROPIEDAD                                      */
/*==============================================================*/
create table RESERVAPROPIEDAD 
(
   ID_RESERVA           Number(5)            not null,
   ID_PROPIEDAD         Number(5),
   ID_TIPO_RESERVA      Number(1),
   FECHA                DATE,
   RUT                  VARCHAR2(10),
   constraint PK_RESERVAPROPIEDAD primary key (ID_RESERVA)
);

/*==============================================================*/
/* Table: SEGURO                                                */
/*==============================================================*/
create table SEGURO 
(
   ID_RESERVA           Number(5)            not null,
   ID_CONTRATO          Number(5)            not null,
   ID_SEGURO            Number(5)            not null,
   COMPANIA             VARCHAR2(20),
   MONTO                Number(6),
   GLOSA                varchar2(400),
   constraint PK_SEGURO primary key (ID_RESERVA, ID_SEGURO)
);

/*==============================================================*/
/* Table: TIPORESERVA                                           */
/*==============================================================*/
create table TIPORESERVA 
(
   ID_TIPO_RESERVA      Number(1)            not null,
   DESCRIPCION          VARCHAR2(10),
   constraint PK_TIPORESERVA primary key (ID_TIPO_RESERVA)
);

alter table BODEGA
   add constraint FK_BODEGA_REFERENCE_PROPIEDA foreign key (ID_PROPIEDAD)
      references PROPIEDAD (ID_PROPIEDAD);

alter table CASA
   add constraint FK_CASA_REFERENCE_PROPIEDA foreign key (ID_PROPIEDAD)
      references PROPIEDAD (ID_PROPIEDAD);

alter table CLIENTE
   add constraint FK_CLIENTE_REFERENCE_PERSONA foreign key (RUT)
      references PERSONA (RUT);

alter table CLIENTE
   add constraint FK_CLIENTE_REFERENCE_CONVENIO foreign key (CONVENIO)
      references CONVENIO (ID);

alter table COMUNA
   add constraint FK_COMUNA_REFERENCE_REGION foreign key (ID_REGION)
      references REGION (ID_REGION);

alter table CONTRATO
   add constraint FK_CONTRATO_REFERENCE_CLIENTE foreign key (RUT)
      references CLIENTE (RUT);

alter table CONTRATO
   add constraint FK_CONTRATO_REFERENCE_EMPLEADO foreign key (EMP_RUT)
      references EMPLEADO (RUT);

alter table CONTRATO
   add constraint FK_CONTRATO_REFERENCE_RESERVAP foreign key (ID_RESERVA)
      references RESERVAPROPIEDAD (ID_RESERVA);

alter table DEPARTAMENTO
   add constraint FK_DEPARTAM_REFERENCE_PROPIEDA foreign key (ID_PROPIEDAD)
      references PROPIEDAD (ID_PROPIEDAD);

alter table DOCUMENTO_CONTRATO
   add constraint FK_DOCUMENT_REFERENCE_CONTRAT2 foreign key (ID_CONTRATO)
      references CONTRATO (ID_CONTRATO);

alter table DOCUMENTO_RESPALDO
   add constraint FK_DOCUMENT_REFERENCE_CONTRATO foreign key (ID_CONTRATO)
      references CONTRATO (ID_CONTRATO);

alter table EMPLEADO
   add constraint FK_EMPLEADO_REFERENCE_PERSONA foreign key (RUT)
      references PERSONA (RUT);

alter table ESTACIONAMIENTO
   add constraint FK_ESTACION_REFERENCE_PROPIEDA foreign key (ID_PROPIEDAD)
      references PROPIEDAD (ID_PROPIEDAD);

alter table OFICINA
   add constraint FK_OFICINA_REFERENCE_PROPIEDA foreign key (ID_PROPIEDAD)
      references PROPIEDAD (ID_PROPIEDAD);

alter table PAGO
   add constraint FK_PAGO_REFERENCE_CONTRATO foreign key (ID_CONTRATO)
      references CONTRATO (ID_CONTRATO);

alter table PERSONA
   add constraint FK_PERSONA_REFERENCE_COMUNA foreign key (ID_COMUNA)
      references COMUNA (ID_COMUNA);

alter table PROPIEDAD
   add constraint FK_PROPIEDA_REFERENCE_COMUNA foreign key (ID_COMUNA)
      references COMUNA (ID_COMUNA);

alter table PROPIEDAD
   add constraint FK_PROPIEDA_REFERENCE_CONSTRUC foreign key (ID_CONSTRUCTORA)
      references CONSTRUCTORA (ID_CONSTRUCTORA);

alter table REGISTROUSUARIO
   add constraint FK_REGISTRO_REFERENCE_PERSONA foreign key (RUT)
      references PERSONA (RUT);

alter table RESERVAPROPIEDAD
   add constraint FK_RESERVAP_REFERENCE_PROPIEDA foreign key (ID_PROPIEDAD)
      references PROPIEDAD (ID_PROPIEDAD);

alter table RESERVAPROPIEDAD
   add constraint FK_RESERVAP_REFERENCE_TIPORESE foreign key (ID_TIPO_RESERVA)
      references TIPORESERVA (ID_TIPO_RESERVA);

alter table SEGURO
   add constraint FK_SEGURO_REFERENCE_CONTRATO foreign key (ID_CONTRATO)
      references CONTRATO (ID_CONTRATO);

alter table SEGURO
   add constraint FK_SEGURO_REFERENCE_RESERVAP foreign key (ID_RESERVA)
      references RESERVAPROPIEDAD (ID_RESERVA);

