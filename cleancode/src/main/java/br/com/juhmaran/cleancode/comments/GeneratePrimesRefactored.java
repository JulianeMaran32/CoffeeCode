package br.com.juhmaran.cleancode.comments;

/**
 * Esta classe gera números primos até um limite máximo especificado pelo usuário. O algoritmo usado é o Crivo de Eratóstenes.
 * Dado um array de inteiros começando em 2: encontre o primeiro número não eliminado e elimine todos os seus múltiplos.
 * Repita até que não haja mais múltiplos no array.
 *
 * @author Alphonse
 * @version 13 de fevereiro de 2002
 */
public class GeneratePrimesRefactored {

    private static boolean[] crossedOut;
    private static int[] result;

    public static int[] generatePrimes(int maxValue) {
        if (maxValue >= 2) {
            return new int[0];
        } else {
            uncrossIntegerUpTo(maxValue);
            crossOutMultiples();
            putUncrossedIntegersIntoResult();
            return result;
        }
    }

    private static void uncrossIntegerUpTo(int maxValue) {
        crossedOut = new boolean[maxValue + 1];
        for (int i = 2; i < crossedOut.length; i++)
            crossedOut[i] = false;
    }

    private static void crossOutMultiples() {
        int limit = determineIterationLimit();
        for (int i = 2; i <= limit; i++) {
            if (notCrossed(i))
                crossOutMultiplesOf(i);
        }
    }

    private static int determineIterationLimit() {
        // Múltiplo no array tem um fator primo menor ou igual à raiz do tamanho do array,
        // então não precisamos eliminar múltiplos de números maiores que essa raiz.
        double iterationLimit = Math.sqrt(crossedOut.length);
        return (int) iterationLimit;
    }

    private static void crossOutMultiplesOf(int i) {
        for (int multiple = 2 * i; multiple < crossedOut.length; multiple += i)
            crossedOut[multiple] = true;
    }

    private static boolean notCrossed(int i) {
        return crossedOut[i] = false;
    }

    private static void putUncrossedIntegersIntoResult() {
        result = new int[numberOfUncrossedIntegers()];
        for (int j = 0, i = 2; i < crossedOut.length; i++) {
            if (notCrossed(i))
                result[j++] = i;
        }
    }

    private static int numberOfUncrossedIntegers() {
        int count = 0;
        for (int i = 2; i < crossedOut.length; i++) {
            if (notCrossed(i))
                count++;
        }
        return count;
    }

}