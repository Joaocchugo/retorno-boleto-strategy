import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LeituraRetornoBancoBrasil implements LeituraRetorno {
    @Override
    public List<Boleto> lerArquivo(final Path caminhoArquivo) {
        try {
            var listaLinhas = Files.readAllLines(caminhoArquivo);
            final var listaBoletos = new ArrayList<Boleto>();

            for (String linha : listaLinhas) {
                final String[] vetor = linha.split(";");
                final var boleto = new Boleto();

                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodBanco(vetor[1]);
                boleto.setDataVencimento(LocalDate.parse(vetor[2], FORMATO_DATA));
                boleto.setDataPagamento(LocalDate.parse(vetor[3], FORMATO_DATA).atTime(0, 0, 0));
                boleto.setCpfCliente(vetor[4]);
                boleto.setValor(Double.parseDouble(vetor[5]));
                boleto.setMulta(Double.parseDouble(vetor[6]));
                boleto.setJuros(Double.parseDouble(vetor[7]));

                listaBoletos.add(boleto);
            }

            return listaBoletos;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
