package sintaxe;

/**
 * Classe que demonstra o conceito de escopo em Java.
 *
 * <p>O código ilustra como as variáveis têm visibilidade limitada ao bloco onde foram declaradas
 * e como variáveis externas podem ser acessadas dentro de blocos internos.</p>
 *
 * @author Juliane Maran
 * @version 1.0
 * @since 2024-06-16
 */
public class Escopo {

    /**
     * Metodo principal que demonstra como o escopo das variáveis funciona em diferentes blocos.
     *
     * <p>Este metodo define variáveis em diferentes blocos e mostra como a visibilidade é
     * limitada ao bloco onde as variáveis foram declaradas, gerando um erro ao tentar
     * acessar uma variável fora do seu escopo.</p>
     *
     * @param args Array de strings que contém os argumentos passados na linha de comando
     *             (não utilizado neste exemplo).
     */
    public static void main(String[] args) {
        int i = 5; // Variável visível no bloco 1 e em seus blocos internos

        { // Bloco 2
            int j = 0; // Variável local ao bloco 2
            System.out.println(i); // Variável i acessível dentro do bloco 2
            j = 5 * i; // j é calculado com base em i
            System.out.println(j);

            { // Bloco 3 (interno ao bloco 2)
                System.out.println(i); // i ainda é acessível
                System.out.println(j); // j também é acessível dentro do bloco 3
            }
        }

        System.out.println(i); // i ainda acessível no bloco 1
        // System.out.println(j); // ERRO: j não é acessível fora do bloco 2
    }

}