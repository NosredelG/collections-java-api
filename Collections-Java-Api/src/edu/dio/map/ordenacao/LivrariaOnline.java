package edu.dio.map.ordenacao;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class LivrariaOnline {
    private Map<String, Livro> mapLivraria;

    public LivrariaOnline() {
        this.mapLivraria = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco){
        mapLivraria.put(link, new Livro(titulo, autor, preco));
    }

    public void removerLivro(String titulo){
        List<String> livrosParaRemover = new ArrayList<>();

        if(!mapLivraria.isEmpty()){
            for(Map.Entry<String, Livro> entry : mapLivraria.entrySet()){
                if(entry.getValue().getTitulo().equalsIgnoreCase(titulo)){
                    livrosParaRemover.add(entry.getKey());
                }
            }
        }

        for(String chave : livrosParaRemover){
            mapLivraria.remove(chave);
        }
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco(){
        List<Map.Entry<String, Livro>> livrosOrdenadoPorPreco = new ArrayList<>(mapLivraria.entrySet());

        Collections.sort(livrosOrdenadoPorPreco, new ComparatorPorPreco());

        Map<String, Livro> mapLivrariaOrdenadoPorPreco = new LinkedHashMap<>();

        for(Map.Entry<String, Livro> entry : livrosOrdenadoPorPreco){
            mapLivrariaOrdenadoPorPreco.put(entry.getKey(), entry.getValue());
        }

        return mapLivrariaOrdenadoPorPreco;
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorAutor(){
        List<Map.Entry<String, Livro>> livrosOrdenadoPorAutor = new ArrayList<>(mapLivraria.entrySet());

        Collections.sort(livrosOrdenadoPorAutor, new ComparatorPorAutor());

        Map<String, Livro> mapLivrariaOrdenadoPorAutor = new LinkedHashMap<>();

        for(Map.Entry<String, Livro> entry : livrosOrdenadoPorAutor){
            mapLivrariaOrdenadoPorAutor.put(entry.getKey(), entry.getValue());
        }

        return mapLivrariaOrdenadoPorAutor;
    }

    public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
    Map<String, Livro> livrosPorAutor = new LinkedHashMap<>();
    for (Map.Entry<String, Livro> entry : mapLivraria.entrySet()) {
      Livro livro = entry.getValue();
      if (livro.getAutor().equals(autor)) {
        livrosPorAutor.put(entry.getKey(), livro);
      }
    }
    return livrosPorAutor;
  }

  public List<Livro> obterLivroMaisCaro() {
    List<Livro> livrosMaisCaros = new ArrayList<>();
    double precoMaisAlto = Double.MIN_VALUE;

    if (!mapLivraria.isEmpty()) {
      for (Livro livro : mapLivraria.values()) {
        if (livro.getPreco() > precoMaisAlto) {
          precoMaisAlto = livro.getPreco();
        }
      }
    } else {
      throw new NoSuchElementException("A livraria está vazia!");
    }

    for(Map.Entry<String, Livro> entry: mapLivraria.entrySet()) {
      if(entry.getValue().getPreco() == precoMaisAlto) {
        Livro livroComPrecoMaisAlto = mapLivraria.get(entry.getKey());
        livrosMaisCaros.add(livroComPrecoMaisAlto);
      }
    }
    return livrosMaisCaros;
  }

  public List<Livro> obterLivroMaisBarato() {
    List<Livro> livrosMaisBaratos = new ArrayList<>();
    double precoMaisBaixo = Double.MAX_VALUE;

    if (!mapLivraria.isEmpty()) {
      for (Livro livro : mapLivraria.values()) {
        if (livro.getPreco() < precoMaisBaixo) {
          precoMaisBaixo = livro.getPreco();
        }
      }
    } else {
      throw new NoSuchElementException("A livraria está vazia!");
    }

    for(Map.Entry<String, Livro> entry: mapLivraria.entrySet()) {
      if(entry.getValue().getPreco() == precoMaisBaixo) {
        Livro livroComPrecoMaisBaixo = mapLivraria.get(entry.getKey());
        livrosMaisBaratos.add(livroComPrecoMaisBaixo);
      }
    }
    return livrosMaisBaratos;
  }

  public static void main(String[] args) {
    LivrariaOnline livrariaOnline = new LivrariaOnline();
    // Adiciona os livros à livraria online
    livrariaOnline.adicionarLivro("https://amzn.to/3EclT8Z", "1984", "George Orwell", 50d);
    livrariaOnline.adicionarLivro("https://amzn.to/47Umiun", "A Revolução dos Bichos", "George Orwell", 7.05d);
    livrariaOnline.adicionarLivro("https://amzn.to/3L1FFI6", "Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99d);
    livrariaOnline.adicionarLivro("https://amzn.to/3OYb9jk", "Malorie", "Josh Malerman", 5d);
    livrariaOnline.adicionarLivro("https://amzn.to/45HQE1L", "E Não Sobrou Nenhum", "Agatha Christie", 50d);
    livrariaOnline.adicionarLivro("https://amzn.to/45u86q4", "Assassinato no Expresso do Oriente", "Agatha Christie", 5d);

    // Exibe todos os livros ordenados por preço
    System.out.println("Livros ordenados por preço: \n" + livrariaOnline.exibirLivrosOrdenadosPorPreco());

    //Exibe todos os livros ordenados por autor
    System.out.println("Livros ordenados por autor: \n" + livrariaOnline.exibirLivrosOrdenadosPorAutor());

    // Pesquisa livros por autor
    String autorPesquisa = "Josh Malerman";
    livrariaOnline.pesquisarLivrosPorAutor(autorPesquisa);

    // Obtém e exibe o livro mais caro
    System.out.println("Livro mais caro: " + livrariaOnline.obterLivroMaisCaro());

    // Obtém e exibe o livro mais barato
    System.out.println("Livro mais barato: " + livrariaOnline.obterLivroMaisBarato());

    // Remover um livro pelo título
    livrariaOnline.removerLivro("1984");
    System.out.println(livrariaOnline.mapLivraria);

  }
}
