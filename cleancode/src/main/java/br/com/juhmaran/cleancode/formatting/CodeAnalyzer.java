package br.com.juhmaran.cleancode.formatting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class CodeAnalyzer implements JavaFileAnalysis {

    private int lineCount;
    private int maxLineWidth;
    private int widestLineNumber;
    private int totalChars;
    private final LineWidthHistogram lineWidthHistogram;

    public CodeAnalyzer(LineWidthHistogram lineWidthHistogram) {
        this.lineWidthHistogram = lineWidthHistogram;
    }

    public static List<File> findJavaFiles(File parentDirectory) {
        List<File> files = new ArrayList<File>();
        findJavaFiles(parentDirectory, files);
        return files;
    }

    public static void findJavaFiles(File parentDirectory, List<File> files) {
        for (File file : Objects.requireNonNull(parentDirectory.listFiles())) {
            if (file.getName().endsWith(".java"))
                files.add(file);
            else if (file.isDirectory())
                findJavaFiles(file, files);
        }
    }

    @Override
    public void analyzeFile(File javaFile) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(javaFile));
        String line;
        while ((line = br.readLine()) != null)
            measureLine(line);
    }

    private void measureLine(String line) {
        lineCount++;
        int lineSize = line.length();
        totalChars += lineSize;
        lineWidthHistogram.addLine(lineSize, lineCount);
        recordWidestLine(lineSize);
    }

    private void recordWidestLine(int lineSize) {
        if (lineSize > maxLineWidth) {
            maxLineWidth = lineSize;
            widestLineNumber = lineCount;
        }
    }

    @Override
    public int getLineCount() {
        return lineCount;
    }

    @Override
    public int getMaxLineWidth() {
        return maxLineWidth;
    }

    @Override
    public int getWidestLineNumber() {
        return widestLineNumber;
    }

    public LineWidthHistogram getLineWidthHistogram() {
        return lineWidthHistogram;
    }

    @Override
    public double getMeanLineWidth() {
        return (double) totalChars / lineCount;
    }

    @Override
    public int getMedianLineWidth() {
        Integer[] sortedWidths = getSortedWidths();
        int cumulativeLineCount = 0;
        for (int width : sortedWidths) {
            cumulativeLineCount += lineCountForWidth(width);
            if (cumulativeLineCount > lineCount / 2)
                return width;
        }
        throw new Error("Cannot get here");
    }

    private int lineCountForWidth(int width) {
        return lineWidthHistogram.getLinesforWidth(width).size();
    }

    private Integer[] getSortedWidths() {
        Set<Integer> widths = lineWidthHistogram.getWidths();
        Integer[] sortedWidths = (widths.toArray(new Integer[0]));
        Arrays.sort(sortedWidths);
        return sortedWidths;
    }

}