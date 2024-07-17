package edu.dio.setInterface.Ordenacao;

import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;

public class CadastroProdutos {
    private Set<Produto> setProdutos;

    public CadastroProdutos() {
        this.setProdutos = new HashSet<>();
    }

    public void adicionarProduto(long cod, String nome, double preco, int quantidade){
        setProdutos.add(new Produto(cod, nome, preco, quantidade));
    }

    public Set<Produto> exibirProdutosPorNome(){
        Set<Produto> produtosPorNome = new TreeSet<>(setProdutos);
        return produtosPorNome;
    }

    public Set<Produto> exibirProdutosPorPreco(){
        Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());

        produtosPorPreco.addAll(setProdutos);

        return produtosPorPreco;
    }

    public static void main(String[] args) {
        // Criando uma instância do CadastroProdutos
        CadastroProdutos cadastroProdutos = new CadastroProdutos();
    
        // Adicionando produtos ao cadastro
        cadastroProdutos.adicionarProduto(1L, "Smartphone", 1000d, 10);
        cadastroProdutos.adicionarProduto(2L, "Notebook", 1500d, 5);
        cadastroProdutos.adicionarProduto(1L, "Mouse", 30d, 20);
        cadastroProdutos.adicionarProduto(4L, "Teclado", 50d, 15);
    
        // Exibindo todos os produtos no cadastro
        System.out.println("\nProdutos: " + cadastroProdutos.setProdutos);
    
        // Exibindo produtos ordenados por nome
        System.out.println("\nProdutos por nome: " + cadastroProdutos.exibirProdutosPorNome());
    
        // Exibindo produtos ordenados por preço
        System.out.println("\nProdutos por preco: " + cadastroProdutos.exibirProdutosPorPreco());
      }
}
