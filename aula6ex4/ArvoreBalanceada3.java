package aula6ex4;

import java.util.LinkedList;
import java.util.Queue;

// 1. Classe de modelo Agenda
class Agenda {
    public String nome;
    public String endereco;
    public String telefone;

    public Agenda(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Contato { Nome: '" + nome + "', Endereço: '" + endereco + "', Telefone: '" + telefone + "' }";
    }
}

// 2. Interface Exercicio2
interface Exercicio2 {
    void inserir(Agenda contato);

    void emOrdem();

    Agenda buscarPorNome(String nome);
}

// 3. Classe Árvore AVL de Agendas
class AVLTree3 implements Exercicio2 {

    // Nó da árvore
    static class Node {
        Agenda contato;
        Node esquerda, direita;
        int altura;

        Node(Agenda contato) {
            this.contato = contato;
            this.altura = 1;
        }
    }

    Node raiz;

    // Função para obter altura de um nó
    int altura(Node n) {
        return (n == null) ? 0 : n.altura;
    }

    // Fator de balanceamento
    int fatorBalanceamento(Node n) {
        return (n == null) ? 0 : altura(n.esquerda) - altura(n.direita);
    }

    // Rotação simples para a direita
    Node rotacaoDireita(Node y) {
        Node x = y.esquerda;
        Node T2 = x.direita;

        // Rotação
        x.direita = y;
        y.esquerda = T2;

        // Atualizar alturas
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    // Rotação simples para a esquerda
    Node rotacaoEsquerda(Node x) {
        Node y = x.direita;
        Node T2 = y.esquerda;

        // Rotação
        y.esquerda = x;
        x.direita = T2;

        // Atualizar alturas
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    // Inserir contato e balancear
    Node inserir(Node node, Agenda contato) {
        if (node == null)
            return new Node(contato);

        int comp = contato.nome.compareToIgnoreCase(node.contato.nome);

        if (comp < 0) {
            node.esquerda = inserir(node.esquerda, contato);
        } else if (comp > 0) {
            node.direita = inserir(node.direita, contato);
        } else {
            node.contato = contato; // Atualiza se nome for idêntico
            return node;
        }

        // Atualiza altura
        node.altura = 1 + Math.max(altura(node.esquerda), altura(node.direita));

        // Verifica balanceamento
        int balance = fatorBalanceamento(node);

        // 4 casos de desbalanceamento (comparações alfabéticas)
        if (balance > 1 && contato.nome.compareToIgnoreCase(node.esquerda.contato.nome) < 0)
            return rotacaoDireita(node);

        if (balance < -1 && contato.nome.compareToIgnoreCase(node.direita.contato.nome) > 0)
            return rotacaoEsquerda(node);

        if (balance > 1 && contato.nome.compareToIgnoreCase(node.esquerda.contato.nome) > 0) {
            node.esquerda = rotacaoEsquerda(node.esquerda);
            return rotacaoDireita(node);
        }

        if (balance < -1 && contato.nome.compareToIgnoreCase(node.direita.contato.nome) < 0) {
            node.direita = rotacaoDireita(node.direita);
            return rotacaoEsquerda(node);
        }

        return node;
    }

    // Método público de inserção da interface
    @Override
    public void inserir(Agenda contato) {
        System.out.println("Inserção contato: " + contato.nome);
        raiz = inserir(raiz, contato);
        emNivel();
        System.out.println();
    }

    // Percurso em ordem (imprime ordenado por nome)
    void emOrdem(Node node) {
        if (node != null) {
            emOrdem(node.esquerda);
            System.out.println(node.contato);
            emOrdem(node.direita);
        }
    }

    @Override
    public void emOrdem() {
        emOrdem(raiz);
    }

    // Percurso em nível (BFS)
    void emNivel() {
        if (raiz == null)
            return;

        Queue<Node> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            Node atual = fila.poll();
            System.out.print("[" + atual.contato.nome + "] ");

            if (atual.esquerda != null)
                fila.add(atual.esquerda);

            if (atual.direita != null)
                fila.add(atual.direita);
        }
        System.out.println();
    }

    // Buscar contato por nome
    @Override
    public Agenda buscarPorNome(String nome) {
        return buscar(raiz, nome);
    }

    private Agenda buscar(Node node, String nome) {
        if (node == null)
            return null;

        int comp = nome.compareToIgnoreCase(node.contato.nome);

        if (comp == 0)
            return node.contato;
        if (comp < 0)
            return buscar(node.esquerda, nome);
        else
            return buscar(node.direita, nome);
    }
}

// Classe Principal de Teste
public class ArvoreBalanceada3 {
    public static void main(String[] args) {
        Exercicio2 arvore = new AVLTree3();

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

        for (Agenda c : contatos) {
            arvore.inserir(c);
        }

        System.out.println("--- Contatos Em Ordem (Alfabética) ---");
        arvore.emOrdem();

        System.out.println("\nPesquisa.....................");
        System.out.println("Buscar Amanda? " + arvore.buscarPorNome("Amanda"));
        System.out.println("Buscar Roberto? " + arvore.buscarPorNome("Roberto"));
    }
}