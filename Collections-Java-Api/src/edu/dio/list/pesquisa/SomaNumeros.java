package edu.dio.list.pesquisa;

import java.util.List;
import java.util.ArrayList;

public class SomaNumeros {
    List<Integer> listaNumeros;

    public SomaNumeros() {
        this.listaNumeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        listaNumeros.add(numero);
    }

    public int calcularSoma(){
        int soma = 0;

        if(!listaNumeros.isEmpty()){
            for(int i : listaNumeros){
                soma += i;
            }
        }

        return soma;
    }

    public int encontrarMaiorNumero(){  
        int maior = 0;  
        boolean primeiroNumero = true;   

        if(!listaNumeros.isEmpty()){
            for(int i : listaNumeros){
                if(primeiroNumero){
                    maior = i;
                    primeiroNumero = false;
                }
                else{
                    if(maior < i){
                        maior = i;
                    }
                }
            }
        }

        return maior;
    }

    public int encontrarMenorNumero(){  
        int menor = 0;  
        boolean primeiroNumero = true;   

        if(!listaNumeros.isEmpty()){
            for(int i : listaNumeros){
                if(primeiroNumero){
                    menor = i;
                    primeiroNumero = false;
                }
                else{
                    if(menor > i){
                        menor = i;
                    }
                }
            }
        }

        return menor;
    }

    public void exibirNumeros(){
        for(int i : listaNumeros){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();

        somaNumeros.adicionarNumero(-10);
        somaNumeros.adicionarNumero(10);
        somaNumeros.adicionarNumero(-5);
        somaNumeros.adicionarNumero(-8);
        somaNumeros.adicionarNumero(10);
        somaNumeros.adicionarNumero(12);
        somaNumeros.adicionarNumero(-7);

        System.out.println("Lista dos numeros: \n");
        somaNumeros.exibirNumeros();
        System.out.println("Soma dos numeros: " + somaNumeros.calcularSoma());
        System.out.println("Maior dos numeros: " + somaNumeros.encontrarMaiorNumero());
        System.out.println("Menor dos numeros: " + somaNumeros.encontrarMenorNumero());
    }
}
