import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {

    private JFrame frame;
    private JTextField campoTamanhoVetor;
    private JButton botaoAnalisar;
    private JTable tabelaResultados;
    private DefaultTableModel modeloTabela;
    private JComboBox<String> comboTipoDados;
    private JButton botaoEncerrar;

    public Main() {
        frame = new JFrame("Analisador de Performance de Algoritmos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 450);
        frame.setLayout(new BorderLayout(10, 10));

        // --- Painel de Entrada (Topo) ---
        JPanel painelEntrada = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        painelEntrada.add(new JLabel("Tamanho do Vetor:"));
        campoTamanhoVetor = new JTextField("20000", 10);
        painelEntrada.add(campoTamanhoVetor);
        painelEntrada.add(new JLabel("Tipo de Dados:"));
        String[] tipos = {"Aleatório", "Ordenado", "Invertido", "Quase Ordenado"};
        comboTipoDados = new JComboBox<>(tipos);
        painelEntrada.add(comboTipoDados);
        botaoAnalisar = new JButton("Analisar Performance");
        painelEntrada.add(botaoAnalisar);
        frame.add(painelEntrada, BorderLayout.NORTH);

        // --- Tabela de Resultados (Centro) ---
        String[] colunas = {"Algoritmo", "Tempo de Execução (ms)"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        tabelaResultados = new JTable(modeloTabela);
        tabelaResultados.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tabelaResultados.setRowHeight(25);
        frame.add(new JScrollPane(tabelaResultados), BorderLayout.CENTER);

        // --- Painel de Ações (Baixo) para o botão de encerrar ---
        JPanel painelAcoes = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10)); // Alinhado à direita
        botaoEncerrar = new JButton("Encerrar Programa");
        painelAcoes.add(botaoEncerrar);
        frame.add(painelAcoes, BorderLayout.SOUTH);

        // --- Ações dos Botões ---
        botaoAnalisar.addActionListener(e -> executarAnalise());

        // --- Ação para o botão de encerrar ---
        botaoEncerrar.addActionListener(e -> System.exit(0)); // Fecha a aplicação
    }

    private void executarAnalise() {
        int tamanho;
        try {
            tamanho = Integer.parseInt(campoTamanhoVetor.getText());
            if (tamanho <= 0) {
                JOptionPane.showMessageDialog(frame, "Por favor, insira um tamanho de vetor positivo.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Por favor, insira um número válido para o tamanho do vetor.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
            return;
        }

        botaoAnalisar.setEnabled(false);
        botaoEncerrar.setEnabled(false);
        frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        modeloTabela.setRowCount(0);
        modeloTabela.addRow(new Object[]{"Processando...", ""});

        SwingWorker<List<ResultadoAnalise>, Void> worker = new SwingWorker<>() {
            @Override
            protected List<ResultadoAnalise> doInBackground() throws Exception {
                String tipoSelecionado = (String) comboTipoDados.getSelectedItem();
                int[] vetor;
                switch (tipoSelecionado) {
                    case "Ordenado":
                        vetor = DataManager.gerarVetorOrdenado(tamanho);
                        break;
                    case "Invertido":
                        vetor = DataManager.gerarVetorInvertido(tamanho);
                        break;
                    case "Quase Ordenado":
                        vetor = DataManager.gerarVetorQuaseOrdenado(tamanho);
                        break;
                    default:
                        vetor = DataManager.gerarVetorAleatorio(tamanho);
                        break;
                }
                AnalisadorPerformance analisador = new AnalisadorPerformance();
                return analisador.executarAnaliseCompleta(vetor);
            }

            @Override
            protected void done() {
                try {
                    List<ResultadoAnalise> resultados = get();
                    modeloTabela.setRowCount(0);
                    for (ResultadoAnalise res : resultados) {
                        Object[] linha = {res.getNomeAlgoritmo(), String.format("%.4f", res.getTempoExecucao())};
                        modeloTabela.addRow(linha);
                    }
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Ocorreu um erro durante a análise.", "Erro", JOptionPane.ERROR_MESSAGE);
                    modeloTabela.setRowCount(0);
                } finally {
                    botaoAnalisar.setEnabled(true);
                    botaoEncerrar.setEnabled(true);
                    frame.setCursor(Cursor.getDefaultCursor());
                }
            }
        };

        worker.execute();
    }

    public void exibir() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().exibir());
    }
}