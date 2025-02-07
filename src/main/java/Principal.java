import java.net.URI;
import java.nio.file.Path;

public class Principal {
    public static void main(String[] args) {
        // Definição dos caminhos dos arquivos (usando Path para evitar erro de URI no Windows)
        Path arquivoBancoBrasil = Path.of("banco-brasil-1.csv");
        Path arquivoBradesco = Path.of("bradesco-1.csv");

        // Processamento do arquivo do Banco do Brasil
        ProcessadorBoletos processadorBB = new ProcessadorBoletos(new LeituraRetornoBancoBrasil());
        processadorBB.processar(arquivoBancoBrasil);

        // Processamento do arquivo do Bradesco
        ProcessadorBoletos processadorBradesco = new ProcessadorBoletos(new LeituraRetornoBradesco());
        processadorBradesco.processar(arquivoBradesco);
    }
}










