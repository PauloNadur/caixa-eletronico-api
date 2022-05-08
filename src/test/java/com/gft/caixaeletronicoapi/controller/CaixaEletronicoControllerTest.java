package com.gft.caixaeletronicoapi.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.gft.caixaeletronicoapi.controllers.CaixaEletronicoController;
import com.gft.caixaeletronicoapi.entities.CaixaEletronico;
import com.gft.caixaeletronicoapi.entities.Saque;
import com.gft.caixaeletronicoapi.entities.notas.GrupoNotas;
import com.gft.caixaeletronicoapi.entities.notas.NotaCem;
import com.gft.caixaeletronicoapi.service.CaixaEletronicoService;
import com.gft.caixaeletronicoapi.service.SaqueService;

@RunWith(MockitoJUnitRunner.class)
public class CaixaEletronicoControllerTest {

	@InjectMocks
	private CaixaEletronicoController caixaEletronicoController;
	
	@Mock
	private CaixaEletronicoService caixaEletronicoService;

	@Mock
	private SaqueService saqueService;
	
	@Test
	public void testMultiploDeDez() {
		when(saqueService.isMultiploDeDez(any(Saque.class))).thenReturn(false);
		final var response = caixaEletronicoController.realizarSaque(new Saque());
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());	
	}
	
	@Test
	public void testBuscarCaixaEletronico() {
		Saque saque = new Saque();
		saque.setValorSolicitado("190");
		CaixaEletronico caixaEletronico = new CaixaEletronico(1, 1, 1, 1);
		when(saqueService.isMultiploDeDez(any(Saque.class))).thenReturn(true);
		when(caixaEletronicoService.buscarCaixaEletronico()).thenReturn(caixaEletronico);
		final var response = caixaEletronicoController.realizarSaque(saque);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());	
	}
	
	@Test
	public void testVerificarSeAindaTemValorRestantePraSacar() {
		
		Saque saque = new Saque();
		saque.setValorSolicitado("160");
		saque.setGrupoNotasRetornadas(new GrupoNotas());
		CaixaEletronico caixaEletronico = new CaixaEletronico(1, 1, 1, 1);
		when(saqueService.isMultiploDeDez(any(Saque.class))).thenReturn(true);
		when(caixaEletronicoService.buscarCaixaEletronico()).thenReturn(caixaEletronico);
		when(caixaEletronicoService.efetuarSaque(any(CaixaEletronico.class), any(Saque.class))).thenReturn(1.0);
		
		final var response = caixaEletronicoController.realizarSaque(saque);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());	
	}
	
	@Test
	public void testRealizarSaqueOk() {
		NotaCem notasCem = new NotaCem();
		notasCem.setValor(10);
		GrupoNotas grupoNotas = new GrupoNotas();
		grupoNotas.setNotasCem(List.of(notasCem));
		Saque saque = new Saque();
		saque.setValorSolicitado("160");
		saque.setGrupoNotasRetornadas(grupoNotas);
		CaixaEletronico caixaEletronico = new CaixaEletronico(1, 1, 1, 1);
		when(saqueService.isMultiploDeDez(any(Saque.class))).thenReturn(true);
		when(caixaEletronicoService.buscarCaixaEletronico()).thenReturn(caixaEletronico);
		when(caixaEletronicoService.efetuarSaque(any(CaixaEletronico.class), any(Saque.class))).thenReturn(0.0);
		
		final var response = caixaEletronicoController.realizarSaque(saque);
		assertEquals(HttpStatus.OK, response.getStatusCode());	
	}
	
}












