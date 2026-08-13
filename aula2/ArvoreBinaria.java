package aula2;

public class ArvoreBinaria{

    static class No{
        String nome;
        No esquerda, direita;

        No(String nome){
            this.nome = nome;
            esquerda = direita = null;
        }
    }


    No raiz; // fica nulo de vez

    void inserir(String nome){
        raiz = inserirRecursivo(raiz, nome);
    } // o raiz que é nulo vai retornar um valor recursivo

    protected No inserirRecursivo(No atual, String nome){
        if(atual == null){
            return new No(nome);
        }
        return null;
    }// pegaa a raiz e vai inserindo recursivamente, se for nulo ele cria um novo nó


    public static void main(String[] args){
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserir("Lucas");
        System.out.println("Nome inserido: " + arvore.raiz.nome);


        //Lista com 10 nomes
        String[] nomes = {
            "Lucas", "Amanda", "Bruno", "Carla", "Eduardo", "Fernanda", "Gustavo", "Helena", "Igor", "Beatriz"
        };

        for (String nome: nomes) {
            arvore.inserir(nome);
        }

        //Exibir os nomes em ordem
        // arvore.emOrdem();


    }
    }