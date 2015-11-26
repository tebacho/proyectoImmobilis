--------------------------------------------------------
-- Archivo creado  - miércoles-octubre-28-2015   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package Body PKG_PAGOS
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "IMMOBILIS"."PKG_PAGOS" 		AS				


  procedure SP_ADD_PAGO (
                              COD_RESULTADO			  OUT	NUMBER	,	
                              MSG_ERROR				  OUT	varchar2	,	
                              CURSOR_PAGOS		  OUT	PKG_PAGOS.REFCURSOR,
                              SP_ESTADO_PAGO          IN VARCHAR2,
                              SP_FECHA_VENCIMIENTO    IN DATE,
                              SP_ID_VENCIMIENTO       IN Number,
                              SP_ID_CONTRATO          IN Number,
                              SP_MONTO_CUOTA          IN Number,
                              SP_N_CUOTA              IN Number,
                              SP_COMISION             IN Number
							  )
AS 

BEGIN

COD_RESULTADO:=1;

INSERT
INTO
  PAGO
  (
    ESTADO_PAGO,
    FECHA_VENCIMIENTO,
    ID_VENCIMIENTO,
    ID_CONTRATO,
    MONTO_CUOTA,
    N_CUOTA,
    COMISION
  )
  VALUES
  (
    SP_ESTADO_PAGO,
    SP_FECHA_VENCIMIENTO,
    SP_ID_VENCIMIENTO,
    SP_ID_CONTRATO,
    SP_MONTO_CUOTA,
    SP_N_CUOTA,
    SP_COMISION
  );

COD_RESULTADO:=0;

EXCEPTION 
WHEN OTHERS THEN

MSG_ERROR:= 'ERROR AL FILTRAR';
END;


procedure SP_FETCH_PAGO (
                              COD_RESULTADO	OUT	NUMBER	,	
                              MSG_ERROR	OUT	varchar2	,	
                              CURSOR_PAGOS	OUT	PKG_PAGOS.REFCURSOR,
                              SP_ESTADO_PAGO          IN VARCHAR2,
                              SP_FECHA_VENCIMIENTO    IN DATE,
                              SP_ID_CONTRATO          IN Number,
                              SP_RUT				  IN varchar2
							  )
AS 

BEGIN

COD_RESULTADO:=1;

OPEN CURSOR_PAGOS FOR

SELECT
  PAG.ESTADO_PAGO,
  PAG.FECHA_VENCIMIENTO,
  PAG.ID_VENCIMIENTO,
  PAG.ID_CONTRATO,
  PAG.MONTO_CUOTA,
  PAG.N_CUOTA,
  PAG.COMISION
FROM
  PAGO PAG 
JOIN 
  CONTRATO CONT ON PAG.ID_CONTRATO = CONT.ID_CONTRATO
WHERE 
  PAG.ESTADO_PAGO= NVL (SP_ESTADO_PAGO, PAG.ESTADO_PAGO)
AND 
  PAG.FECHA_VENCIMIENTO < NVL (SP_FECHA_VENCIMIENTO, SYSDATE)
AND 
  CONT.ID_CONTRATO= NVL (SP_ID_CONTRATO, CONT.ID_CONTRATO)
AND 
  CONT.RUT = NVL (SP_RUT, CONT.RUT);

COD_RESULTADO:=0;

EXCEPTION 
WHEN OTHERS THEN

MSG_ERROR:= 'ERROR AL FILTRAR';
END;


procedure SP_PAY ( COD_RESULTADO	OUT	NUMBER	,	
                   MSG_ERROR	OUT	varchar2	,	
                   CURSOR_PAGOS	OUT	PKG_PAGOS.REFCURSOR,
                   SP_ID_VENCIMIENTO IN NUMBER
							  )
AS 

BEGIN

COD_RESULTADO:=1;

UPDATE
  PAGO
SET
  ESTADO_PAGO = 'PA',
  FECHA_PAGADA = SYSDATE
WHERE
  ID_VENCIMIENTO= SP_ID_VENCIMIENTO;

EXCEPTION 
WHEN OTHERS THEN

MSG_ERROR:= 'ERROR AL FILTRAR';
END;



procedure SP_DEBT_BY_DATE(	COD_RESULTADO	OUT	NUMBER	,	
                            MSG_ERROR				OUT	varchar2	,	
                            CURSOR_PAGOS		OUT	PKG_PAGOS.REFCURSOR,
                            FECHA_INICIO			IN DATE,
                            FECHA_TERMINO			IN DATE,
                            SP_ESTADO_PAGO          IN VARCHAR2,
                            SP_FECHA_VENCIMIENTO    IN DATE,
                            SP_FECHA_PAGADA    IN DATE,
                            SP_ID_CONTRATO          IN Number,
                            SP_RUT 				  	IN varchar2 
                          )
AS 

BEGIN
COD_RESULTADO:=1;

OPEN CURSOR_PAGOS FOR

SELECT
  PAG.ESTADO_PAGO,
  PAG.FECHA_VENCIMIENTO,
  PAG.ID_VENCIMIENTO,
  PAG.ID_CONTRATO,
  PAG.MONTO_CUOTA,
  PAG.N_CUOTA,
  PAG.COMISION
FROM
  PAGO PAG
JOIN CONTRATO CONT ON PAG.ID_CONTRATO = CONT.ID_CONTRATO

WHERE 
  PAG.ESTADO_PAGO= NVL (SP_ESTADO_PAGO, PAG.ESTADO_PAGO)
AND 
  PAG.FECHA_VENCIMIENTO <= NVL (SP_FECHA_VENCIMIENTO, SYSDATE)
AND
  PAG.FECHA_VENCIMIENTO >= NVL (SP_FECHA_VENCIMIENTO, SYSDATE)
AND 
  CONT.ID_CONTRATO= NVL (SP_ID_CONTRATO, CONT.ID_CONTRATO)
AND 
  CONT.RUT= NVL (SP_RUT, CONT.RUT);

COD_RESULTADO:=0;

EXCEPTION 
WHEN OTHERS THEN

MSG_ERROR:= 'ERROR AL FILTRAR';
END;

END;

/
