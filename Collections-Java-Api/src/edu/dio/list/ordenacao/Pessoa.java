package edu.dio.list.ordenacao;

public class Pessoa implements Comparable<Pessoa>{
    private String nome;
    private int idade;
    private double altura;
    
    public Pessoa(String nome, int idade, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    @Override
    public int compareTo(Pessoa pessoa) {
        return Integer.compare(idade, pessoa.getIdade());
    } 

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public String toString() {
        return "\nNome = " + nome 
        + "\nIdade = " + idade 
        + "\nAltura = " + altura;
    }   
    
}
