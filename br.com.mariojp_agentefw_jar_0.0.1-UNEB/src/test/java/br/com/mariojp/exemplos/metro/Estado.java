package br.com.mariojp.exemplos.metro;

import br.com.mariojp.ai.agent.AbstractState;
import java.util.ArrayList;
import java.util.Iterator;

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
	
	private int estacao;
	private int linhaAtual;
        private int estacaoAnt = 0;
        private ArrayList<Integer> estacoesAdjacentes = new ArrayList<Integer>();
        public static ArrayList<Integer> estacoesAnt = new ArrayList<Integer>();
	
	 public Estado(){
	 }
	 
	 public Estado(int numeroEstacao){
		 this.estacao = numeroEstacao;
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
            
        if(this.getEstacao() == outro.getEstacao()){
            igual = true;
        }
        return igual;
	}

	/**
	 * Obtem a estacação atual
	 * @return int - Número da estacão
         */
         public int getEstacao(){
             return this.estacao;
         }

	/**
	 * Atribui o número da estação atual.
	 * @param numeroEstacao
	 */
	public void setEstacao(int numeroEstacao) {
		this.estacao = numeroEstacao;
                this.AddeEstaçoesAdjacentes();
	}

        	/**
	 * Obtem a estacação atual
	 * @return int - Número da estacão
         */
         public int getEstacaoAnt(){
             return this.estacaoAnt;
         }

	/**
	 * Atribui o número da estação atual.
	 * @param estacaoAnt
	 */
	public void setEstacaoAnt(int estacaoAnt) {
		this.estacaoAnt = estacaoAnt;
	}
	/**
	 * Obtem a cor da linha do trem
	 * @return int - Cor da  linha
	 */
	public int getLinhaAtual() {
		return this.linhaAtual;
	}

	/**
	 * Atribui a cor da linha da estação) 
	 * @param linhaAtual 
	 */
        public void setLinhaAtual(int linhaAtual) {
		this.linhaAtual = linhaAtual;
	}
	public ArrayList<Integer> getEstacoesAnt() {
		return this.estacoesAnt;
	}
        public boolean checaEstacaAnt(int estacao) {
		return !this.estacoesAnt.contains(estacao);
	}
	public ArrayList<Integer> getEstacoesAdjacentes() {
		return this.estacoesAdjacentes;
	}

        public void AddeEstaçoesAdjacentes(){
            Iterator<Integer> it = Mapa.mapa.get(this.estacao).keySet().iterator(); 

            while(it.hasNext()) {
                int e = it.next();
                this.estacoesAdjacentes.add(e);
            }
        }
	/**
	 * Atribui a cor da linha da estação) 
	 * @param linhaAtual 
	 */
	public void setEstacoesmt(int estacao) {
		this.estacoesAnt.add(estacao);
	}
        
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Estação : ");
		sb.append(this.getEstacao());
		sb.append("\n");
		sb.append("Linha Atual: ");
		sb.append(this.getLinhaAtual());
		sb.append("\n");
		return sb.toString();
	}

}
