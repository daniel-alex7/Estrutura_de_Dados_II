package aual5ex3;

public class ArvoreBiblioteca {
    static class No {
        Biblioteca livro;
        No esquerda, direita;

        No(Biblioteca livro) {
            this.livro = livro;
            esquerda = direita = null;
        }
    }

    No raiz;

    public void inserir(Biblioteca livro) {
        raiz = inserirRecursivo(raiz, livro);
    }

    protected No inserirRecursivo(No atual, Biblioteca livro) {
        if (atual == null) return new No(livro);

        if (livro.titulo.compareToIgnoreCase(atual.livro.titulo) < 0)
            atual.esquerda = inserirRecursivo(atual.esquerda, livro);
        else if (livro.titulo.compareToIgnoreCase(atual.livro.titulo) > 0)
            atual.direita = inserirRecursivo(atual.direita, livro);

        return atual;
    }

    // Pré-ordem
    public void preOrdem() {
        preOrdemRecursivo(raiz);
        System.out.println();
    }

    void preOrdemRecursivo(No atual) {
        if (atual != null) {
            System.out.print(atual.livro.titulo + " ");
            preOrdemRecursivo(atual.esquerda);
            preOrdemRecursivo(atual.direita);
        }
    }

    // Em-ordem (alfabética por título)
    public void emOrdem() {
        emOrdemRecursivo(raiz);
        System.out.println();
    }

    void emOrdemRecursivo(No atual) {
        if (atual != null) {
            emOrdemRecursivo(atual.esquerda);
            System.out.println(atual.livro);
            emOrdemRecursivo(atual.direita);
        }
    }

    // Buscar por título
    public Biblioteca buscarPorNome(String nome) {
        return buscarRecursivo(raiz, nome);
    }

    Biblioteca buscarRecursivo(No atual, String nome) {
        if (atual == null) return null;
        int cmp = nome.compareToIgnoreCase(atual.livro.titulo);
        if (cmp == 0) return atual.livro;
        if (cmp < 0) return buscarRecursivo(atual.esquerda, nome);
        return buscarRecursivo(atual.direita, nome);
    }

    // Buscar por autor (imprime resultados)
    public void buscarPorAutor(String autor) {
        System.out.println("Livros do autor: " + autor);
        buscarPorAutorRecursivo(raiz, autor);
    }

    void buscarPorAutorRecursivo(No atual, String autor) {
        if (atual == null) return;
        buscarPorAutorRecursivo(atual.esquerda, autor);
        if (atual.livro.autor.equalsIgnoreCase(autor)) System.out.println(atual.livro);
        buscarPorAutorRecursivo(atual.direita, autor);
    }

    // Exibir árvore (títulos)
    public void exibirArvore() {
        System.out.println("\nÁrvore Binária:");
        if (raiz == null) {
            System.out.println("(árvore vazia)");
            return;
        }
        System.out.println(raiz.livro.titulo);
        if (raiz.esquerda != null)
            exibirArvoreRecursivo(raiz.esquerda, "", raiz.direita == null, "E: ");
        if (raiz.direita != null)
            exibirArvoreRecursivo(raiz.direita, "", true, "D: ");
    }

    void exibirArvoreRecursivo(No atual, String prefixo, boolean ultimo, String lado) {
        if (atual == null) return;
        System.out.println(prefixo + (ultimo ? "└── " : "├── ") + lado + atual.livro.titulo);
        String novoPrefixo = ultimo ? prefixo + "  " : prefixo + "│ ";
        if (atual.esquerda != null)
            exibirArvoreRecursivo(atual.esquerda, novoPrefixo, atual.direita == null, "E: ");
        if (atual.direita != null)
            exibirArvoreRecursivo(atual.direita, novoPrefixo, true, "D: ");
    }

    // Excluir por título
    public void excluir(String nome) {
        raiz = excluirRecursivo(raiz, nome);
    }

    No excluirRecursivo(No atual, String nome) {
        if (atual == null) return null;
        int cmp = nome.compareToIgnoreCase(atual.livro.titulo);
        if (cmp < 0) {
            atual.esquerda = excluirRecursivo(atual.esquerda, nome);
            return atual;
        } else if (cmp > 0) {
            atual.direita = excluirRecursivo(atual.direita, nome);
            return atual;
        }

        // Nó encontrado
        if (atual.esquerda == null && atual.direita == null) return null;
        if (atual.esquerda == null) return atual.direita;
        if (atual.direita == null) return atual.esquerda;

        No predecessor = maiorNo(atual.esquerda);
        atual.livro = predecessor.livro;
        atual.esquerda = excluirRecursivo(atual.esquerda, predecessor.livro.titulo);
        return atual;
    }

    No maiorNo(No atual) {
        while (atual.direita != null) atual = atual.direita;
        return atual;
    }

    public static void main(String[] args) {
        ArvoreBiblioteca arvoreBiblioteca = new ArvoreBiblioteca();

        Biblioteca[] livros = {
                new Biblioteca("Dom Casmurro", "Machado de Assis", 1899),
                new Biblioteca("Memórias Póstumas", "Machado de Assis", 1881),
                new Biblioteca("O Alienista", "Machado de Assis", 1882),
                new Biblioteca("A Hora da Estrela", "Clarice Lispector", 1977),
                new Biblioteca("Perto do Coração Selvagem", "Clarice Lispector", 1943),
                new Biblioteca("Grande Sertão: Veredas", "Guimarães Rosa", 1956),
                new Biblioteca("Sagarana", "Guimarães Rosa", 1946),
                new Biblioteca("Capitães da Areia", "Jorge Amado", 1937),
                new Biblioteca("Gabriela, Cravo e Canela", "Jorge Amado", 1958),
                new Biblioteca("Dona Flor e Seus Dois Maridos", "Jorge Amado", 1966),
                new Biblioteca("O Primo Basílio", "Eça de Queirós", 1878),
                new Biblioteca("Os Maias", "Eça de Queirós", 1888),
                new Biblioteca("A Moreninha", "Joaquim Manuel de Macedo", 1844),
                new Biblioteca("Iracema", "José de Alencar", 1865),
                new Biblioteca("O Guarani", "José de Alencar", 1857),
                new Biblioteca("Senhora", "José de Alencar", 1875),
                new Biblioteca("Vidas Secas", "Graciliano Ramos", 1938),
                new Biblioteca("São Bernardo", "Graciliano Ramos", 1934),
                new Biblioteca("Angústia", "Graciliano Ramos", 1936),
                new Biblioteca("Auto da Compadecida", "Ariano Suassuna", 1955)
        };

        for (Biblioteca livro : livros) arvoreBiblioteca.inserir(livro);

        System.out.println("\n=== Livros na Biblioteca ===");
        arvoreBiblioteca.emOrdem();

        String nomeLivro = "Iracema";
        Biblioteca resultadoLivro = arvoreBiblioteca.buscarPorNome(nomeLivro);
        System.out.println("\nBusca por livro: " + resultadoLivro + "\n");

        String autorBusca = "Machado de Assis";
        arvoreBiblioteca.buscarPorAutor(autorBusca);
    }
}
