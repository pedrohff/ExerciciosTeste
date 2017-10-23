package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import atividade.pilha.Pilha;

public class PullTest {

	/**
	 * Diretrizes Right, I, e C
	 */
	@Test
	public void fluxoPrincipal() {
		Pilha p = new Pilha();
		p.push(-3);
		int x = p.pop();
		
		assertTrue(p.isEmpty());
		assertFalse(p.isCheia());
		assertTrue(x == -3);
		assertTrue(p.tamanho() == 0);
		assertTrue(p.posicaoPilha == -1);
	}
	
	/**
	 * Diretrizes Right, I, C e B
	 */
	@Test
	public void fluxoAlternativo() {
		Pilha p = new Pilha();
		for(int i=0;i<1000;i++) {
			p.push(i);
		}
		
		assertTrue(p.isCheia());
		
		int a = p.pop();
		assertTrue(a == 999);
		assertFalse(p.isCheia());
		assertFalse(p.isEmpty());
		
		for(int i=0;i<999;i++) { 
			p.pop();
		}
		
		assertTrue(p.tamanho()==0);
		assertTrue(p.isEmpty());
		assertTrue(p.posicaoPilha == -1);
	}
	
	/**
	 * Diretriz E
	 */
	@Test(expected = IllegalStateException.class)
	public void fluxoExcecao1() {
		Pilha p = new Pilha();
		p.pop();
	}
	
	/**
	 * Diretriz E
	 */
	@Test(expected = IllegalStateException.class)
	public void fluxoExcecao2() {
		Pilha p = new Pilha();
		for(int a=0;a<1000;a++) {
			p.push(a);
		}
		
		for(int b=0;b<=1000;b++) {
			p.pop();
		}
	}
}
