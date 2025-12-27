package principal;

import entidade.CompactadorGZIP;

import java.io.File;
import java.util.Scanner;

public class PrincipalCompactar {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o caminho da pasta: ");
        String caminhoPasta = scanner.nextLine();

        File pasta = new File(caminhoPasta);

        // Validação do path
        if (!pasta.exists() || !pasta.isDirectory()) {
            System.out.println("O caminho informado não é uma pasta válida.");
            scanner.close();
            return;
        }

        CompactadorGZIP compactador = new CompactadorGZIP();
        compactador.compactarPasta(pasta);

        System.out.println("Processo de compactação finalizado.");
        scanner.close();
    }
}
