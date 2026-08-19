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

    void preOrdem(){
        System.out.println("Nomes em pré-ordem: ");
        preOrdemRecursivo(raiz);
        System.out.println();
    }

    void preOrdemRecursivo(No atual){
        if(atual != null){
            System.out.print(atual.nome + " ");//visita no atual primeiro
            preOrdemRecursivo(atual.esquerda);//depois percorre a subárvore esquerda
            preOrdemRecursivo(atual.direita);//por ultimo percorre a subárvore direita
        }
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
        arvore.preOrdem();
        arvore.emOrdem();

    }

    void emOrdem(){
        System.out.println("Nomes em ordem: ");
        emOrdemRecursivo(raiz);
        System.out.println();

    }

    void emOrdemRecursivo(No atual){
        if(atual != null){
            emOrdemRecursivo(atual.esquerda);
            System.out.print(atual.nome + " ");
            emOrdemRecursivo(atual.direita);
        }
    }

    //Exibir árvore binária graficamente
    void exibirArvore(){
        System.out.println("\nÁrvore binária: ");
        if(raiz == null){
            System.out.println("Árvore vazia");
            return;
        } 

        System.out.println(raiz.nome);


        if(raiz.esquerda != null){
         exibirArvoreRecurivo(raiz.esquerda, 
            "",
            raiz.direita == null,
            "E: "
         );
    }

    if(raiz.direita != null){
        exibirArvoreRecurivo(raiz.direita, 
            "",
            true,
            "D: "
        );
    }
}

    void exibirArvoreRecurivo(No atual, String prefixo, boolean ultimo, String lado){
        if(atual == null){
            return;
        }    

        System.out.println(prefixo + 
            (ultimo ? "└── " : "├── ") 
            + lado 
            +atual.nome);

        System.out.println(prefixo + (ultimo ? "└── " : "├── ") + lado + atual.nome);

        String novoPrefixo;

        if(ultimo){
            novoPrefixo = prefixo + "└── ";
        } else {
            novoPrefixo = prefixo + "├── ";
        }

        if (atual.esquerda != null){
            exibirArvoreRecurivo(atual.esquerda, novoPrefixo, atual.direita == null, "E: ");      
        }
}
}
    
