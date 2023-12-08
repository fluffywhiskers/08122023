// Figura 23.24: BackgroundCalculator.java
// Subclasse SwingWorker para calcular os números de Fibonacci
// Thread em segundo plano
import javax.swing.*;
import java.util.concurrent.*;

public class BackgroundCalculator extends SwingWorker<Long, Object>{
    private final int n; // Número de Fibonacci a calcular
    private final JLabel resultJLabel; // JLabel para exibir o resultado
    // construtor
    public BackgroundCalculator(int n, JLabel resultJLabel) {
        this.n = n;
        this.resultJLabel = resultJLabel;
    }
    // Código de longa duração para ser executado em uma thread trabalhadora
    public Long doInBackground() {
        long nthFib;
        return nthFib = fibonacci(n);
    }
    // Código a ser executado na thread de despacho de eventos quando doInBackground retorna
    protected void done() {
        try {
            // Obtém o resultado de doInBackground e o exibe
            resultJLabel.setText(get().toString());
        } catch (InterruptedException ex) {
            resultJLabel.setText("Interrupted while waiting for results.");
        } catch (ExecutionException e) {
            resultJLabel.setText("Error encountered while performing calculation.");
        }
    }
    // Método Fibonacci recursivo; Calcula o enésimo número de Fibonacci
    public long fibonacci(long number) {
        if (number == 0 || number == 1) {
            return number;
        } else {
            return fibonacci(number -1) + fibonacci(number -2);
        }
    }
} // Fim da classe BackgroundCalculator