package com.gft.caixaeletronicoapi.entities;

import com.gft.caixaeletronicoapi.entities.notas.GrupoNotas;

public class Saque {

	private String valorSolicitado;
	private GrupoNotas grupoNotasRetornadas;

	public Saque() {
		this.grupoNotasRetornadas = new GrupoNotas();
	}

	public Saque(String valorSolicitado) {
		this.valorSolicitado = valorSolicitado;
	}
	
	public Saque(String valorSolicitado, GrupoNotas grupoNotasRetornadas) {
		this.valorSolicitado = valorSolicitado;
		this.grupoNotasRetornadas = grupoNotasRetornadas;
	}

	public String getValorSolicitado() {
		return valorSolicitado;
	}

	public void setValorSolicitado(String valorSolicitado) {
		this.valorSolicitado = valorSolicitado;
	}

	public GrupoNotas getGrupoNotasRetornadas() {
		return grupoNotasRetornadas;
	}

	public void setGrupoNotasRetornadas(GrupoNotas grupoNotasRetornadas) {
		this.grupoNotasRetornadas = grupoNotasRetornadas;
	}
}
