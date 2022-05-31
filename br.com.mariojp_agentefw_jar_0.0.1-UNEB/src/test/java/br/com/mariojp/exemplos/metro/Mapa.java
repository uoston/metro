package br.com.mariojp.exemplos.metro;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author uoston e luana
 */
public class Mapa {
    public static HashMap<Integer, HashMap> mapa = new HashMap<Integer, HashMap>();
 
    

    public Mapa(){
        this.gerarDistanciaDireta();
    }
    
    public void gerarLinhas(){
            try { 
            FileReader arq = new FileReader("D:/Uneb/IA/trabalho_1/Framework-Busca/agent-uneb/arquivos/linha.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            
            
        } catch (IOException e) {
          System.out.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
    }
    public void gerarDistanciaDireta(){
       try {
        FileReader arq = new FileReader("D:/Uneb/IA/trabalho_1/Framework-Busca/agent-uneb/arquivos/distancia_real.txt");
        BufferedReader lerArq = new BufferedReader(arq);

        String l = lerArq.readLine(); // lê a primeira linha
        int indexlinha = 1;
        while (l != null) {
            HashMap<Integer, Double> e = new HashMap<Integer, Double>();
            //quebra a linha em cada estação
                     
            String[] qtlinha = l.split(";");
            //Quebra cada campo e chave valor(Estação,Distancia)
            for (int i = 0; i < qtlinha.length; i++) {
                String auxlinha = qtlinha[i].trim();
                String[] EstDist = auxlinha.split(",");
                Integer chave = Integer.parseInt(EstDist[0]);
                Double valor = Double.parseDouble(EstDist[1]);
                //inseri a Estação objetivo e a distancia
                //inser no mapa(HasMap) com chave(Estacação inicial) e valor da distancia da estacção anterior
                e.put(chave, valor);
            }
            mapa.put(indexlinha , e);
            indexlinha++;
            
            l = lerArq.readLine(); // lê da segunda até a última linha
        }
        arq.close();
        } catch (IOException e) {
          System.out.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }

    }
}
