package edu.dio.map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    private Map<String, Integer> mapPalavras;

    public ContagemPalavras() {
        this.mapPalavras = new HashMap<>();
    } 

    public void adicionarPalavra(String palavra, Integer contagem){
        mapPalavras.put(palavra, contagem);
    }

    public void removerPalavra(String palavra){
        if(!mapPalavras.isEmpty()){
            mapPalavras.remove(palavra);
        }
        else{
            System.out.println("Nao ha palavras");
        }
    }

    public void exibirContagemPalavras(){
        if(!mapPalavras.isEmpty()){
            System.out.println(mapPalavras);
        }
        else{
            System.out.println("Nao ha palavras");
        }
    }

    public int exibirContagemTotalPalavras() {
        int contagemTotal = 0;
        for (int contagem : mapPalavras.values()) {
          contagemTotal += contagem;
        }
        return contagemTotal;
      }

    public void encontrarPalavraMaisFrequente(){
        String palavraMaisFrequente = null;
        int maiorContagem = 0;

        for(Map.Entry<String, Integer> entry : mapPalavras.entrySet()){
            if(entry.getValue() > maiorContagem){
                maiorContagem = entry.getValue();
                palavraMaisFrequente = entry.getKey();
            }
        }

        System.out.println("A linguagem mais frequente é: " + palavraMaisFrequente + ", " + maiorContagem + " vezes.");
    }  

    public static void main(String[] args) {
        ContagemPalavras contagemLinguagens = new ContagemPalavras();
    
        // Adiciona linguagens e suas contagens
        contagemLinguagens.adicionarPalavra("Java", 2);
        contagemLinguagens.adicionarPalavra("Python", 8);
        contagemLinguagens.adicionarPalavra("JavaScript", 1);
        contagemLinguagens.adicionarPalavra("C#", 6);
    
        // Exibe a contagem total de linguagens
        System.out.println("Existem " + contagemLinguagens.exibirContagemTotalPalavras() + " palavras.");
        contagemLinguagens.exibirContagemPalavras();
        // Encontra e exibe a linguagem mais frequente
        contagemLinguagens.encontrarPalavraMaisFrequente();

        contagemLinguagens.removerPalavra("Python");
        // Exibe a contagem total de linguagens
        System.out.println("Existem " + contagemLinguagens.exibirContagemTotalPalavras() + " palavras.");
        contagemLinguagens.exibirContagemPalavras();
        // Encontra e exibe a linguagem mais frequente
        contagemLinguagens.encontrarPalavraMaisFrequente();
      }
}
