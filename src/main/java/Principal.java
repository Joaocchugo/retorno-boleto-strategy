import java.net.URI;

public class Principal {
    public static void main(String[] args) {
        // Definição dos arquivos de retorno
        URI arquivoBancoBrasil = URI.create("file:banco-brasil-1.csv");
        URI arquivoBradesco = URI.create("file:bradesco-1.csv");

        // Processamento do arquivo do Banco do Brasil
        ProcessarBoletos processadorBB = new ProcessarBoletos(new LeituraRetornoBancoBrasil());
        processadorBB.processar(arquivoBancoBrasil);

        // Processamento do arquivo do Bradesco
        ProcessarBoletos processadorBradesco = new ProcessarBoletos(new LeituraRetornoBradesco());
        processadorBradesco.processar(arquivoBradesco);
    }
}










