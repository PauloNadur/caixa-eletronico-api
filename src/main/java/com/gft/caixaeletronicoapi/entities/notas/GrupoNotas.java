package com.gft.caixaeletronicoapi.entities.notas;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GrupoNotas {

	private List<NotaCem> notasCem;
	private List<NotaCinquenta> notasCinquenta;
	private List<NotaVinte> notasVinte;
	private List<NotaDez> notasDez;

	public GrupoNotas() {
		this.notasCem = new ArrayList<>();
		this.notasCinquenta = new ArrayList<>();
		this.notasVinte = new ArrayList<>();
		this.notasDez = new ArrayList<>();
	}

	public GrupoNotas(List<NotaCem> notasCem, List<NotaCinquenta> notasCinquenta, List<NotaVinte> notasVinte,
			List<NotaDez> notasDez) {
		this.notasCem = notasCem;
		this.notasCinquenta = notasCinquenta;
		this.notasVinte = notasVinte;
		this.notasDez = notasDez;
	}

	@JsonIgnore
	public boolean isEmpty() {
		if (this.notasCem.isEmpty() && this.notasCinquenta.isEmpty() && this.notasVinte.isEmpty()
				&& this.notasDez.isEmpty()) {
			return true;
		}
		return false;
	}

	public List<NotaCem> getNotasCem() {
		return notasCem;
	}

	public void setNotasCem(List<NotaCem> notasCem) {
		this.notasCem = notasCem;
	}

	public List<NotaCinquenta> getNotasCinquenta() {
		return notasCinquenta;
	}

	public void setNotasCinquenta(List<NotaCinquenta> notasCinquenta) {
		this.notasCinquenta = notasCinquenta;
	}

	public List<NotaVinte> getNotasVinte() {
		return notasVinte;
	}

	public void setNotasVinte(List<NotaVinte> notasVinte) {
		this.notasVinte = notasVinte;
	}

	public List<NotaDez> getNotasDez() {
		return notasDez;
	}

	public void setNotasDez(List<NotaDez> notasDez) {
		this.notasDez = notasDez;
	}
}
