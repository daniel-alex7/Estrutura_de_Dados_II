package aula2;

public class ArvoreBinaria{

    static class No{
        String nome;
        No esquerda, direita;

        No(String nome){
            this.nome = nome;
            esquerda = direita = null;
        }
    };


    
    public static void main(String[] args){
        ArvoreBinaria arvore = new ArvoreBinaria();

        

        //Lista com 10 nomes
        String[] nomes = {
            "Lucas", "Amanda", "Bruno", "Carla", "Eduardo", "Fernanda", "Gustavo", "Helena", "Igor", "Beatriz"
        };

        for (String nome: nomes) {
            arvore.inserir(nome);
        }

        //Exibir os nomes em ordem
        arvore.emOrdem();


    }
    }