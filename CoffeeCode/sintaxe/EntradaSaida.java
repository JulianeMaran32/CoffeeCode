package sintaxe;

import java.util.Scanner;

/**
 * Classe que demonstra entrada e saída de dados simples em Java.
 *
 * <p>A classe lê um valor inteiro digitado pelo usuário e exibe esse valor
 * na saída padrão.</p>
 *
 * @author Juliane Maran
 * @version 1.0
 * @since 2024-06-16
 */
public class EntradaSaida {

    /**
     * Metodo principal que inicia a execução do programa.
     *
     * <p>Este metodo solicita que o usuário insira um número inteiro. Após a entrada,
     * o programa exibe o valor digitado no console. Ele utiliza a classe {@link Scanner}
     * para capturar a entrada de dados.</p>
     *
     * @param args Array de strings que contém os argumentos passados na linha de comando
     *             (não utilizado neste exemplo).
     */
    public static void main(String[] args) {
        // Exibe uma mensagem de boas-vindas
        System.out.println("Olá!");

        // Solicita ao usuário que insira um número inteiro
        System.out.println("Digite um inteiro: ");

        // Instancia um objeto Scanner para capturar a entrada do usuário
        Scanner s = new Scanner(System.in);

        // Lê o próximo valor inteiro fornecido pelo usuário
        int valor = s.nextInt();

        // Exibe o valor lido no console
        System.out.println("Valor = " + valor);

        // Fecha o Scanner para liberar os recursos associados
        s.close();
    }
}
