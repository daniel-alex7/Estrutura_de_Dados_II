import java.util.*;

public class MinHeapVisual {

    private int[] heap; // array que armazena elementos
    private int tamanho; // número de elementos no heap

    public MinHeapVisual(int capacidade) {
        heap = new int[capacidade];
        tamanho = 0;
    }

    private int pai(int i) { return (i - 1) / 2; }
    private int esquerdo(int i) { return 2 * i + 1; }
    private int direito(int i) { return 2 * i + 2; }

    // Inserção no heap
    public void inserir(int valor) {
        System.out.println("➤ Inserindo: " + valor);
        heap[tamanho] = valor;
        int atual = tamanho;
        tamanho++;

        while (atual > 0 && heap[atual] < heap[pai(atual)]) {
            int tmp = heap[atual];
            heap[atual] = heap[pai(atual)];
            heap[pai(atual)] = tmp;
            atual = pai(atual);
        }
        mostrarArvore();
        System.out.println();
    }

    // Remoção do mínimo
    public int removerMin() {
        int min = heap[0];
        System.out.println("🚨 Removendo: " + min);
        heap[0] = heap[tamanho - 1];
        tamanho--;
        heapify(0);
        mostrarArvore();
        System.out.println();
        return min;
    }

    private void heapify(int i) {
        int menor = i;
        int esq = esquerdo(i);
        int dir = direito(i);

        if (esq < tamanho && heap[esq] < heap[menor]) menor = esq;
        if (dir < tamanho && heap[dir] < heap[menor]) menor = dir;

        if (menor != i) {
            int tmp = heap[i];
            heap[i] = heap[menor];
            heap[menor] = tmp;
            heapify(menor);
        }
    }

    // Exibição visual em ASCII
    public void mostrarArvore() {
        if (tamanho == 0) {
            System.out.println("(vazio)");
            return;
        }

        int h = (int)Math.ceil(Math.log(tamanho + 1)/Math.log(2));
        int largura = (int)Math.pow(2, h) * 4;

        List<StringBuilder> linhas = new ArrayList<StringBuilder>();
        for(int i=0; i<h*2; i++)
            linhas.add(new StringBuilder(repeatChar(' ', largura)));

        desenhar(0, linhas, 0, largura/2, largura/4);

        for(StringBuilder sb : linhas)
            System.out.println(sb.toString());
    }

    private void desenhar(int i, List<StringBuilder> linhas, int linha, int pos, int offset) {
        if(i >= tamanho) return;

        String s = String.valueOf(heap[i]);
        int start = pos - s.length()/2;
        if(start < 0) start = 0;

        for(int k=0; k<s.length() && start+k < linhas.get(linha).length(); k++)
            linhas.get(linha).setCharAt(start+k, s.charAt(k));

        int esq = esquerdo(i);
        int dir = direito(i);

        int newOffset = offset/2;
        if(newOffset < 1) newOffset = 1;

        if(esq < tamanho) {
            if(pos-1 >=0) linhas.get(linha+1).setCharAt(pos-1, '/');
            desenhar(esq, linhas, linha+2, pos - offset, newOffset);
        }
        if(dir < tamanho) {
            if(pos+1 < linhas.get(linha+1).length()) linhas.get(linha+1).setCharAt(pos+1, '\\');
            desenhar(dir, linhas, linha+2, pos + offset, newOffset);
        }
    }

    private static String repeatChar(char c, int vezes) {
        char[] arr = new char[vezes];
        Arrays.fill(arr, c);
        return new String(arr);
    }

    // Programa principal
    public static void main(String[] args) {
        MinHeapVisual heap = new MinHeapVisual(20);
        int[] numeros = {25,30,10,20,45,18,69,65,27,33,14};

        System.out.println("🏗️ Montagem do Heap Binário Mínimo\n");

        // Inserção passo a passo
        for(int n : numeros) {
            heap.inserir(n);
            try { Thread.sleep(500); } catch(Exception e) {}
        }

        System.out.println("Removendo elementos passo a passo:\n");

        // Remoção passo a passo
        while(heap.tamanho > 0) {
            heap.removerMin();
            try { Thread.sleep(700); } catch(Exception e) {}
        }

        System.out.println("✅ Todos os elementos foram removidos!");
    }
}
