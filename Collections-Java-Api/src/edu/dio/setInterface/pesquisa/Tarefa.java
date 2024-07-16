package edu.dio.setInterface.pesquisa;

public class Tarefa {
    private String descricao;
    private boolean concluida;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    @Override
    public String toString() {
        String sConcluida = "Não";
        if(concluida){
            sConcluida = "Sim";
        }
        return "\nDescricao = " + descricao + ", concluida = " + sConcluida;
    }

    
}
