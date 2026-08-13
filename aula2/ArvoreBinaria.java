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
        if (nome.compareToIgnoreCase(atual.nome) < 0) {
            atual.esquerda = inserirRecursivo(atual.esquerda, nome);
        } else if (nome.compareToIgnoreCase(atual.nome) > 0) {
            atual.direita = inserirRecursivo(atual.direita, nome);
        }
        return atual;
    }

    public static void main(String[] args){
        ArvoreBinaria arvore = new ArvoreBinaria();
        arvore.inserir("Lucas");
        arvore.inserir("Amanda");
        System.out.println("Nome inserido: " + arvore.raiz.nome);
        System.out.println("Nome inserido: " + arvore.raiz.esquerda.nome);


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