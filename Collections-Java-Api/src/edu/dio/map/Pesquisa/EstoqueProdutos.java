package edu.dio.map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> mapProdutos;

    public EstoqueProdutos() {
        this.mapProdutos = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco){
        mapProdutos.put(cod, new Produto(nome, quantidade, preco));
    }

    public void exibirProdutos(){
        if(!mapProdutos.isEmpty()){
            System.out.println(mapProdutos);
        }
        else{
            System.out.println("Nao ha produtos no estoque!");
        }
    }

    public double calcularValorTotalEstoque(){
        double total = 0d;

        if(!mapProdutos.isEmpty()){
            for(Produto p : mapProdutos.values()){
                total += p.getPreco() * p.getQuantidade();
            }
        }

        return total;
    } 

    public Produto obterProdutoMaisCaro(){
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;

        if(!mapProdutos.isEmpty()){
            for(Produto p : mapProdutos.values()){
                if(p.getPreco() > maiorPreco){
                    maiorPreco = p.getPreco();
                    produtoMaisCaro = p;
                }
            }
        }

        return produtoMaisCaro;
    }

    public Produto obterProdutoMaisBarato(){
        Produto produtoMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;

        if(!mapProdutos.isEmpty()){
            for(Produto p : mapProdutos.values()){
                if(p.getPreco() < menorPreco){
                    menorPreco = p.getPreco();
                    produtoMaisBarato = p;
                }
            }
        }

        return produtoMaisBarato;
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque(){
        Produto maiorValorEstoque = null;
        double maiorValor = Double.MIN_VALUE;

        if(!mapProdutos.isEmpty()){
            for(Produto p : mapProdutos.values()){
                if((p.getPreco() * p.getQuantidade()) > maiorValor){
                    maiorValor = p.getPreco() * p.getQuantidade();
                    maiorValorEstoque = p;
                }
            }
        }

        return maiorValorEstoque;
    }

    // public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
    //     Produto produtoMaiorQuantidadeValorNoEstoque = null;
    //     double maiorValorTotalProdutoEstoque = 0d;
    //     if (!mapProdutos.isEmpty()) {
    //       for (Map.Entry<Long, Produto> entry : mapProdutos.entrySet()) {
    //         double valorProdutoEmEstoque = entry.getValue().getPreco() * entry.getValue().getQuantidade();
    //         if (valorProdutoEmEstoque > maiorValorTotalProdutoEstoque) {
    //           maiorValorTotalProdutoEstoque = valorProdutoEmEstoque;
    //           produtoMaiorQuantidadeValorNoEstoque = entry.getValue();
    //         }
    //       }
    //     }
    //     return produtoMaiorQuantidadeValorNoEstoque;
    //   }


    public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();
    
        // Exibe o estoque vazio
        estoque.exibirProdutos();
    
        // Adiciona produtos ao estoque
        estoque.adicionarProduto(1L, "Notebook", 1, 1500.0);
        estoque.adicionarProduto(2L, "Mouse", 5, 25.0);
        estoque.adicionarProduto(3L, "Monitor", 10, 400.0);
        estoque.adicionarProduto(4L, "Teclado", 20, 40.0);
    
        // Exibe os produtos no estoque
        estoque.exibirProdutos();
    
        // Calcula e exibe o valor total do estoque
        System.out.println("Valor total do estoque: R$" + estoque.calcularValorTotalEstoque());
    
        // Obtém e exibe o produto mais caro
        Produto produtoMaisCaro = estoque.obterProdutoMaisCaro();
        System.out.println("Produto mais caro: " + produtoMaisCaro);
    
        // Obtém e exibe o produto mais barato
        Produto produtoMaisBarato = estoque.obterProdutoMaisBarato();
        System.out.println("Produto mais barato: " + produtoMaisBarato);
    
        // Obtém e exibe o produto com a maior quantidade em valor no estoque
        Produto produtoMaiorQuantidadeValorTotal = estoque.obterProdutoMaiorQuantidadeValorTotalNoEstoque();
        System.out.println("Produto com maior quantidade em valor no estoque: " + produtoMaiorQuantidadeValorTotal);
      }
}
