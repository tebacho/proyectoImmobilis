package com.immobilis.vo;

public class PropietarioVO extends PersonaVO {
	
	private FormaPago formaPago;
	private int diaPago;
	
	public FormaPago getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(FormaPago formaPago) {
		this.formaPago = formaPago;
	}

	public int getDiaPago() {
		return diaPago;
	}

	public void setDiaPago(int diaPago) {
		this.diaPago = diaPago;
	}

	enum FormaPago{
	CONTADO,TRANSFERENCIA,DEPOSITO;	
	};
	
}
