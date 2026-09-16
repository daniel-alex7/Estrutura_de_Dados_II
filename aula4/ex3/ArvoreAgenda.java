package aula4.ex3;

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
        } else {
            // Caso o nome já exista, atualiza o contato
            atual.contato = contato;
        }

        return atual;
    }

    void preOrdem() {
        System.out.println("Contatos em Pré-Ordem:");
        preOrdemRecursivo(raiz);
        System.out.println();
    }

    void preOrdemRecursivo(No atual) {
        if (atual != null) {
            System.out.print(atual.contato.nome + " ");
            preOrdemRecursivo(atual.esquerda);
            preOrdemRecursivo(atual.direita);
        }
    }

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

    Agenda buscarPorNome(String nome) {
        return buscarRecursivo(raiz, nome);
    }

    Agenda buscarRecursivo(No atual, String nome) {
        if (atual == null) {
            return null;
        }

        int comp = nome.compareToIgnoreCase(atual.contato.nome);
        if (comp == 0) {
            return atual.contato;
        } else if (comp < 0) {
            return buscarRecursivo(atual.esquerda, nome);
        } else {
            return buscarRecursivo(atual.direita, nome);
        }
    }

    void exibirArvore() {
        System.out.println("\nÁrvore Binária:");
        if (raiz == null) {
            System.out.println("(árvore vazia)");
            return;
        }

        System.out.println(raiz.contato.nome);
        
        if (raiz.esquerda != null) {
            exibirArvoreRecursivo(raiz.esquerda, "", raiz.direita == null, "E: ");
        }

        if (raiz.direita != null) {
            exibirArvoreRecursivo(raiz.direita, "", true, "D: ");
        }
    }

    void exibirArvoreRecursivo(No atual, String prefixo, boolean ultimo, String lado) {
        if (atual == null) return;

        System.out.println(prefixo + (ultimo ? "└── " : "├── ") + lado + atual.contato.nome);

        String novoPrefixo = prefixo + (ultimo ? "   " : "│  ");

        if (atual.esquerda != null) {
            exibirArvoreRecursivo(atual.esquerda, novoPrefixo, atual.direita == null, "E: ");
        }

        if (atual.direita != null) {
            exibirArvoreRecursivo(atual.direita, novoPrefixo, true, "D: ");
        }
    }

    void excluir(String nome) {
        raiz = excluirRecursivo(raiz, nome);
    }

    No excluirRecursivo(No atual, String nome) {
        if (atual == null) return null;

        int comp = nome.compareToIgnoreCase(atual.contato.nome);

        if (comp < 0) {
            atual.esquerda = excluirRecursivo(atual.esquerda, nome);
        } else if (comp > 0) {
            atual.direita = excluirRecursivo(atual.direita, nome);
        } else {
            if (atual.esquerda == null && atual.direita == null) {
                return null;
            } else if (atual.esquerda == null) {
                return atual.direita;
            } else if (atual.direita == null) {
                return atual.esquerda;
            }

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
}