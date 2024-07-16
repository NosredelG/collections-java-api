package edu.dio.setInterface.pesquisa;

import java.util.Set;
import java.util.HashSet;

public class ListaTarefas {
    private Set<Tarefa> setTarefa;

    public ListaTarefas() {
        this.setTarefa = new HashSet<>();
    }   

    public void adicionarTarefa(String descricao){
        setTarefa.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao){
        Tarefa tarefa = null;

        for(Tarefa t : setTarefa){
            if(t.getDescricao().equalsIgnoreCase(descricao)){
                tarefa = t;
                break;
            }
        }

        setTarefa.remove(tarefa);
    }

    public void exibirTarefas(){
        if(!setTarefa.isEmpty()){
            System.out.println(setTarefa);
        }
        else{
            System.out.println("Sem tarefas!");
        }
    }

    public int contarTarefas(){
        return setTarefa.size();
    }

    public Set<Tarefa> obterTarefasConcluidas(){
        Set<Tarefa> tarefasConcluidas = new HashSet<>();

        for(Tarefa t : setTarefa){
            if(t.isConcluida()){
                tarefasConcluidas.add(t);
            }
        }

        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes(){
        Set<Tarefa> tarefasPendentes = new HashSet<>();

        for(Tarefa t : setTarefa){
            if(!t.isConcluida()){
                tarefasPendentes.add(t);
            }
        }

        return tarefasPendentes;
    }

    public void marcarTarefaConcluida(String descricao){
        for(Tarefa t : setTarefa){
            if(t.getDescricao().equalsIgnoreCase(descricao)){
                t.setConcluida(true);
                break;
            }
        }
    }

    public void marcarTarefaPendente(String descricao){
        for(Tarefa t : setTarefa){
            if(t.getDescricao().equalsIgnoreCase(descricao)){
                t.setConcluida(false);
                break;
            }
        }
    }


    public void limparListaTarefas(){
        setTarefa.clear();
    }

    public static void main(String[] args) {
        // Criando uma instância da classe ListaTarefas
        ListaTarefas listaTarefas = new ListaTarefas();
    
        // Adicionando tarefas à lista
        listaTarefas.adicionarTarefa("Estudar Java");
        listaTarefas.adicionarTarefa("Fazer exercícios físicos");
        listaTarefas.adicionarTarefa("Organizar a mesa de trabalho");
        listaTarefas.adicionarTarefa("Ler livro");
        listaTarefas.adicionarTarefa("Preparar apresentação");
    
        // Exibindo as tarefas na lista
        listaTarefas.exibirTarefas();
    
        // Removendo uma tarefa
        listaTarefas.removerTarefa("Fazer exercícios físicos");
        listaTarefas.exibirTarefas();
    
        // Contando o número de tarefas na lista
        System.out.println("Total de tarefas na lista: " + listaTarefas.contarTarefas());
    
        // Obtendo tarefas pendentes
        System.out.println(listaTarefas.obterTarefasPendentes());
    
        // Marcando tarefas como concluídas
        listaTarefas.marcarTarefaConcluida("Ler livro");
        listaTarefas.marcarTarefaConcluida("Estudar Java");
    
        // Obtendo tarefas concluídas
        System.out.println(listaTarefas.obterTarefasConcluidas());
    
        // Marcando tarefas como pendentes
        listaTarefas.marcarTarefaPendente("Estudar Java");
        listaTarefas.exibirTarefas();

        System.out.println(listaTarefas.obterTarefasPendentes());
    
        // Limpando a lista de tarefas
        listaTarefas.limparListaTarefas();
        listaTarefas.exibirTarefas();
      }

}
