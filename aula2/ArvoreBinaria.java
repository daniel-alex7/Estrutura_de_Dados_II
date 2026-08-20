package aula2;

public class ArvoreBinaria {
    static class No {
        String nome;
        No esquerda, direita;
        No(String nome) {
            this.nome = nome;
            esquerda = direita = null;
        }

    }

    No raiz;
    void inserir(String nome) {
        raiz = inserirRecursivo(raiz, nome);
    }

    protected No inserirRecursivo(No atual, String nome) {
        if (atual == null) {
            return new No(nome);
        }

        if (nome.compareToIgnoreCase(atual.nome) < 0) {
            atual.esquerda = inserirRecursivo(atual.esquerda, nome);
        } else if (nome.compareToIgnoreCase(atual.nome) > 0) {
            atual.direita = inserirRecursivo(atual.direita, nome);
        }

        return atual;

    }

    // Travessia em Pré-Ordem (raiz -> esquerda -> direita)

    void preOrdem() {
        System.out.println("Nomes em Pré-Ordem:");
        preOrdemRecursivo(raiz);
        System.out.println();

    }

    void preOrdemRecursivo(No atual) {

        if (atual != null) {
            System.out.print(atual.nome + " "); // 1. Visita o nó atual primeiro
            preOrdemRecursivo(atual.esquerda); // 2. Depois percorre a subárvore esquerda
            preOrdemRecursivo(atual.direita); // 3. Por último percorre a subárvore direita

        }

    }

    public static void main(String[] args) {

        ArvoreBinaria arvore = new ArvoreBinaria();
        // arvore.inserir("Lucas");
        // arvore.inserir("Amanda");
        // System.out.println("Conteúdo da raiz: " + arvore.raiz.nome);
        // System.out.println("Nó esquerdo da raiz: " + arvore.raiz.esquerda.nome);
        // Lista de 10 nomes aleatórios

        String[] nomes = {
                "Lucas", "Amanda", "Bruno", "Carla", "Eduardo",
                "Fernanda", "Gustavo", "Helena", "Igor", "Beatriz", "Ana"
        };

        for (String nome : nomes) {
            arvore.inserir(nome);

        }

        arvore.preOrdem();
        arvore.exibirArvore();

    }

    // Impressão in-order (alfabética)

    void emOrdem() {
        System.out.println("Nomes em ordem alfabética:");
        emOrdemRecursivo(raiz);

    }

    void emOrdemRecursivo(No atual) {
        if (atual != null) {
            emOrdemRecursivo(atual.esquerda);
            System.out.println(atual.nome);
            emOrdemRecursivo(atual.direita);

        }

    }

    // Exibe a árvore graficamente

    void exibirArvore() {
        System.out.println("\nÁrvore Binária:");
        if (raiz == null) {
            System.out.println("(árvore vazia)");
            return;

        }

        // Exibe a raiz
        System.out.println(raiz.nome);
        // Exibe a subárvore esquerda
        if (raiz.esquerda != null) {
            exibirArvoreRecursivo(
                    raiz.esquerda,
                    "",
                    raiz.direita == null,
                    "E: "
            );

        }

        // Exibe a subárvore direita

        if (raiz.direita != null) {
            exibirArvoreRecursivo(
                    raiz.direita,
                    "",
                    true,
                    "D: "
            );
        }
    }

    // Método recursivo para exibir a árvore

    void exibirArvoreRecursivo(
            No atual,
            String prefixo,
            boolean ultimo,
            String lado) {
        if (atual == null) {
            return;

        }


        // Exibe o nó atual
        System.out.println(
                prefixo
                        + (ultimo ? "└── " : "├── ")
                        + lado
                        + atual.nome

        );

        // Define o prefixo dos filhos
        String novoPrefixo;
        if (ultimo) {
            novoPrefixo = prefixo + "  ";
        } else {
            novoPrefixo = prefixo + "│ "; // alt + 179
        }

        // Possui filho esquerdo

        if (atual.esquerda != null) {
            exibirArvoreRecursivo(
                    atual.esquerda,
                    novoPrefixo,
                    atual.direita == null,
                    "E: "
            );

        }

        // Possui filho direito
        if (atual.direita != null) {
            exibirArvoreRecursivo(
                    atual.direita,
                    novoPrefixo,
                    true,
                    "D: "

            );

        }

    }

    void exluir(String nome) {
        raiz = excluirRecursivo(raiz, nome);
    }

    No excluirRecursivo(No atual, String nome) {
        if (atual == null) {
            return null;
        }

        if (nome.compareToIgnoreCase(atual.nome) < 0) {
            atual.esquerda = excluirRecursivo(atual.esquerda, nome);
        } 
        
        else if (nome.compareToIgnoreCase(atual.nome) > 0) {
            atual.direita = excluirRecursivo(atual.direita, nome);
        } 
        
        else {
            // Nó encontrado, realizar a exclusão
            if (atual.esquerda == null && atual.direita == null) {
                // Caso 1: Nó sem filhos
                return null;

            } else if (atual.esquerda == null) {
                // Caso 2: Nó com apenas um filho à direita
                return atual.direita;

            }

            //Caso 3: Nó com dois filhos

            No predecessor = maiorNo(atual.esquerda);

            atual.nome = predecessor.nome;
            atual.esquerda = excluirRecursivo(atual.esquerda, predecessor.nome);
        }

        return atual;
    }

    No maiorNo(No atual) {
        while (atual.direita != null) {
            atual = atual.direita;
        }
        return atual;
    }

}