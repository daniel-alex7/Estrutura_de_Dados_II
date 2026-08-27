package aula4;

public class ArvoreAgenda {
    static class No {
        Agenda contato;
        No esquerda, direita;
        No(Agenda contato) {
            this.contato = contato;
            esquerda = direita = null;
        }

    }

    No raiz;

    void inserir(Agenda contato) {
        raiz = inserirRecursivo(raiz, contato);
    }

    protected No inserirRecursivo(No atual, Agenda contato) {
        if (atual == null) {
            return new No(contato);
        }

        if (contato.nome.compareToIgnoreCase(atual.contato.nome) < 0) {
            atual.esquerda = inserirRecursivo(atual.esquerda, contato);
        } else if (contato.nome.compareToIgnoreCase(atual.contato.nome) > 0) {
            atual.direita = inserirRecursivo(atual.direita, contato);
        }

        return atual;

    }

    // Travessia em Pré-Ordem (raiz -> esquerda -> direita)

    void preOrdem() {
        System.out.println("Contatos em Pré-Ordem:");
        preOrdemRecursivo(raiz);
        System.out.println();

    }

    void preOrdemRecursivo(No atual) {

        if (atual != null) {
            System.out.print(atual.contato.nome + " "); // 1. Visita o nó atual primeiro
            preOrdemRecursivo(atual.esquerda); // 2. Depois percorre a subárvore esquerda
            preOrdemRecursivo(atual.direita); // 3. Por último percorre a subárvore direita

        }

    }

    // Impressão in-order (alfabética)

    void emOrdem() {
        System.out.println("Contatos em ordem alfabética:");
        emOrdemRecursivo(raiz);

    }

    void emOrdemRecursivo(No atual) {
        if (atual != null) {
            emOrdemRecursivo(atual.esquerda);
            System.out.println(atual.contato);
            emOrdemRecursivo(atual.direita);

        }

    }

    // Busca um contato pelo nome

    Agenda buscarPorNome(String nome) {
        return buscarRecursivo(raiz, nome);
    }

    Agenda buscarRecursivo(No atual, String nome) {
        if (atual == null) {
            return null;
        }

        if (nome.compareToIgnoreCase(atual.contato.nome) == 0) {
            return atual.contato;
        } else if (nome.compareToIgnoreCase(atual.contato.nome) < 0) {
            return buscarRecursivo(atual.esquerda, nome);
        } else {
            return buscarRecursivo(atual.direita, nome);
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
        System.out.println(raiz.contato.nome);
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
                        + atual.contato.nome

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

    void excluir(String nome) {
        raiz = excluirRecursivo(raiz, nome);
    }

    No excluirRecursivo(No atual, String nome) {
        if (atual == null) {
            return null;
        }

        if (nome.compareToIgnoreCase(atual.contato.nome) < 0) {
            atual.esquerda = excluirRecursivo(atual.esquerda, nome);
        }

        else if (nome.compareToIgnoreCase(atual.contato.nome) > 0) {
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

            } else if (atual.direita == null) {
                // Caso 2b: Nó com apenas um filho à esquerda
                return atual.esquerda;
            }

            // Caso 3: Nó com dois filhos

            No predecessor = maiorNo(atual.esquerda);

            atual.contato = predecessor.contato;
            atual.esquerda = excluirRecursivo(atual.esquerda, predecessor.contato.nome);
        }

        return atual;
    }

    No maiorNo(No atual) {
        while (atual.direita != null) {
            atual = atual.direita;
        }
        return atual;
    }

    public static void main(String[] args) {

        ArvoreAgenda arvoreAgenda = new ArvoreAgenda();

        Agenda[] contatos = {
                new Agenda("Lucas", "Rua A, 123", "1111-1111"),
                new Agenda("Amanda", "Rua B, 456", "2222-2222"),
                new Agenda("Bruno", "Rua C, 789", "3333-3333"),
                new Agenda("Carla", "Rua D, 101", "4444-4444"),
                new Agenda("Eduardo", "Rua E, 202", "5555-5555"),
                new Agenda("Fernanda", "Rua F, 303", "6666-6666"),
                new Agenda("Gustavo", "Rua G, 404", "7777-7777"),
                new Agenda("Helena", "Rua H, 505", "8888-8888"),
                new Agenda("Igor", "Rua I, 606", "9999-9999"),
                new Agenda("Beatriz", "Rua J, 707", "0000-0000")
        };

        for (Agenda contato : contatos) {
            arvoreAgenda.inserir(contato);
        }

        // arvoreAgenda.preOrdem();

        System.out.println("=== Contatos na Agenda ===");
        arvoreAgenda.emOrdem();

        arvoreAgenda.exibirArvore();

        // Buscar pessoa
        String nomeBuscaAgenda = "Helena";
        Agenda resultadoAgenda = arvoreAgenda.buscarPorNome(nomeBuscaAgenda);
        System.out.println("\nBusca na agenda: " + resultadoAgenda);

        // // Excluir contato e exibir árvore novamente

        // arvoreAgenda.excluir("Bruno");
        // arvoreAgenda.exibirArvore();

    }

}
