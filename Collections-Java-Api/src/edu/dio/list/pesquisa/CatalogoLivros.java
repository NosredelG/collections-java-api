package edu.dio.list.pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {

    private List<Livro> livros;   

    public CatalogoLivros() {
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int ano){
        livros.add(new Livro(titulo, autor, ano));
    }

    public List<Livro> pesquisarPorAutor(String autor){
        List<Livro> livrosPorAutor = new ArrayList<>();
        if(!livros.isEmpty()){
            for(Livro l : livros){
                if(l.getAutor().equalsIgnoreCase(autor)){
                    livrosPorAutor.add(l);
                }
            }
        }
        return livrosPorAutor;
    }

    public List<Livro> pesquisarPorIntervaloDeAnos(int anoInicial, int anoFinal){
        List<Livro> livrosPorIntervaloDeAnos = new ArrayList<>();
        if(!livros.isEmpty()){
            for(Livro l : livros){
                if(l.getAnoPublicacao() >= anoInicial && l.getAnoPublicacao() <= anoFinal){
                    livrosPorIntervaloDeAnos.add(l);
                }
            }
        }
        return livrosPorIntervaloDeAnos;
    }

    public Livro pesquisarPorTitulo(String titulo){  
        Livro livro = null;      
        if(!livros.isEmpty()){
            for(Livro l : livros){
                if(l.getTitulo().equalsIgnoreCase(titulo)){
                    livro = l;
                    break;
                }
            }
        }
        return livro;
    }

    public static void main(String[] args) {
        CatalogoLivros catalogo = new CatalogoLivros();

        catalogo.adicionarLivro("A cruz de Cristo", "John Stot", 1982);
        catalogo.adicionarLivro("Evangelho de Mateus", "John Stot", 1985);
        catalogo.adicionarLivro("Evangelho de Mateus", "Hernandes Dias Lopes", 2001);
        catalogo.adicionarLivro("A cruz de Cristo", "Hernandes Dias Lopes", 1985);

        System.out.println("Livros do John Stot");
        System.out.println(catalogo.pesquisarPorAutor("John Stot"));

        System.out.println("\nLivros do Hernandes");
        System.out.println(catalogo.pesquisarPorAutor("Hernandes Dias Lopes"));

        System.out.println("\nLivros entre 1985 e 2002");
        System.out.println(catalogo.pesquisarPorIntervaloDeAnos(1985, 2002));

        System.out.println("\nLivros com o titulo Evangelho de Mateus");
        System.out.println(catalogo.pesquisarPorTitulo("Evangelho de Mateus"));
    }

}
