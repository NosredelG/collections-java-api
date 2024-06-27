package edu.dio.list.operacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaDeTarefas {
    //atributo
    private List<Tarefa> tarefaList;

    public ListaDeTarefas() {
        this.tarefaList = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao){
        tarefaList.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao){
        List<Tarefa> tarefasParaRemover = new ArrayList<>();

        for(Tarefa t : tarefaList){
            if(t.getDescricao().equalsIgnoreCase(descricao)){
                tarefasParaRemover.add(t);
            }
        }

        tarefaList.removeAll(tarefasParaRemover);
    }

    public int obterNumeroTotalTarefas(){
        return tarefaList.size();
    }

    public void obterDescricaoTarefas(){
        System.out.println(tarefaList);
    }

    public static void main(String[] args) {
        ListaDeTarefas listaDeTarefas = new ListaDeTarefas();

        System.out.println("Total de tarefas: " + listaDeTarefas.obterNumeroTotalTarefas());

        listaDeTarefas.adicionarTarefa("Estudar");
        listaDeTarefas.adicionarTarefa("Estudar");
        listaDeTarefas.adicionarTarefa("Trabalhar");
        listaDeTarefas.obterDescricaoTarefas();

        System.out.println("Total de tarefas: " + listaDeTarefas.obterNumeroTotalTarefas());

        listaDeTarefas.removerTarefa("Estudar");

        System.out.println("Total de tarefas: " + listaDeTarefas.obterNumeroTotalTarefas());
    }
}
