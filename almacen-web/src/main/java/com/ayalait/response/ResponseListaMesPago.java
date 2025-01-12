package com.ayalait.response;

import java.util.List;

import com.ayalait.modelo.MesPago;
import com.ayalait.utils.ErrorState;

public class ResponseListaMesPago {

	private boolean status;
	private int code;
	private List<MesPago> mes;
	private String resultado;
	private ErrorState error;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}	

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}


	public ErrorState getError() {
		return error;
	}

	public void setError(ErrorState error) {
		this.error = error;
	}

	public List<MesPago> getMes() {
		return mes;
	}

	public void setMes(List<MesPago> mes) {
		this.mes = mes;
	}

	
}
