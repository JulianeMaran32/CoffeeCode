package sintaxes;

import java.util.Scanner;

public class EntradaSaida {

    public static void main(String[] args) {

        System.out.println("Olá!");
        System.out.print("Digite um inteiro: ");

        // Prepara a entrada de dados
        Scanner scanner = new Scanner(System.in);
        int valor = scanner.nextInt();
        System.out.println("Valor = " + valor);

        // Fecha o objeto leitor
        scanner.close();

    }

}
