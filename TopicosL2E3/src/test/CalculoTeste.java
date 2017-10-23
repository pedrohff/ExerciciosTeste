package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeoutException;

import org.junit.BeforeClass;
import org.junit.Test;

import main.Calculo;

public class CalculoTeste {
	
	private static final ArrayList<Integer> exemploMil = new ArrayList<>();
	private static final ArrayList<Integer> exemploExecErro = new ArrayList<>();
	
	@BeforeClass
	public static void preencheExemplos() {
		for(int i=0; i<1000; i++) {
			exemploMil.add(i);
		}
		for(int i=0; i<10000000; i++) {
			exemploExecErro.add(i);
		}
		
	}
	
	/**
	 * Métodos para validar a ordenação
	 * Ajudará a concluir a diretriz "Right" junto a C(Cross-Check)
	 */
	static boolean validaOrdenacao(ArrayList<Integer> list) {
		return validaOrdenacaoDireta(list) && validaOrdenacaoInversa(list);
	}
	
	static boolean validaOrdenacaoDireta(ArrayList<Integer> list) {
		boolean retorno = true;
		boolean auxPares = true;
		
		for(int i=0; i<list.size();i++) {
			int num = list.get(i);
			
			if(retorno) {
				if(auxPares) {
					if(num %2 != 0)
						auxPares = false;
				}else{
					if(num %2 == 0) {
						retorno=false;
						break;
					}
				}
			}
		}
		
		return retorno;
	}
	
	static boolean validaOrdenacaoInversa(ArrayList<Integer> list) {
		boolean retorno = true;
		boolean auxImpares = true;
		
		for(int i=list.size()-1; i>=0;i--) {
			int num = list.get(i);
			
			if(retorno) {
				if(auxImpares) {
					if(num %2 == 0)
						auxImpares = false;
				}else{
					if(num %2 != 0) {
						retorno=false;
						break;
					}
				}
			}
		}
		
		return retorno;
	}

	/**
	 * Diretriz Right
	 */
	@Test
	public void testCaminhoPrincipal() {
		ArrayList<Integer> entrada = new ArrayList<>();
		ArrayList<Integer> saida = new ArrayList<>();
		for(Integer i=0; i<200; i++) {
			entrada.add(i);
		}
		
		saida = Calculo.paresPrimeiro(entrada);
		
		assertTrue(validaOrdenacao(saida));
	}

	/**
	 * Testa o mesmo do caminho principal, mas com ordem inversa
	 * Diretriz I (Inverse)
	 */
	@Test
	public void testCaminhoAlternativo1() {
		ArrayList<Integer> entrada = new ArrayList<>();
		ArrayList<Integer> saida = new ArrayList<>();
		for(Integer i=199; i>=0; i--) {
			entrada.add(i);
		}
		
		saida = Calculo.paresPrimeiro(entrada);

		assertTrue(validaOrdenacao(saida));
	}
	
	/**
	 * Teste da diretriz Right, com a quantidade minima de elementos
	 */
	@Test
	public void testCaminhoAlternativo2() {
		ArrayList<Integer> entrada = new ArrayList<>();
		ArrayList<Integer> saida = new ArrayList<>();
		entrada.add(1);
		entrada.add(2);
		
		saida = Calculo.paresPrimeiro(entrada);
		
		assertTrue(validaOrdenacao(saida));
	}
	
	/**
	 * Testa os valores limite
	 * Diretriz B (Boundaries)
	 * e diretriz P (Performance within bounds)
	 */
	@Test(timeout = 1000)
	public void testCaminhoAlternativo3() {
		ArrayList<Integer> entrada = new ArrayList<>();
		ArrayList<Integer> saida = new ArrayList<>();
		entrada.add(-2147483648);
		entrada.add(+2147483647);
		entrada.add(23782784);
		entrada.add(-12323894);
		entrada.add(-3434343);
		for(int i=0;i<994;i++) {
			if(i%13==0)
				entrada.add(i*(-312));
			else
				entrada.add(i*1947);
		}
		
		saida = Calculo.paresPrimeiro(entrada);
		
		System.out.println(Arrays.toString(saida.toArray()));
		
		assertTrue(validaOrdenacao(saida));
	}
	
	/**
	 * Funcionamento com 1 elemento
	 * Diretriz Right
	 */
	@Test
	public void testCaminhoAlternativo4() {
		ArrayList<Integer> entrada = new ArrayList<>();
		ArrayList<Integer> saida = new ArrayList<>();
		entrada.add(0);
		
		saida = Calculo.paresPrimeiro(entrada);
		
		assertTrue(validaOrdenacao(saida));
	}
	
	/**
	 * Valida se erro ocorre ao utilizar lista nula
	 * Diretriz E
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testListaNula() {
		Calculo.paresPrimeiro(null);
		fail("Deveria lançar IllegalArgumentException");
	}
	
	/**
	 * Valida se erro ocorre ao utilizar lista com elementos nulos
	 * Diretriz E
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testElementosNulos() {
		ArrayList<Integer> entrada = new ArrayList<>();
		
		for(Integer i=0; i<201; i++) {
			if(i%7 == 0)
				entrada.add(null);
			else
				entrada.add(i);
		}
		Calculo.paresPrimeiro(null);
		fail("Deveria lançar IllegalArgumentException");
	}
	
	/**
	 * Teste de tempo
	 * Diretriz P (Performance)
	 */
	@Test(timeout = 1000)
	public void testTempoExecucaoSemErro() {
		Calculo.paresPrimeiro(exemploMil);
	}
	
	/**
	 * Teste de tempo
	 * Diretriz P junto à E
	 */
	@Test(expected = TimeoutException.class)
	public void testTempoExecucaoComErro() throws TimeoutException {
		long init = System.currentTimeMillis();
		Calculo.paresPrimeiro(exemploExecErro);
		long end = System.currentTimeMillis();
		
		if((end-init) > 1000) {
			throw new TimeoutException();
		}
	}
	
	/* 
	 * Estudei alguma maneira de forçar o erro, mas não deu certo
	 * 
	@Test(expected = InterruptedException.class)
	public void testTempoExecucaoComErro() {
		try {
			Calculo.paresPrimeiro(exemploMil);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			fail("Tempo limite excedido");
		}
	}*/

}
