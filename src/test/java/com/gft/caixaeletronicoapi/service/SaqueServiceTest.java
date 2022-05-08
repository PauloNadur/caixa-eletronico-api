package com.gft.caixaeletronicoapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.gft.caixaeletronicoapi.entities.Saque;

@RunWith(MockitoJUnitRunner.class)
public class SaqueServiceTest {

	private SaqueService saqueService;

	@Before
	public void setup() {
		this.saqueService = new SaqueService();
	}

	@Test
	public void deveRetornarFalsePoisNaoEMultiploDeDez() {
		Saque saque = new Saque("15");
		boolean retorno = saqueService.isMultiploDeDez(saque);
		assertEquals(false, retorno);
	}

	@Test
	public void deveRetornarTruePoisEMultiploDeDez() {
		Saque saque = new Saque("10");
		boolean retorno = saqueService.isMultiploDeDez(saque);
		assertEquals(true, retorno);
	}
}