# Análise de Performance de Algoritmos de Ordenação

Este projeto em Java oferece uma análise comparativa de performance entre cinco algoritmos de ordenação fundamentais. A aplicação mede e exibe o tempo de execução, o número de comparações e o número de trocas que cada algoritmo leva para ordenar vetores de diferentes tamanhos e em diferentes cenários (aleatório, ordenado, inversamente ordenado e parcialmente ordenado).

## 🎯 Objetivo do Projeto

O objetivo principal é fornecer uma visão prática e quantitativa sobre a eficiência de diferentes algoritmos de ordenação. Através dos resultados exibidos no console, é possível observar como a complexidade de cada algoritmo se comporta em cenários variados, validando os conceitos teóricos de Análise de Algoritmos e Estrutura de Dados.

## ✨ Funcionalidades

-   **Análise Múltipla:** Compara a performance de cinco algoritmos de ordenação de uma só vez.
-   **Métricas Detalhadas:** Para cada algoritmo, o sistema mede:
    -   **Tempo de Execução:** Em milissegundos, para avaliar a velocidade.
    -   **Número de Comparações:** Quantas vezes os elementos do vetor são comparados.
    -   **Número de Trocas:** Quantas vezes os elementos do vetor mudam de posição.
-   **Diversos Cenários de Teste:** A análise é executada em vetores com as seguintes características:
    -   **Aleatório:** Elementos em ordem aleatória.
    -   **Ordenado:** Elementos já em ordem crescente.
    -   **Inversamente Ordenado:** Elementos em ordem decrescente (pior caso para alguns algoritmos).
    -   **Parcialmente Ordenado:** A maioria dos elementos está em ordem, com alguns em posições aleatórias.
-   **Escalabilidade:** O programa testa os algoritmos com diferentes tamanhos de vetores (1000, 10000 e 100000 elementos) para demonstrar como o desempenho é afetado pela escala.

## 📈 Algoritmos Analisados

1.  **Bubble Sort**
2.  **Insertion Sort**
3.  **Selection Sort**
4.  **Merge Sort**
5.  **Quick Sort**

## 🚀 Tecnologias Utilizadas

-   **Java:** O projeto é inteiramente construído em Java, sem a necessidade de bibliotecas externas.

## ⚙️ Como Executar o Projeto

1.  **Pré-requisitos:**
    * É necessário ter o Java Development Kit (JDK) versão 8 ou superior instalado.

2.  **Passos para Execução:**
    * Clone este repositório para a sua máquina local.
    * Abra o projeto na sua IDE Java de preferência (Eclipse, IntelliJ IDEA, VS Code, etc.).
    * Localize e execute o arquivo `src/Main.java`.
    * Aguarde a execução. Os resultados da análise de performance para cada cenário e tamanho de vetor serão impressos diretamente no console.

### Exemplo de Saída no Console
```
Analisando vetores com 1000 elementos
--------------------------------------------------
Cenário: Vetor Aleatório

Bubble Sort:
  Tempo: 15 ms
  Comparações: 499500
  Trocas: 251340

Insertion Sort:
  Tempo: 4 ms
  Comparações: 247858
  Trocas: 247858

... (e assim por diante para todos os algoritmos e cenários)
```

## 📂 Estrutura do Código

-   `Main.java`: Ponto de entrada da aplicação. Orquestra a criação dos vetores e a chamada dos métodos de análise, exibindo os resultados no console.
-   `Sorters.java`: Contém a implementação estática de todos os cinco algoritmos de ordenação. Cada método de ordenação retorna o número de comparações e trocas realizadas.
-   `DataManager.java`: Responsável por gerar os vetores com as diferentes características (aleatório, ordenado, etc.) e nos tamanhos especificados.
-   `AnalisadorPerformance.java`: Classe que executa um algoritmo de ordenação em um determinado vetor, medindo o tempo e capturando as métricas de desempenho.
-   `ResultadoAnalise.java`: Uma classe simples (POJO) para armazenar os resultados (tempo, trocas, comparações) de uma única análise para facilitar a manipulação dos dados.
