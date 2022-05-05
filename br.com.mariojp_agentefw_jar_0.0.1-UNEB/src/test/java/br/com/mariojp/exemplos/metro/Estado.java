package br.com.mariojp.exemplos.metro;

import br.com.mariojp.ai.agent.AbstractState;

/**
 * 
 * @project AgenteFW
 * @package br.com.mariojp.exemplos.metro
 * @file Estado.java
 * @author Mario Jorge Pereira
 * @version 1.1
 * <p>Classe que representa a o Ambiente para o problema do Metrô de Salvador</p>
 *
 */
public class Estado extends AbstractState {

	/**
	 * Constantes 
	 */
	
	private int numeroEstacao;
	private int linhaAtual;

	
	 public Estado(){
	 }
	 
	 public Estado(int numeroEstacao){
		 this.numeroEstacao = numeroEstacao;
		 //this.linhaAtual = linhaAtaual;
		 
	 }
	
    /**
    * Metodo necessario para criar copias do Estado.
    * Caso o estado tenha somente tipos primitivos, apenas copie este metodo. 
    * @return Object
    */
   public Object clone() {
       Object copia = null;
       try {
			copia = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
       return copia;
   }
	
	/**
	 * Verifica se os estados são iguais
	 */
	public boolean equals(Object arg0) {
        Estado outro = (Estado) arg0;
        boolean igual = false;
        
        if(this.getNumeroEstacao() == outro.getNumeroEstacao()){
            igual = true;
        }
        return igual;
	}

	/**
	 * Obtem a estacação atual
	 * @return int - Número da estacão
         */
         public int getNumeroEstacao(){
             return numeroEstacao;
         }

	/**
	 * Atribui o número da estação atual.
	 * @param numeroEstacao
	 */
	public void setNumeroEstacao(int numeroEstacao) {
		this.numeroEstacao = numeroEstacao;
	}

	/**
	 * Obtem a cor da linha do trem
	 * @return int - Cor da  linha
	 */
	public int getLinhaAtual() {
		return linhaAtual;
	}

	/**
	 * Atribui a cor da linha da estação) 
	 * @param linhaAtual 
	 */
	public void setLinhaAtual(int linhaAtual) {
		this.linhaAtual = linhaAtual;
	}

	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Estação : ");
		sb.append(this.getNumeroEstacao());
		sb.append("\n");
		sb.append("Linha Atual: ");
		sb.append(this.getLinhaAtual());
		sb.append("\n");
		return sb.toString();
	}

}
