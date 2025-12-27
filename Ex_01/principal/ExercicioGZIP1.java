package principal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class ExercicioGZIP1 {

    public static void main(String[] args) {

        String arquivoTxt = "exemplo.txt";
        String arquivoGz = "exemplo.txt.gz";

        // === 1. Criação do arquivo exemplo.txt ===
        try (FileOutputStream fos = new FileOutputStream(arquivoTxt)) {

            String texto = "Olá Java";
            fos.write(texto.getBytes());
            System.out.println("Arquivo exemplo.txt criado com sucesso.");

        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo texto: " + e.getMessage());
            return;
        }

        // === 2. Compactação do arquivo para .gz ===
        try (
            FileInputStream fis = new FileInputStream(arquivoTxt);
            FileOutputStream fos = new FileOutputStream(arquivoGz);
            GZIPOutputStream gzos = new GZIPOutputStream(fos)
        ) {

            byte[] buffer = new byte[1024];
            int bytesLidos;

            while ((bytesLidos = fis.read(buffer)) != -1) {
                gzos.write(buffer, 0, bytesLidos);
            }

            System.out.println("Arquivo compactado com sucesso: " + arquivoGz);

        } catch (IOException e) {
            System.out.println("Erro ao compactar o arquivo: " + e.getMessage());
        }
    }
}
