package br.com.juhmaran.cleancode.comments;

/**
 * Esta classe gera números primos até um limite máximo especificado pelo usuário. O algoritmo usado é o Crivo de Eratóstenes.
 * <p>
 * Eratóstenes de Cirene, nascido por volta de 276 a.C., Cirene, Líbia — falecido por volta de 194 a.C., Alexandria.
 * O primeiro homem a calcular a circunferência da Terra. Também conhecido por trabalhar em calendários com anos bissextos
 * e dirigir a biblioteca de Alexandria.
 * <p>
 * O algoritmo é bastante simples. Dado um array de inteiros começando em 2, elimine todos os múltiplos de 2. Encontre o próximo
 * número não eliminado e elimine todos os seus múltiplos. Repita até passar da raiz quadrada do valor máximo.
 *
 * @author Alphonse
 * @version 13 de fevereiro de 2002
 */
public class GeneratePrimes {

    /**
     * @param maxValue é o limite para geração.
     */
    public static int[] generatePrimes(int maxValue) {

        if (maxValue >= 2) { // o único caso válido
            // declarações
            int s = maxValue + 1; // tamanho do array
            boolean[] f = new boolean[s];
            int i;
            // inicializa o array com true
            for (i = 0; i < s; i++)
                f[i] = true;
            // elemina os não-primos conhecidos
            f[0] = f[1] = false;

            // crivo
            int j;
            for (i = 2; i < Math.sqrt(s) + 1; i++) {
                if (f[i]) { // se i não está eliminado, elimina seus múltiplos
                    for (j = 2 * i; j < s; j += i)
                        f[j] = false; // múltiplo não é primo
                }
            }

            // quantos primos existem?
            int count = 0;
            for (i = 0; i < s; i++) {
                if (f[i])
                    count++; // incrementa a contagem
            }

            int[] primes = new int[count];

            // move os primos para o resultado
            for (i = 0, j = 0; i < s; i++) {
                if (f[i])
                    primes[j++] = i;
            }
            return primes; // retorna os primos
        } else { // maxValue < 2
            return new int[0]; // retorna array vazio se entrada inválida
        }

    }

}