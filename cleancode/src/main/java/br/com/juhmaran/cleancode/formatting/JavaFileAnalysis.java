package br.com.juhmaran.cleancode.formatting;

import java.io.File;

public interface JavaFileAnalysis {

    void analyzeFile(File javaFile) throws Exception;

    int getLineCount();

    int getMaxLineWidth();

    int getWidestLineNumber();

    double getMeanLineWidth();

    int getMedianLineWidth();

}
