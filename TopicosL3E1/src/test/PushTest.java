package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import atividade.pilha.Pilha;

public class PushTest {
	
	/**
	 * Diretrizes Right, I(Inverse) e C(Cross-Check)
	 */
	@Test
	public void fluxoPrincipal() {
		Pilha p = new Pilha();
		p.push(-5);
		
		assertTrue(!p.isEmpty());
		assertTrue(p.tamanho() == 1);
		assertTrue(p.top() == -5);
		assertTrue(p.posicaoPilha == 0);
	}
	
	/**
	 * Diretriz Right, C e B(Boundaries)
	 */
	@Test
	public void fluxoAlternativo1() {
		Pilha p = new Pilha();
		for(int i=0; i<999;i++) {
			p.push(i%7==0 ? -253*i : 923*i);
		}
		p.push(2147483647);
		assertTrue(p.isCheia());
		assertTrue(!p.isEmpty());
		assertTrue(p.tamanho() == 1000);
		assertTrue(p.posicaoPilha == 999);
	}
	
	/**
	 * Diretriz C e E(Error)
	 */
	@Test(expected = StackOverflowError.class)
	public void fluxoExcecao() {
		Pilha p = new Pilha();
		for(int i=0;i<1001;i++) {
			p.push(i);
		}
	}
	
	
	

}
