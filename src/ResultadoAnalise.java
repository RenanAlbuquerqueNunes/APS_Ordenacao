public class ResultadoAnalise {
    private String nomeAlgoritmo;
    private double tempoExecucao; // Em milissegundos

    public ResultadoAnalise(String nomeAlgoritmo, double tempoExecucao) {
        this.nomeAlgoritmo = nomeAlgoritmo;
        this.tempoExecucao = tempoExecucao;
    }

    public String getNomeAlgoritmo() {
        return nomeAlgoritmo;
    }

    public double getTempoExecucao() {
        return tempoExecucao;
    }
}