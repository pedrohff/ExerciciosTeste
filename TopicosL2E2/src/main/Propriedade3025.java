package main;

public class Propriedade3025 {


    public double retornaPotencia(int valor){
        String numero = Integer.toString(valor);
        String part1 = numero.substring(0, 2);
        String part2 = numero.substring(2, 4);

        return Math.pow(Double.parseDouble(part1) + Double.parseDouble(part2), 2);
    }

    public boolean propriedade3025(int valor){

        if (valor < 1000 || valor > 9999){
        	throw new IllegalArgumentException("Número inválido.");
        }
        else {
        	if(retornaPotencia(valor) == valor) {
        		System.out.println(valor);
        	}
            return retornaPotencia(valor) == valor;
        }
    }

}