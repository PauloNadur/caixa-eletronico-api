package com.gft.caixaeletronicoapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.caixaeletronicoapi.entities.CaixaEletronico;
import com.gft.caixaeletronicoapi.entities.Saque;
import com.gft.caixaeletronicoapi.service.CaixaEletronicoService;
import com.gft.caixaeletronicoapi.service.SaqueService;

@RestController
@RequestMapping("/api/v1/caixa-eletronico")
public class CaixaEletronicoController {

	private CaixaEletronicoService caixaEletronicoService;

	private SaqueService saqueService;
	
	public CaixaEletronicoController(CaixaEletronicoService caixaEletronicoService, SaqueService saqueService) {
		this.caixaEletronicoService = caixaEletronicoService;
		this.saqueService = saqueService;
	}

	@PostMapping("/saque")
	public ResponseEntity<?> realizarSaque(@RequestBody Saque saque) {
		
		if (!saqueService.isMultiploDeDez(saque)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("O SAQUE SOLICITADO NÃO É MÚLTIPLO DE DEZ, POR FAVOR TENTE UM NOVO VALOR.");
		}
		
		CaixaEletronico caixa = caixaEletronicoService.buscarCaixaEletronico();
		double valorSolicitado = Double.parseDouble(saque.getValorSolicitado());
		if (caixa.getValorTotalCaixa() < valorSolicitado) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("SALDO INSUFICIENTE NO CAIXA ELETRÔNICO PARA ESSA SOLICITAÇÃO SAQUE.");
		}
		
		Double valorRestante = caixaEletronicoService.efetuarSaque(caixa, saque);
		
		if (saque.getGrupoNotasRetornadas().isEmpty() || valorRestante != 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("NÃO FOI POSSÍVEL SACAR ESSE VALOR SOLICITADO POIS NÃO TEMOS NOTAS SUFICIENTE PARA ESSA TRANSAÇÃO.");
		}
		
		caixaEletronicoService.salvarCaixaEletronico(caixa);
		return ResponseEntity.status(HttpStatus.OK).body(saque);
	}

}
