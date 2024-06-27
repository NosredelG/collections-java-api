package edu.dio.list.operacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> itens;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        itens.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome){
        List<Item> itensParaRemover = new ArrayList<>();

        for(Item i : itens){
            if(i.getNome().equalsIgnoreCase(nome)){
                itensParaRemover.add(i);
            }
        }

        itens.removeAll(itensParaRemover);
    }

    public double calcularValorTotal(){
        double total = 0;

        for(Item i : itens){
            total += (i.getPreco() * i.getQuantidade());
        }

        return total;
    }

    public void exibirItens(){
        System.out.println(itens);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
        System.out.println("Valor Total: R$ " + carrinhoDeCompras.calcularValorTotal());

        carrinhoDeCompras.adicionarItem("mouse", 50, 4);
        carrinhoDeCompras.adicionarItem("teclado", 100, 2);
        carrinhoDeCompras.adicionarItem("monitor", 750, 2);

        carrinhoDeCompras.exibirItens();
        System.out.println("Valor Total: R$ " + carrinhoDeCompras.calcularValorTotal());

        carrinhoDeCompras.removerItem("monitor");

        carrinhoDeCompras.exibirItens();
        System.out.println("Valor Total: R$ " + carrinhoDeCompras.calcularValorTotal());
    }
}
