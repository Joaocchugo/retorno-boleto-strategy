import java.nio.file.Path;
import java.util.List;

public class ProcessadorBoletos {
    private LeituraRetorno leituraRetorno;

    public ProcessadorBoletos(final LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }

    public final void processar(Path caminhoArquivo) {
        System.out.println("Boletos Processados:");
        System.out.println("----------------------------------------------------------------------------------");
        final List<Boleto> boletos = leituraRetorno.lerArquivo(caminhoArquivo);
        for (Boleto boleto : boletos) {
            System.out.println(boleto);
        }
    }
}
