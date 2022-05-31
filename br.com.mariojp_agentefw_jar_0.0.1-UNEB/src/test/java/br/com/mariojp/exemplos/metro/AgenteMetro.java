package br.com.mariojp.exemplos.metro;

import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import br.com.mariojp.ai.agent.AgentModel;
import br.com.mariojp.ai.agent.AgentFactory;
import br.com.mariojp.ai.agent.IAgent;
import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.ai.agent.exception.EmptyBorderException;



/**
 * 
 * @project AgenteFW
 * @package br.com.mariojp.exemplos.aspirador
 * @file AgenteAspirador.java
 * @author uoston e luana
 * @version 1.1
 *
 * <p>Classe que representa o Agente para o problema do Aspirador</p>
 *
 */
public class AgenteMetro {


	/**
	 * Metodo main
	 * @param args
	 */
	
	
	public static void main(String[] args) throws IOException {
            
            Mapa mapaSalvador = new Mapa();

    //        System.out.println(mapaSalvador.mapa);
/*  
	    BufferedReader teclado = new BufferedReader(new InputStreamReader(
				System.in));            
            System.out.println("Qual a estacão inicial?");
            int estacaoInicial = Integer.parseInt(teclado.readLine());
            System.out.println("Qual a estacão final?");
            int estacaoFinal = Integer.parseInt(teclado.readLine());
         */   
            Estado EstacaoInicial = new Estado(2);
            EstacaoInicial.setEstacoesmt(2);
            Estado EstacaoFinal = new Estado(4);
            
            //Criando uma instancia da configura��o do agente.
            AgentModel model = new AgentModel();
            model.setInitState(EstacaoInicial);
            
            model.addObjective(EstacaoFinal);
            
            //Instanciando e adicionando as Açoes
            model.addAction("Mover",new Mover());
            
            //Definindo a estrategia
            model.setType(IAgent.DEPTH_FIRST_SEARCH);
            //Criamos o agente
            IAgent agente = AgentFactory.createAgent(model);
		
            INode nofinal = null;
            try {
                    nofinal = agente.function();
            } catch (EmptyBorderException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
            //nofinal;
            List<INode> cam = agente.getPath(nofinal);
            //	agente.showGraphic(cam,"aspirador");
            System.out.println(cam);
            System.out.println(agente);
            System.out.println(nofinal);
           // System.out.println("-------------");
        }
}