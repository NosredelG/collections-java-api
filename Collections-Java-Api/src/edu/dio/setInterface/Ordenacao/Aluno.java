package edu.dio.setInterface.Ordenacao;

import java.util.Comparator;

public class Aluno implements Comparable<Aluno> {
    private long matricula;
    private String nome;
    private double nota;
    
    public Aluno(long matricula, String nome, double nota) {
        this.matricula = matricula;
        this.nome = nome;
        this.nota = nota;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }      

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (matricula ^ (matricula >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aluno other = (Aluno) obj;
        if (matricula != other.matricula)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "\nMatricula = " + matricula + "\nNome = " + nome + "\nNota = " + nota;
    }

    @Override
    public int compareTo(Aluno a) {
        return nome.compareToIgnoreCase(a.getNome());
    }    
}

class ComparatorPorNota implements Comparator<Aluno>{
    @Override
    public int compare(Aluno a1, Aluno a2){
        return Double.compare(a1.getNota(), a2.getNota());
    }
}

