package edu.dio.map.ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;

public class AgendaEventos {
    private Map<LocalDate, Eventos> mapAgenda;

    public AgendaEventos() {
        this.mapAgenda = new HashMap();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao){
        mapAgenda.put(data, new Eventos(nome, atracao));
    }

    public void exibirAgenda(){
        Map<LocalDate, Eventos> eventosOrdemCrescente = new TreeMap<>(mapAgenda);
        System.out.println(eventosOrdemCrescente);
    }

    public void obterProximoEvento(){
        LocalDate dataAtual = LocalDate.now();
        Map<LocalDate, Eventos> eventosOrdemCrescente = new TreeMap<>(mapAgenda);
        for(Map.Entry<LocalDate, Eventos> entry: eventosOrdemCrescente.entrySet()){
            if(entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)){
                System.out.println("Proximo evento: " + entry.getValue() + "Data: " + entry.getKey());
                break;
            }
        }        
    }

    public static void main(String[] args) {
    AgendaEventos agendaEventos = new AgendaEventos();

    // Adiciona eventos à agenda
    agendaEventos.adicionarEvento(LocalDate.of(2022, Month.JULY, 15), "Conferência de Tecnologia", "Palestrante renomado");
    agendaEventos.adicionarEvento(LocalDate.of(2025, 7, 9), "Workshop de Programação", "Aula prática de desenvolvimento");
    agendaEventos.adicionarEvento(LocalDate.of(2000, 1, 10), "Lançamento de Software", "Demonstração da nova versão");
    agendaEventos.adicionarEvento(LocalDate.of(2023, Month.AUGUST, 28), "Hackathon de Inovação", "Competição de soluções criativas");
    agendaEventos.adicionarEvento(LocalDate.of(2024, 9, 20), "Seminário de Inteligência Artificial", "Discussão sobre IA avançada");

    // Exibe a agenda completa de eventos
    agendaEventos.exibirAgenda();

    // Obtém e exibe o próximo evento na agenda
    agendaEventos.obterProximoEvento();
  }
}
