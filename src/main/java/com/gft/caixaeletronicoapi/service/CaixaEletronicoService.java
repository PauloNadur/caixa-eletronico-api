package com.gft.caixaeletronicoapi.service;

import org.springframework.stereotype.Service;

import com.gft.caixaeletronicoapi.entities.CaixaEletronico;
import com.gft.caixaeletronicoapi.entities.Saque;
import com.gft.caixaeletronicoapi.entities.notas.NotaCem;
import com.gft.caixaeletronicoapi.entities.notas.NotaCinquenta;
import com.gft.caixaeletronicoapi.entities.notas.NotaDez;
import com.gft.caixaeletronicoapi.entities.notas.NotaVinte;
import com.gft.caixaeletronicoapi.repositories.CaixaEletronicoRepository;

@Service
public class CaixaEletronicoService {
	
	private final CaixaEletronicoRepository caixaEletronicoRepository;

	public CaixaEletronicoService(CaixaEletronicoRepository caixaEletronicoRepository) {
		this.caixaEletronicoRepository = caixaEletronicoRepository;
	}
	
	public CaixaEletronico buscarCaixaEletronico() {
		return caixaEletronicoRepository.findById(1L).get();
	}
	
	public CaixaEletronico salvarCaixaEletronico(CaixaEletronico caixaEletronico) {
		return caixaEletronicoRepository.save(caixaEletronico);
	}
	
	public Double efetuarSaque(CaixaEletronico caixa, Saque saque) {
		
		Double valorRestante = Double.parseDouble(saque.getValorSolicitado());
		
		while (valorRestante >= 100 && caixa.getQuantidadeNotasCem() >= 1) {
			caixa.removerNotaCem();
			saque.getGrupoNotasRetornadas().getNotasCem().add(new NotaCem());
			valorRestante -= 100;
		}

		while (valorRestante >= 50 && caixa.getQuantidadeNotasCinquenta() >= 1) {
			caixa.removerNotaCinquenta();
			saque.getGrupoNotasRetornadas().getNotasCinquenta().add(new NotaCinquenta());
			valorRestante -= 50;
		}

		while (valorRestante >= 20 && caixa.getQuantidadeNotasVinte() >= 1) {
			caixa.removerNotaVinte();
			saque.getGrupoNotasRetornadas().getNotasVinte().add(new NotaVinte());
			valorRestante -= 20;
		}

		while (valorRestante >= 10 && caixa.getQuantidadeNotasDez() >= 1) {
			caixa.removerNotaDez();
			saque.getGrupoNotasRetornadas().getNotasDez().add(new NotaDez());
			valorRestante -= 10;
		}
		
		return valorRestante;
	}
	
}
