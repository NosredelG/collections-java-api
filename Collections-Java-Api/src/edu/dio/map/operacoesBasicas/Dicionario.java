package edu.dio.map.operacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, String> mapDicionario;

    public Dicionario() {
        this.mapDicionario = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao){
        mapDicionario.put(palavra, definicao);
    }

    public void removerPalavra(String palavra){
        if(!mapDicionario.isEmpty()){
            mapDicionario.remove(palavra);
        }
        else{
            System.out.println("Dicionario esta vazio!");
        }
    }

    public void exibirPalavras(){
        if(!mapDicionario.isEmpty()){
            System.out.println(mapDicionario);
        }
        else{
            System.out.println("Dicionario esta vazio!");
        }        
    }

    public String pesquisarPorPalavra(String palavra){
        String definicao = null;

        if(!mapDicionario.isEmpty()){
            definicao = mapDicionario.get(palavra);
            if(definicao == null){
                definicao = "Palavra nao encontrada";
            }
        }
        else{
            definicao = "Dicionario esta vazio!";
        }

        return definicao;
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();
    
        // Adicionar palavras (linguagens de programação)
        dicionario.adicionarPalavra("java", "Linguagem de programação orientada a objetos.");
        dicionario.adicionarPalavra("typescript", "Superset da linguagem JavaScript que adiciona tipagem estática.");
        dicionario.adicionarPalavra("kotlin", "Linguagem moderna de programação para a JVM.");
    
        // Exibir todas as palavras
        dicionario.exibirPalavras();
    
        // Pesquisar palavras
        String definicaoJava = dicionario.pesquisarPorPalavra("java");
        System.out.println("Definição da linguagem 'java': " + definicaoJava);
    
        String definicaoCSharp = dicionario.pesquisarPorPalavra("csharp");
        System.out.println(definicaoCSharp);
    
        // Remover uma palavra
        dicionario.removerPalavra("typescript");
        dicionario.exibirPalavras();
      }
}
