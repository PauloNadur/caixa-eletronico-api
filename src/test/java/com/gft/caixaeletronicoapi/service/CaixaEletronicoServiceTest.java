package com.gft.caixaeletronicoapi.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.gft.caixaeletronicoapi.entities.CaixaEletronico;
import com.gft.caixaeletronicoapi.entities.Saque;
import com.gft.caixaeletronicoapi.repositories.CaixaEletronicoRepository;

@RunWith(MockitoJUnitRunner.class)
public class CaixaEletronicoServiceTest {

	@InjectMocks
	private CaixaEletronicoService caixaEletronicoService;

	@Mock
	private CaixaEletronicoRepository caixaEletronicoRepository;

	@Test
	public void testBuscarCaixa() {
		when(caixaEletronicoRepository.findById(anyLong())).thenReturn(Optional.of(new CaixaEletronico(1, 1, 1, 1)));
		final var response = caixaEletronicoService.buscarCaixaEletronico();
		assertTrue(response.getQuantidadeNotasCem() == 1);
	}

	@Test
	public void testSalvarCaixarEletrônico() {
		when(caixaEletronicoRepository.save(any(CaixaEletronico.class))).thenReturn((new CaixaEletronico(1, 1, 1, 1)));
		final var response = caixaEletronicoService.salvarCaixaEletronico(new CaixaEletronico());
		assertTrue(response.getQuantidadeNotasCem() == 1);
	}

	@Test
	public void testCondicoesEfetuarSaque() {
		Saque saque = new Saque();
		saque.setValorSolicitado("100");
		CaixaEletronico caixa = new CaixaEletronico();
		caixa.setQuantidadeNotasCem(1);
		final var response = caixaEletronicoService.efetuarSaque(caixa, saque);
		assertTrue(0.0 == response);
	}
	
	@Test
	public void testCondicoesEfetuarSaque100() {
		Saque saque = new Saque();
		saque.setValorSolicitado("100");
		CaixaEletronico caixa = new CaixaEletronico();
		caixa.setQuantidadeNotasCem(1);
		final var response = caixaEletronicoService.efetuarSaque(caixa, saque);
		assertTrue(0.0 == response);
	}
	
	@Test
	public void testCondicoesEfetuarSaque50() {
		Saque saque = new Saque();
		saque.setValorSolicitado("50");
		CaixaEletronico caixa = new CaixaEletronico();
		caixa.setQuantidadeNotasCinquenta(1);
		final var response = caixaEletronicoService.efetuarSaque(caixa, saque);
		assertTrue(0.0 == response);
	}
	
	@Test
	public void testCondicoesEfetuarSaque20() {
		Saque saque = new Saque();
		saque.setValorSolicitado("20");
		CaixaEletronico caixa = new CaixaEletronico();
		caixa.setQuantidadeNotasVinte(1);
		final var response = caixaEletronicoService.efetuarSaque(caixa, saque);
		assertTrue(0.0 == response);
	}
	
	@Test
	public void testCondicoesEfetuarSaque10() {
		Saque saque = new Saque();
		saque.setValorSolicitado("10");
		CaixaEletronico caixa = new CaixaEletronico();
		caixa.setQuantidadeNotasDez(1);
		final var response = caixaEletronicoService.efetuarSaque(caixa, saque);
		assertTrue(0.0 == response);
	}

}
