package com.gft.caixaeletronicoapi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_caixa_eletronico")
public class CaixaEletronico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer quantidadeNotasCem;
	private Integer quantidadeNotasCinquenta;
	private Integer quantidadeNotasVinte;
	private Integer quantidadeNotasDez;

	public CaixaEletronico() {
	}

	public CaixaEletronico(Integer quantidadeNotasCem, Integer quantidadeNotasCinquenta, Integer quantidadeNotasVinte,
			Integer quantidadeNotasDez) {
		this.quantidadeNotasCem = quantidadeNotasCem;
		this.quantidadeNotasCinquenta = quantidadeNotasCinquenta;
		this.quantidadeNotasVinte = quantidadeNotasVinte;
		this.quantidadeNotasDez = quantidadeNotasDez;
	}

	public CaixaEletronico(Long id, Integer quantidadeNotasCem, Integer quantidadeNotasCinquenta,
			Integer quantidadeNotasVinte, Integer quantidadeNotasDez) {
		this.id = id;
		this.quantidadeNotasCem = quantidadeNotasCem;
		this.quantidadeNotasCinquenta = quantidadeNotasCinquenta;
		this.quantidadeNotasVinte = quantidadeNotasVinte;
		this.quantidadeNotasDez = quantidadeNotasDez;
	}

	public Double getValorTotalCaixa() {
		Double valorTotal = 0.0;
		valorTotal += getQuantidadeNotasCem() * 100.0;
		valorTotal += getQuantidadeNotasCinquenta() * 50.0;
		valorTotal += getQuantidadeNotasVinte() * 20.0;
		valorTotal += getQuantidadeNotasDez() * 10.0;
		return valorTotal;
	}

	public void removerNotaCem() {
		this.quantidadeNotasCem--;
	}

	public void removerNotaCinquenta() {
		this.quantidadeNotasCinquenta--;
	}

	public void removerNotaVinte() {
		this.quantidadeNotasVinte--;
	}

	public void removerNotaDez() {
		this.quantidadeNotasDez--;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidadeNotasCem() {
		return quantidadeNotasCem;
	}

	public void setQuantidadeNotasCem(Integer quantidadeNotasCem) {
		this.quantidadeNotasCem = quantidadeNotasCem;
	}

	public Integer getQuantidadeNotasCinquenta() {
		return quantidadeNotasCinquenta;
	}

	public void setQuantidadeNotasCinquenta(Integer quantidadeNotasCinquenta) {
		this.quantidadeNotasCinquenta = quantidadeNotasCinquenta;
	}

	public Integer getQuantidadeNotasVinte() {
		return quantidadeNotasVinte;
	}

	public void setQuantidadeNotasVinte(Integer quantidadeNotasVinte) {
		this.quantidadeNotasVinte = quantidadeNotasVinte;
	}

	public Integer getQuantidadeNotasDez() {
		return quantidadeNotasDez;
	}

	public void setQuantidadeNotasDez(Integer quantidadeNotasDez) {
		this.quantidadeNotasDez = quantidadeNotasDez;
	}

}
