/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CriptoSolver;

import br.com.mariojp.ai.agent.AgentFactory;
import br.com.mariojp.ai.agent.AgentModel;
import br.com.mariojp.ai.agent.IAgent;
import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.ai.agent.exception.EmptyBorderException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author comum
 */
public class CriptoAgente {
    public static void main(String[] args) throws IOException{
                
        /*The program should first find all the distinct letters, and then use DFS 
        such that the first level of the search tree consists of all the 
        possible assignments to the first letter, the second level consists of 
        all the possible assignments to the second letter given the assignment 
        to the first letter, and so on. While there are several other ways to 
        solve these puzzles.*/
        
        //Passos: Identificar todas as letras
        // Substituir os valores por nÃºmeros
        // fazer o parseint das strings numeradas, para realizar os cÃ¡lculos
        //criar duas variÃ¡veis auxiliares para comparar ambos os lados de um sinal =, <, >...
        // criar um case para cada operador. Este, que serÃ¡ responsÃ¡vel pela soluÃ§Ã£o.
                
        char letras[] = new char[20];
        char alfabeto[] = {'A','B','C','D','E','F','G','H','I','J','K',
        'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        ArrayList<Character> letra;
        letra = new ArrayList();
        ArrayList<Integer> numero;
        numero = new ArrayList();
        
       
        
        ArrayList<String> palavrasOp;
        palavrasOp = new ArrayList();
        ArrayList<Integer> numerosOp;
        numerosOp = new ArrayList();
   
        
        System.out.println("\n Quantas palavras possui o seu criptograma? ");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));  
        String entrada = in.readLine(); 
        int countPalavras = Integer.parseInt(entrada);
        
        for(int i=0; i<countPalavras; i++){
            System.out.println("\n Digite a palavra nÃºmero " + (i+1) + ": "); 
            entrada = in.readLine(); 
            entrada = entrada.toUpperCase();
            palavrasOp.add(entrada);
            
            if (i != countPalavras-1){
                System.out.println("\n Digite o operador " + (i+1) + ": "); 
                entrada = in.readLine(); 
                entrada = entrada.toUpperCase();
                palavrasOp.add(entrada);
            }
        }
        //Verifica as letras que o criptograma possui
        boolean repetida = false;
        int posLetra = 0;
        String palavra = null;
        for(int i=0; i<palavrasOp.size();i=i+2){
            for(int j=0;j<palavrasOp.get(i).length();j++){
                for(int numLetra = 0; numLetra < 20; numLetra++){
                    palavra = palavrasOp.get(i);
                    if(letras[numLetra] == palavra.charAt(j)){
                        repetida = true;
                    }
                }
                if(!repetida){
                                        
                    letras[posLetra] = palavra.charAt(j);
                    posLetra++;
                    
                }
                else
                    repetida = false; 
            }
        }
      
        for (int i=0; i<10; i++) {
            for(int j=0; j<23; j++){
                if(letras[i] == alfabeto[j]){
                    letra.add(letras[i]);
                }
            }
        }
        
            
        AgentModel am = new AgentModel();
        
        CriptoEstado inicial = new CriptoEstado(1);
        CriptoEstado objetivo = new CriptoEstado(letra.size()+1);
        CriptoEstado objetivo1 = new CriptoEstado();
        CriptoFuncoes funcoes = new CriptoFuncoes();
        
       
        inicial.setFrase(palavrasOp);
        inicial.setLetra(letra);
        inicial.setCriptograma(false);
        
        objetivo1.setFrase(palavrasOp);
        objetivo1.setLetra(letra);
        objetivo1.setCriptograma(true);
        
                
        am.setInitState(inicial);
        am.addObjective(objetivo1);
        am.addAction("Busca Criptograma", new CriptoAcoes());
        am.setFunctions(funcoes);
        
        am.setType(IAgent.START_SEARCH);
        for(int i=0; i<10;i++){
            agente(am);
        }
        
    }
        public static void agente(AgentModel am){
        IAgent agente = AgentFactory.createAgent(am);
		
		
		INode nofinal = null;
		try {
			nofinal = agente.function();
		} catch (EmptyBorderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
                System.out.println(agente);
		System.out.println(nofinal);
    }
}
