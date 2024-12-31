import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Txt {

    public static void main(String[] args) {
        String caminhoArquivo = "texto.txt";
        int larguraMaxima = 80;

        String texto = carregarTexto(caminhoArquivo);
        if (texto == null || texto.isEmpty()) {
            System.out.println("Erro ao carregar o texto ou arquivo vazio.");
            return;
        }

        exibirTextoGradativamente(texto, larguraMaxima);
    }

    private static String carregarTexto(String caminhoArquivo) {
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return conteudo.toString();
    }

    private static void exibirTextoGradativamente(String texto, int larguraMaxima) {
        String[] palavras = texto.split(" ");
        StringBuilder linhaAtual = new StringBuilder();

        for (String palavra : palavras) {
            if (linhaAtual.length() + palavra.length() + 1 > larguraMaxima) {
                imprimirComDelay(linhaAtual.toString());
                linhaAtual = new StringBuilder();
            }
            linhaAtual.append(palavra).append(" ");
        }

        if (!linhaAtual.isEmpty()) {
            imprimirComDelay(linhaAtual.toString());
        }
    }

    private static void imprimirComDelay(String texto) {
        for (char c : texto.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
