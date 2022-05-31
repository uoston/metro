package br.com.mariojp.exemplos.metro;

import java.util.ArrayList;
import java.util.List;

import br.com.mariojp.ai.agent.IState;
import br.com.mariojp.ai.agent.action.AbstractAction;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 
 * @author m4r10
 * 
 */
public class Mover extends AbstractAction {

	@Override
	public List<IState> execute(IState estado) {
            List<IState> novosestados = new ArrayList<IState>();
            Estado original = (Estado) ((Estado) estado).clone();
            Estado copia = (Estado) ((Estado) estado).clone();


            copia.setEstacaoAnt(original.getEstacao());


            System.out.println(Mapa.mapa.get(copia.getEstacao()).keySet());
            System.out.println(Estado.estacoesAnt);
            
            Iterator<Integer> it = Mapa.mapa.get(copia.getEstacao()).keySet().iterator(); 

            while(it.hasNext()) {
                int e = it.next();
                
                if(copia.checaEstacaAnt(e)){
            //        System.out.println(copia.getEstacao());
                    copia.setEstacao(e);
                    Estado.estacoesAnt.add(copia.getEstacao());
      //              copia.estacoesAnt.add(copia.getEstacao());
                    novosestados.add(copia);
                }
           
            }    
            
             return novosestados;
        }
       	@Override
	public List<IState> revert(IState estado) {
		List<IState> novosestados = new ArrayList<IState>();
		Estado original = (Estado) estado;
		Estado novoestado = (Estado) original.clone();

                novoestado.setEstacao(original.getEstacaoAnt());
		novosestados.add(novoestado);
		return novosestados;
	}
      

}
