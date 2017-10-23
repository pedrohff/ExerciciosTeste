package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import main.Propriedade3025;

public class Propriedade3025Test {

    private Propriedade3025 lista2Questao2;

    @Before
    public void inicializa(){
        lista2Questao2 = new Propriedade3025();
        
    }
    
    /**
     * Diretriz Cross-Check
     */
    @Test
    public void testeRetornaPotencia() {
    	int x = 3897;
    	double y = lista2Questao2.retornaPotencia(x);
    	
    	String numero = Integer.toString(x);
        String part1 = numero.substring(0, 2);
        String part2 = numero.substring(2, 4);
        int p1 = Integer.parseInt(part1);
        int p2 = Integer.parseInt(part2);
        int valorSoma = p1+p2;
        int resultado = valorSoma*valorSoma;
        assertTrue(resultado == y);
    }

    /**
     * Diretriz Right
     * -
     * Teste fluxo principal se o numero é
     * válido ,ou seja, está entre 1000 e 9999 e 
     * verifica se a soma das dezenas é igual a ele mesmo.
     */
    @Test
    public void caminhoPrincipal(){
        assertTrue(3025 == lista2Questao2.retornaPotencia(3025));
    }
    
    /**
     * Diretriz Right
     * -
     * Teste fluxo principal se o numero digitado é
     * válido ,ou seja, está entre 1000 e 9999 e se o
     * número obedece a propriedade.
     */
    @Test
    public void caminhoAlternativo1(){
        assertTrue(lista2Questao2.propriedade3025(9801));
    }

    /**
     * Diretriz Right
     * -
     *  Teste fluxo principal se o numero digitado é
     * válido ,ou seja, está entre 1000 e 9999 mas o 
     * número não obedece a propriedade.
     */
    @Test
    public void caminhoAlternativo2(){
        assertFalse(lista2Questao2.propriedade3025(1345));
    }
    
    /**
     * Diretriz E
     * -
     * Teste alternativo verifica se o número
     * é menor que 1000
     */
    @Test(expected = IllegalArgumentException.class)
    public void caminhoExcecao1(){
        lista2Questao2.propriedade3025(999);
    }

    
    /**
     * Diretriz E
     * -
     * Teste alternativo verifica se o número
     * é maior que 9999
     */
    @Test(expected = IllegalArgumentException.class)
    public void caminhoExcecao2(){
        assertFalse(lista2Questao2.propriedade3025(10000));
    }

}