package entidade;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class CompactadorGZIP {

    public void compactarPasta(File pasta) {

        File[] arquivos = pasta.listFiles();

        if (arquivos == null || arquivos.length == 0) {
            System.out.println("A pasta está vazia.");
            return;
        }

        for (File arquivo : arquivos) {

            // Considera apenas arquivos comuns (ignora subpastas)
            if (arquivo.isFile()) {
                compactarArquivo(arquivo);
            }
        }
    }

    private void compactarArquivo(File arquivo) {

        String nomeArquivoGz = arquivo.getAbsolutePath() + ".gz";

        try (
            FileInputStream fis = new FileInputStream(arquivo);
            FileOutputStream fos = new FileOutputStream(nomeArquivoGz);
            GZIPOutputStream gzos = new GZIPOutputStream(fos)
        ) {

            byte[] buffer = new byte[1024];
            int bytesLidos;

            while ((bytesLidos = fis.read(buffer)) != -1) {
                gzos.write(buffer, 0, bytesLidos);
            }

            System.out.println("Arquivo compactado: " + arquivo.getName());

        } catch (IOException e) {
            System.out.println("Erro ao compactar o arquivo "
                    + arquivo.getName() + ": " + e.getMessage());
        }
    }
}
