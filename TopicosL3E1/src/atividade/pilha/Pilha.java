package atividade.pilha;

public class Pilha {
    
    public Integer[] pilha;
    public int posicaoPilha;

    public Pilha() {
        this.posicaoPilha = -1;
        this.pilha = new Integer[1000];
    }

    public boolean isEmpty() {
        return this.posicaoPilha == -1;
    }
    
    public boolean isCheia() {
    	return this.posicaoPilha == 999;
    }

    public int tamanho() {
        return posicaoPilha+1;
    }

    public Integer top() {
        //top
        if (this.isEmpty()) {
            return null;
        }
        return this.pilha[this.posicaoPilha];
    }

    public Integer pop() {
        //pop
        if (isEmpty()) {
            throw new IllegalStateException("Pilha Vazia!");
        }
        return this.pilha[this.posicaoPilha--];
    }

    public void push(Integer valor) {
        // push
    	
    	if(tamanho() == 1000)
    		throw new StackOverflowError("Pilha cheia!");
    	
    	this.pilha[++posicaoPilha] = valor;
    }
    
//    public boolean pushPilhaCheia(){
//		//pilha cheia
//		//USANDO DIRETRIZ B - VALORES LIMITES CORRETAMENTE
//		if(this.tamanho() == 1000)
//			return true;
//		else
//			return false;
//	}
//    
//    public boolean popPilhaVazia(){
//		//USANDO DIRETRIZ B - VALORES LIMITES CORRETAMENTE		
//		
//		if(this.tamanho() == 0)
//			return true;
//		else
//			return false;
//	}
//    
//    public boolean pilhaVazia(){
//		//USANDO DIRETRIZ B - VALORES LIMITES CORRETAMENTE
//		if(this.isEmpty() == true)
//			return true;
//		else
//			return false;
//	}

}