public class MinHeapGenerico<T extends Comparable<T>> {
    private Object[] heap;     // usa Object, mas converte para T quando acessa
    private int tamanho;
    private int capacidade;

    public MinHeapGenerico(int capacidade) {
        this.capacidade = capacidade;
        this.heap = new Object[capacidade];
        this.tamanho = 0;
    }

    // Métodos auxiliares de índice
    private int pai(int i) { return (i - 1) / 2; }
    private int esquerdo(int i) { return 2 * i + 1; }
    private int direito(int i) { return 2 * i + 2; }

    @SuppressWarnings("unchecked")
    private T get(int i) {
        return (T) heap[i];
    }

    private void trocar(int i, int j) {
        Object temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Inserção de um novo elemento
    public void inserir(T valor) {
        if (tamanho == capacidade) {
            System.out.println("Heap cheio! Não é possível inserir " + valor);
            return;
        }
        heap[tamanho] = valor;
        int atual = tamanho;
        tamanho++;

        // "Sobe" o elemento se for menor que o pai
        while (atual > 0 && get(atual).compareTo(get(pai(atual))) < 0) {
            trocar(atual, pai(atual));
            atual = pai(atual);
        }
    }

    // Remove e retorna o menor elemento
    public T removerMin() {
        if (tamanho <= 0) {
            System.out.println("Heap vazio!");
            return null;
        }

        T raiz = get(0);
        heap[0] = heap[tamanho - 1];
        tamanho--;
        heapify(0);
        return raiz;
    }

    // Reorganiza o heap após remoção
    private void heapify(int i) {
        int menor = i;
        int esq = esquerdo(i);
        int dir = direito(i);

        if (esq < tamanho && get(esq).compareTo(get(menor)) < 0)
            menor = esq;
        if (dir < tamanho && get(dir).compareTo(get(menor)) < 0)
            menor = dir;

        if (menor != i) {
            trocar(i, menor);
            heapify(menor);
        }
    }

    // Mostra o heap atual
    public void mostrarHeap() {
        System.out.print("Heap atual: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }

    // Programa de teste
    public static void main(String[] args) {
        // Heap que guarda Integers (mas poderia ser String, Double, etc.)
        MinHeapGenerico<Integer> heap = new MinHeapGenerico<>(20);

        Integer[] numeros = {25, 30, 10, 20, 45, 18, 69, 65, 27, 33, 14};

        System.out.println("Inserindo elementos no heap:");
        for (Integer n : numeros) {
            System.out.println("Inserindo: " + n);
            heap.inserir(n);
            heap.mostrarHeap();
        }

        System.out.println("\nRemovendo elementos em ordem (menor primeiro):");
        while (heap.tamanho > 0) {
            System.out.println("Removido: " + heap.removerMin());
            heap.mostrarHeap();
        }


        // String
        MinHeapGenerico<String> heapStr = new MinHeapGenerico<>(10);
        heapStr.inserir("uva");
        heapStr.inserir("banana");
        heapStr.inserir("abacaxi");
        heapStr.inserir("laranja");
        heapStr.mostrarHeap();

        System.out.println("\nRemovendo frutas em ordem (menor primeiro):");
        while (heapStr.tamanho > 0) {
            System.out.println("Removido: " + heapStr.removerMin());
            heapStr.mostrarHeap();
        }

    }
}
