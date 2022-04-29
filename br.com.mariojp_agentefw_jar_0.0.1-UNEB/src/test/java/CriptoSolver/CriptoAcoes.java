/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CriptoSolver;

import br.com.mariojp.ai.agent.IState;
import br.com.mariojp.ai.agent.action.AbstractAction;
import br.com.mariojp.ai.agent.exception.ImpossibleActionException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author comum
 */
public class CriptoAcoes extends AbstractAction {
    @Override
    public List<IState> execute(IState estado) throws ImpossibleActionException {
        List<IState> novosestados = new ArrayList<IState>();
        CriptoEstado ce = (CriptoEstado) estado;
        CriptoEstado cEstado = (CriptoEstado) ce.clone();
        int max = cEstado.max;
        int f = cEstado.getValorAtri(max);
        
        for (int letra = f-1; letra < f; letra++) {  
            for (int numero = 0; numero < 10; numero++) { 
                if (!cEstado.jaFoiAtribuido(numero))  {
                    if(!cEstado.eLetraInicial(letra, numero)){
                        //if(cEstado.saoDiferentes(numero)){
                            //if(cEstado.verificaFrase()){
                                CriptoEstado novo = (CriptoEstado) cEstado.clone();
                                int num = novo.getValorAtri(max);
                                        
                                novo.setValorAtri(letra, numero);      
                                novo.setValorAtri(max,num+1);   
                                novo.verificaFrase();
                                //System.out.println("novo: \n"+novo.toString());
                                novosestados.add(novo);
                            //}
                        //}
                    }
                }
            }
        }
        
        return novosestados;
    }
    
}