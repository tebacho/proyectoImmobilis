--------------------------------------------------------
-- Archivo creado  - miércoles-octubre-28-2015   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package PKG_PAGOS
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "IMMOBILIS"."PKG_PAGOS" 		AS				

TYPE RefCursor is REF CURSOR;

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
							  );

procedure SP_FETCH_PAGO (
                          COD_RESULTADO	OUT	NUMBER	,	
                              MSG_ERROR	OUT	varchar2	,	
                              CURSOR_PAGOS	OUT	PKG_PAGOS.REFCURSOR,
                              SP_ESTADO_PAGO          IN VARCHAR2,
                              SP_FECHA_VENCIMIENTO    IN DATE,
                              SP_ID_CONTRATO          IN Number,
                              SP_RUT				  IN varchar2
							  );


procedure SP_PAY (
                   COD_RESULTADO	OUT	NUMBER	,	
                   MSG_ERROR	OUT	varchar2	,	
                   CURSOR_PAGOS	OUT	PKG_PAGOS.REFCURSOR,
                   SP_ID_VENCIMIENTO IN NUMBER
							  );

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
							  );
END;
/
