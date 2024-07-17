package edu.dio.setInterface.Ordenacao;

import java.util.Set;

import java.util.TreeSet;

import java.util.HashSet;

public class GerenciadorDeAlunos {
    private Set<Aluno> setAlunos;

    public GerenciadorDeAlunos() {
        this.setAlunos = new HashSet<>();
    }

    public void adicionarAluno(Long matricula, String nome, double media){
        setAlunos.add(new Aluno(matricula, nome, media));
    }

    public void removerAluno(long matricula){
        Aluno alunoParaRemover = null;

        for(Aluno a : setAlunos){
            if(a.getMatricula() == matricula){
                alunoParaRemover = a;
                break;
            }
        }

        setAlunos.remove(alunoParaRemover);
    }

    public Set<Aluno> exibirAlunosPorNome(){
        Set<Aluno> alunosPorNome = new TreeSet<>(setAlunos);
        return alunosPorNome;
    }

    public Set<Aluno> exibirAlunosPorNota(){
        Set<Aluno> alunosPorNome = new TreeSet<>(new ComparatorPorNota());

        alunosPorNome.addAll(setAlunos);

        return alunosPorNome;
    }

    public void exibirAlunos(){
        System.out.println(setAlunos);
    }

    public static void main(String[] args) {
        // Criando uma instância do GerenciadorAlunos
        GerenciadorDeAlunos gerenciadorAlunos = new GerenciadorDeAlunos();
    
        // Adicionando alunos ao gerenciador
        gerenciadorAlunos.adicionarAluno(123456L, "João", 7.5);
        gerenciadorAlunos.adicionarAluno(123457L, "Maria", 9.0);
        gerenciadorAlunos.adicionarAluno(123458L, "Carlos", 5.0);
        gerenciadorAlunos.adicionarAluno(123459L, "Ana", 6.8);
    
        // Exibindo todos os alunos no gerenciador
        System.out.println("\nAlunos no gerenciador:");
        gerenciadorAlunos.exibirAlunos();
    
        // Removendo um aluno com matrícula inválida e outro pelo número de matrícula
        gerenciadorAlunos.removerAluno(000L);
        gerenciadorAlunos.removerAluno(123457L);
        System.out.println("\nAlunos no gerenciador:");
        gerenciadorAlunos.exibirAlunos();
    
        // Exibindo alunos ordenados por nome
        System.out.println("\nAlunos no gerenciador por nome:");
        System.out.println(gerenciadorAlunos.exibirAlunosPorNome());
    
        // Exibindo alunos ordenados por nota
        System.out.println("\nAlunos no gerenciador por nota:");
        System.out.println(gerenciadorAlunos.exibirAlunosPorNota());
      }
}
