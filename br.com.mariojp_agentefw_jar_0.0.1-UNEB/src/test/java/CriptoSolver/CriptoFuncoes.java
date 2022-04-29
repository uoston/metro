/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CriptoSolver;

import br.com.mariojp.ai.agent.Functions;
import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.ai.agent.IState;
import java.util.ArrayList;


/**
 *
 * @author comum
 */
public class CriptoFuncoes extends Functions {
    public CriptoFuncoes() {
        super();
    }
    
    @Override
    public double h(INode node) {
        CriptoEstado ce = ((CriptoEstado) node.getState());
        int max = ce.max;        // pega o valor de max
        int quantidadeLetra = 0;
        String palavra = "";
        
        if((ce.getValorAtri(max)) < ce.getLetra().size() ){ // pega a posicao 
            //atual e verifica se ela equivale a posição de alguma letra
            char letra = ce.getLetra().get(ce.getValorAtri(max)); //pega a letra
        
            for(int i=0; i<ce.getFrase().size();i=i+2){ //varre a frase/expressão
                //a procura dessa letra
                palavra = ce.getFrase().get(i);
                for(int j=0;j<ce.getFrase().get(i).length();j++){
                    if(letra == palavra.charAt(j)){
                        quantidadeLetra++; // quando encontra, conta a quantidade
                    }
                }
            }
        }
        return quantidadeLetra; //retorna a quantidade de vezes que essa letra
        //se encontra na frase.
    }
    
    @Override
    public boolean objectiveFunction(IState node) {
        
        int numero[] = new int[11];
        ArrayList<Character> letra = new ArrayList();
        CriptoEstado ce = ((CriptoEstado) node);
        int tam=0;
        
        letra = ce.getLetra();
        numero = ce.getNumero();
        
        for(int i=0; i<letra.size();i++){
           if(numero[i]==9){
               tam++;
           }
        }
        
        if(tam == letra.size()){
            boolean retorno = true;
            return retorno;
        }
        
        
        return ce.isCriptograma();
    }
    
}
