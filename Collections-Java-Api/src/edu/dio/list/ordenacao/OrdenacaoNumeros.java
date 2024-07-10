package edu.dio.list.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    private List<Integer> inteirosList;   
    
    public OrdenacaoNumeros() {
        inteirosList = new ArrayList<>();
    }
    
    public void adicionarNumero(int numero){
        inteirosList.add(numero);
    }

    public List<Integer> ordenarAscendente(){
        List<Integer> listAscendente = new ArrayList<>(inteirosList);
        Collections.sort(listAscendente);
        return listAscendente;
    } 

    public List<Integer> ordenarDescendente(){
        List<Integer> listDescendente = new ArrayList<>(inteirosList);
        listDescendente.sort(Collections.reverseOrder());

        return listDescendente;
    } 

    public void exibirNumeros() {
        System.out.println(this.inteirosList);
    }

    public static void main(String[] args) {
        // Criando uma instância da classe OrdenacaoNumeros
        OrdenacaoNumeros numeros = new OrdenacaoNumeros();
    
        // Adicionando números à lista
        numeros.adicionarNumero(2);
        numeros.adicionarNumero(5);
        numeros.adicionarNumero(4);
        numeros.adicionarNumero(1);
        numeros.adicionarNumero(99);
    
        // Exibindo a lista de números adicionados
        numeros.exibirNumeros();
    
        // Ordenando e exibindo em ordem ascendente
        System.out.println(numeros.ordenarAscendente());
    
        // Exibindo a lista
        numeros.exibirNumeros();
    
        // Ordenando e exibindo em ordem descendente
        System.out.println(numeros.ordenarDescendente());
    
        // Exibindo a lista
        numeros.exibirNumeros();
      }
}
