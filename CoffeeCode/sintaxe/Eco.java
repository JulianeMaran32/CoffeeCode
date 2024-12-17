package sintaxe;

/**
 * Classe que demonstra como imprimir argumentos passados pela linha de comando.
 *
 * <p>A classe percorre todos os argumentos fornecidos ao programa e os imprime na saída padrão
 * em uma única linha, separados por espaço.</p>
 *
 * @author Juliane Maran
 * @version 1.0
 * @since 2024-06-16
 */
public class Eco {

    /**
     * Metodo principal que inicia a execução do programa.
     *
     * <p>Este metodo itera sobre o array {@code args}, que contém os argumentos fornecidos na
     * linha de comando, e imprime cada argumento separado por um espaço.</p>
     *
     * @param args Array de strings que contém os argumentos passados na linha de comando.
     *             Se nenhum argumento for fornecido, a saída será uma linha vazia.
     */
    public static void main(String[] args) {
        // Itera sobre os argumentos e os imprime na saída padrão
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i] + " ");
        }
        // Adiciona uma quebra de linha ao final da saída
        System.out.println();
    }
}
