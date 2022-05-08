package com.gft.caixaeletronicoapi.service;

import org.springframework.stereotype.Service;

import com.gft.caixaeletronicoapi.entities.Saque;

@Service
public class SaqueService {

	public boolean isMultiploDeDez(Saque saque) {
		double valorSolicitado = Double.parseDouble(saque.getValorSolicitado());
		
		if (valorSolicitado % 10 == 0) {
			return true;
		}
		return false;
	}

}
