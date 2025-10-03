import java.util.ArrayList;
import java.util.List;

public class AnalisadorPerformance {

    private Sorters sorters = new Sorters();

    public List<ResultadoAnalise> executarAnaliseCompleta(int[] vetorOriginal) {
        List<ResultadoAnalise> resultados = new ArrayList<>();

        // --- Analisa cada algoritmo e adiciona o resultado à lista ---
        resultados.add(analisarUmAlgoritmo("Insertion Sort", vetorOriginal));
        resultados.add(analisarUmAlgoritmo("Merge Sort", vetorOriginal));
        resultados.add(analisarUmAlgoritmo("Quick Sort", vetorOriginal));

        return resultados;
    }

    // --- Mede o tempo de um único algoritmo ---
    private ResultadoAnalise analisarUmAlgoritmo(String nomeAlgoritmo, int[] vetorOriginal) {
        int[] copia = DataManager.copiarVetor(vetorOriginal);

        long startTime = System.nanoTime();

        switch (nomeAlgoritmo) {
            case "Insertion Sort":
                sorters.insertionSort(copia);
                break;
            case "Merge Sort":
                sorters.mergeSort(copia);
                break;
            case "Quick Sort":
                sorters.quickSort(copia);
                break;
        }

        long endTime = System.nanoTime();
        long durationNano = endTime - startTime;
        double durationMilli = durationNano / 1_000_000.0;

        // --- Retorna um novo objeto com os dados do resultado ---
        return new ResultadoAnalise(nomeAlgoritmo, durationMilli);
    }
}