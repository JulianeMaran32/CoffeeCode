package sintaxe;

import java.util.Scanner;

/**
 * Classe que demonstra a formatação de saída utilizando o metodo {@code printf}.
 *
 * <p>Este exemplo calcula e exibe a soma acumulada de inteiros de 1 até um valor
 * informado pelo usuário, utilizando uma formatação de saída para alinhar os
 * números de forma clara e organizada.</p>
 *
 * @author Juliane Maran
 * @version 1.0
 * @since 2024-06-16
 */
public class SaidaFormatada {

    /**
     * Metodo principal que calcula e exibe a soma acumulada de inteiros com saída formatada.
     *
     * <p>O metodo solicita ao usuário um número inteiro como limite, depois calcula a soma
     * acumulada de inteiros de 1 até o limite. Os resultados intermediários e a soma final
     * são exibidos de forma alinhada utilizando o metodo {@code printf}.</p>
     *
     * @param args Array de strings que contém os argumentos passados na linha de comando
     *             (não utilizado neste exemplo).
     */
    public static void main(String[] args) {
        // Cria um Scanner para capturar a entrada do usuário
        Scanner sc = new Scanner(System.in);

        // Solicita ao usuário o valor limite para a soma
        System.out.print("No final? ");
        int limite = sc.nextInt();

        // Inicializa a variável para armazenar a soma acumulada
        int soma = 0;

        // Calcula a soma acumulada e exibe os resultados parciais
        for (int i = 1; i <= limite; i++) {
            System.out.printf("%3da. soma parcial = %6d%n", i, soma);
            soma += i;
        }

        // Exibe o resultado final da soma acumulada
        System.out.printf("Soma total[0..%3d] = %6d%n", limite, soma);

        // Fecha o Scanner para liberar os recursos associados
        sc.close();
    }

}