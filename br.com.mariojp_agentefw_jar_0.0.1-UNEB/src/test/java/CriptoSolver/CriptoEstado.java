/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CriptoSolver;

import br.com.mariojp.ai.agent.AbstractState;
import java.util.ArrayList;

/**
 *
 * @author comum
 */

public class CriptoEstado extends AbstractState {

    public int max = 10;
    public boolean criptograma;
    ArrayList<Character> letra = new ArrayList();
    private int numero[] = new int[max + 1];
    ArrayList<String> frase = new ArrayList();

    
    public CriptoEstado(int valor) {
        numero[max] = valor;
    }
    
    public CriptoEstado() {
    }
    
    public boolean jaFoiAtribuido(int num){
        boolean resultado = false;
        for(int i = 0; i < numero[max]-1; i++)
            if(numero[i]==num){
                resultado = true;
            }
        return resultado;
    }
    
    public boolean saoDiferentes(){
        boolean diferente = true;
        int limite = 1;
        for (int veriDiferenca =0; veriDiferenca < letra.size(); veriDiferenca++){
            while(limite != veriDiferenca && limite < letra.size()){
                if(numero[veriDiferenca] == numero[limite]){
                    diferente = false;
                    return diferente;
            }
                limite++;
            }
            
            limite=veriDiferenca+2;
        }
        return diferente;
    }
    
    public boolean eLetraInicial(int posicao, int numero){
        boolean resultado = false;
        if(numero==0){
            for (int cont=0; cont < frase.size(); cont=cont+2){
                String palavra = frase.get(cont);
                if(posicao<letra.size()){
                    if(palavra.charAt(0) == letra.get(posicao)){
                        resultado = true;
                    }
                }
            }
        }
        return resultado;
    }
   
        public int getMAX() {
        return max;
    }

    public void setMAX(int MAX) {
        this.max = MAX;
    }
    
    public ArrayList<Character> getLetra() {
        return letra;
    }

    public void setLetra(ArrayList<Character> letra) {
        this.letra = letra;
    }

    public int[] getNumero() {
        return numero;
    }

    public void setNumero(int[] numero) {
        this.numero = numero;
    }
    
    public void setValorAtri(int let, int num) {
        numero[let] = num;
    }

    public int getValorAtri(int pos) {
        return numero[pos];
    }
    
    public ArrayList<String> getFrase() {
        return frase;
    }

    public void setFrase(ArrayList<String> frase) {
        this.frase = frase;
    }

    public boolean isCriptograma() {
        return criptograma;
    }

    public void setCriptograma(boolean criptograma) {
        this.criptograma = criptograma;
    }
    
     public boolean verificaFrase(){
        ArrayList<Integer> auxFrase;
        auxFrase = new ArrayList();
        ArrayList<String> auxOp;
        auxOp = new ArrayList();
        
        if(!saoDiferentes()){
            return false;
        }
            
        for(int contOperador=1; contOperador < frase.size(); contOperador=contOperador+2){
            auxOp.add(frase.get(contOperador));
        }
        
        for(int contPalavra = 0; contPalavra < frase.size(); contPalavra=contPalavra+2){
            char[] palavra = frase.get(contPalavra).toCharArray();
            String numPalavra = "";
            for(int contLet = 0; contLet < palavra.length; contLet++){
                for(int veriLet = 0; veriLet < letra.size(); veriLet++ ){
                    if(palavra[contLet] == letra.get(veriLet)){
                       numPalavra = numPalavra.concat(String.valueOf(numero[veriLet]));
                    }
                }
            }
            auxFrase.add(Integer.parseInt(numPalavra));
        }
        boolean resultado = verificaResultado(auxFrase,auxOp);
        if(resultado){
            setCriptograma(true);
        }
        return resultado;
    }
     //VERIFICA O RESULTADO
    public boolean verificaResultado(ArrayList<Integer> frase, 
            ArrayList<String> operador){
        boolean resultado = false;
        int aux1=0;
        int aux2=0;
        int iteracao = 0;
        //int contador = 0;
        
        for(int ope = 0; ope < operador.size(); ope++){
            if(operador.get(ope).equals("AND") || 
                    operador.get(ope).equals("OR") ||
                    operador.get(ope).equals("NOT")){
                resultado = logica(frase,operador);
                return resultado;  
            }
        }
                
            for(int op = 0; op < operador.size(); op++){
              if(operador.get(op).equals("+")){
                  if(iteracao==0){
                  aux1 = frase.get(op) + frase.get(op+1);
                  iteracao++;
                  }
                  else
                      aux1=aux1+frase.get(op+1);
              }
              if(operador.get(op).equals("-")){
                  if(iteracao==0){
                  aux1 = frase.get(op) - frase.get(op+1);
                  iteracao++;
                  }
                  else
                      aux1=aux1-frase.get(op+1);
              }
              if(operador.get(op).equals("*")){
                  if(iteracao==0){
                  aux1 = frase.get(op) * frase.get(op+1);
                  iteracao++;
                  }
                  else
                      aux1=aux1*frase.get(op+1);
              }
              if(operador.get(op).equals("/")){
                  if(iteracao==0){
                  aux1 = frase.get(op) / frase.get(op+1);
                  iteracao++;
                  }
                  else
                      aux1=aux1/frase.get(op+1);
              }
              if(operador.get(op).equals("**")){
                  aux2 = (int) Math.pow(frase.get(op), frase.get(op+1));
              }
              if(operador.get(op).equals("=")){
                  aux2 = frase.get(op+1);
                  if(aux1==aux2){
                      resultado = true;
                  }
                  
              }
              if(operador.get(op).equals("<")){
                  if(aux1<segundaParte(frase, operador, op)){
                      resultado = true;
                      return resultado;
                  }
              }
              if(operador.get(op).equals(">")){
                  if(aux1>segundaParte(frase, operador, op)){
                      resultado = true;
                      return resultado;
                  }
              }
             
            }
                    
        return resultado;
    }
    
