public class Sorters {

    public void insertionSort(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            int chave = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] > chave) {
                vetor[j + 1] = vetor[j];
                j = j - 1;
            }
            vetor[j + 1] = chave;
        }
    }

    private void insertionSort(int[] vetor, int inicio, int fim) {
        for (int i = inicio + 1; i <= fim; i++) {
            int chave = vetor[i];
            int j = i - 1;
            while (j >= inicio && vetor[j] > chave) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = chave;
        }
    }

    public void mergeSort(int[] vetor) {
        if (vetor.length < 2) return;
        mergeSortRecursivo(vetor, 0, vetor.length - 1);
    }

    private void mergeSortRecursivo(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSortRecursivo(vetor, inicio, meio);
            mergeSortRecursivo(vetor, meio + 1, fim);
            merge(vetor, inicio, meio, fim);
        }
    }

    private void merge(int[] vetor, int inicio, int meio, int fim) {
        int[] temp = new int[fim - inicio + 1];
        int i = inicio, j = meio + 1, k = 0;
        while (i <= meio && j <= fim) {
            if (vetor[i] <= vetor[j]) temp[k++] = vetor[i++];
            else temp[k++] = vetor[j++];
        }
        while (i <= meio) temp[k++] = vetor[i++];
        while (j <= fim) temp[k++] = vetor[j++];
        for (i = inicio; i <= fim; i++) vetor[i] = temp[i - inicio];
    }

    public void quickSort(int[] vetor) {
        quickSortRecursivo(vetor, 0, vetor.length - 1);
    }

    private void quickSortRecursivo(int[] vetor, int inicio, int fim) {
        int tamanho = fim - inicio + 1;
        if (tamanho <= 10) {
            insertionSort(vetor, inicio, fim);
        } else {
            int pivo = medianaDeTres(vetor, inicio, fim);
            int i = inicio;
            int j = fim - 1;

            while (true) {
                while (vetor[++i] < pivo);
                while (vetor[--j] > pivo);
                if (i >= j) {
                    break;
                }
                trocar(vetor, i, j);
            }

            trocar(vetor, i, fim - 1);

            quickSortRecursivo(vetor, inicio, i - 1);
            quickSortRecursivo(vetor, i + 1, fim);
        }
    }

    private int medianaDeTres(int[] vetor, int inicio, int fim) {
        int meio = (inicio + fim) / 2;

        if (vetor[inicio] > vetor[meio]) trocar(vetor, inicio, meio);
        if (vetor[inicio] > vetor[fim]) trocar(vetor, inicio, fim);
        if (vetor[meio] > vetor[fim]) trocar(vetor, meio, fim);

        trocar(vetor, meio, fim - 1);
        return vetor[fim - 1];
    }

    private void trocar(int[] vetor, int idx1, int idx2) {
        int temp = vetor[idx1];
        vetor[idx1] = vetor[idx2];
        vetor[idx2] = temp;
    }
}