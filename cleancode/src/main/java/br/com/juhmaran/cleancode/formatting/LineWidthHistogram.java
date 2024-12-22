package br.com.juhmaran.cleancode.formatting;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LineWidthHistogram {

    private final Map<Integer, Set<Integer>> histogram;

    public LineWidthHistogram() {
        this.histogram = new HashMap<>();
    }

    /**
     * Adiciona uma linha ao histograma com o tamanho e o número da linha.
     *
     * @param lineSize  tamanho da linha
     * @param lineCount número da linha
     */
    public void addLine(int lineSize, int lineCount) {
        histogram.computeIfAbsent(lineSize, k -> new HashSet<>()).add(lineCount);
    }

    /**
     * Obtém as larguras de todas as linhas registradas.
     *
     * @return conjunto de larguras
     */
    public Set<Integer> getWidths() {
        return histogram.keySet();
    }

    /**
     * Obtém a lista de números de linhas para uma largura específica.
     *
     * @param width largura da linha
     * @return conjunto de números de linhas
     */
    public Set<Integer> getLinesforWidth(int width) {
        return histogram.getOrDefault(width, new HashSet<>());
    }

}