    public int segundaParte(ArrayList<Integer> frase, 
            ArrayList<String> operador, int op){
        int aux2=0;
        int iteracao = 0;
      
            for(int ope = op; ope < operador.size(); ope++){
              if(operador.get(ope).equals("+")){
                  if(iteracao==0){
                  aux2 = frase.get(ope) + frase.get(ope+1);
                  iteracao++;
                  }
                  else
                      aux2=aux2+frase.get(ope+1);
              }
              if(operador.get(ope).equals("-")){
                  if(iteracao==0){
                  aux2 = frase.get(ope) - frase.get(ope+1);
                  iteracao++;
                  }
                  else
                      aux2=aux2-frase.get(ope+1);
              }
              if(operador.get(ope).equals("*")){
                  if(iteracao==0){
                  aux2 = frase.get(ope) * frase.get(ope+1);
                  iteracao++;
                  }
                  else
                      aux2=aux2*frase.get(ope+1);
              }
              if(operador.get(ope).equals("/")){
                  if(iteracao==0){
                  aux2 = frase.get(ope) / frase.get(ope+1);
                  iteracao++;
                  }
                  else
                      aux2=aux2/frase.get(ope+1);
              }
              if(operador.get(ope).equals("**")){
                  aux2 = (int) Math.pow(frase.get(ope), frase.get(ope+1)); 
              }
            }
            return aux2;
    }
    
    public boolean logica(ArrayList<Integer> frase, 
            ArrayList<String> operador){
        boolean retorno = false;
        boolean entrei = false;
        ArrayList<Integer> frase1 = new ArrayList();
        ArrayList<Integer> frase2 = new ArrayList();
        ArrayList<String> operadores1 = new ArrayList();
        ArrayList<String> operadores2 = new ArrayList();
        
        for(int ope = 0; ope < operador.size(); ope++){
            
            if(operador.get(ope).equals("AND") || 
                    operador.get(ope).equals("OR")
                    ){
                entrei = true;
                int posiLog = ope;
                frase1.add(frase.get(ope));
                boolean aux1 = verificaResultado(frase1,operadores1);
                ope++;
                
                while(ope < operador.size()){
                    frase2.add(frase.get(ope));
                    operadores2.add(operador.get(ope));
                }
                
                if(operador.get(posiLog).equals("AND")){
                    frase2.add(frase.get(ope++));
                    boolean aux2 = verificaResultado(frase2,operadores2);
                    
                    if(aux1 && aux2){
                        return true;
                    }
                    else{
                        return false;
                    }                         
                }
                
                if(operador.get(posiLog).equals("OR")){
                    frase2.add(frase.get(ope++));
                    boolean aux2 = verificaResultado(frase2,operadores2);
                    
                    if(aux1 || aux2){
                        return true;
                    }
                    else{
                        return false;
                    }                         
                }
                
                if(operador.get(ope).equals("NOT")){
                                        
                    if(aux1){
                        return false;
                    }
                    else{
                        return true;
                    }                         
                }
                
                    ope = posiLog;
            }          
            
            if(!entrei){
                frase1.add(frase.get(ope));
                operadores1.add(operador.get(ope));
            }
                        
        }     
        
        
       
        return retorno;
    }
    
    public Object clone() {
        Object copia = null;
        try {
            copia = super.clone();
            ((CriptoEstado) copia).setNumero(this.clonar());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return copia;
    }

    private int[] clonar() {
        int f = numero[max];   
                
        int[] novoNumero = new int[max + 1];        
        for (int i = 0; i < f; i++) {
            novoNumero[i] = numero[i]; 
        }
        
        novoNumero[max] = f;
       
        return novoNumero;
    }
    
    @Override
    public boolean equals(Object arg0) {
        CriptoEstado estado = (CriptoEstado) arg0;
        boolean igual = false;
        if (numero == estado.getNumero()) {
            igual = true;
        }
        return igual;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        if(isCriptograma())
            sb.append("É um criptograma");
        else
            sb.append("NÃO é um criptograma");
        
        for(int i=0; i<letra.size();i++){
           sb.append(" Letra "+letra.get(i)+ "="+numero[i]);
        }
     
        return sb.toString();
    }
    
}
