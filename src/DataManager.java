import java.util.Random;
import java.util.Arrays;

public class DataManager {

    public static int[] gerarVetorAleatorio(int tamanho) {
        int[] vetor = new int[tamanho];
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(tamanho * 10);
        }
        return vetor;
    }

    public static int[] gerarVetorOrdenado(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = i;
        }
        return vetor;
    }

    public static int[] gerarVetorInvertido(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = tamanho - 1 - i;
        }
        return vetor;
    }

    public static int[] gerarVetorQuaseOrdenado(int tamanho) {
        int[] vetor = gerarVetorOrdenado(tamanho);
        Random random = new Random();
        int trocas = (int) (tamanho * 0.05); // 5% de trocas
        for (int i = 0; i < trocas; i++) {
            int idx1 = random.nextInt(tamanho);
            int idx2 = random.nextInt(tamanho);
            int temp = vetor[idx1];
            vetor[idx1] = vetor[idx2];
            vetor[idx2] = temp;
        }
        return vetor;
    }

    public static void imprimirVetor(int[] vetor) {
        System.out.print("[");
        int limite = Math.min(vetor.length, 100);
        for (int i = 0; i < limite; i++) {
            System.out.print(vetor[i]);
            if (i < limite - 1) {
                System.out.print(", ");
            }
        }
        if (vetor.length > 100) {
            System.out.print("...");
        }
        System.out.println("]");
    }

    public static int[] copiarVetor(int[] vetorOriginal) {
        return Arrays.copyOf(vetorOriginal, vetorOriginal.length);
    }
}