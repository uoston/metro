package br.com.mariojp.exemplos.metro;

import java.util.ArrayList;
import java.util.List;

import br.com.mariojp.ai.agent.IState;
import br.com.mariojp.ai.agent.action.AbstractAction;

/**
 * 
 * @author m4r10
 * 
 */
public class Mover extends AbstractAction {

	@Override
	public List<IState> execute(IState estado) {
		List<IState> novosestados = new ArrayList<IState>();
		Estado copia = (Estado) ((Estado) estado).clone();
                
                

		novosestados.add(copia);
		return novosestados;
	}


}
