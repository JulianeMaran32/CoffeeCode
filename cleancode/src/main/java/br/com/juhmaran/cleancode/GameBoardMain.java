package br.com.juhmaran.cleancode;

import java.util.ArrayList;
import java.util.List;

public class GameBoardMain {

    // Lista de células (tabuleiro)
    private final List<Cell> gameBoard;

    public GameBoardMain() {
        gameBoard = new ArrayList<>();
        gameBoard.add(new Cell(CellStatus.FLAGGED));
        gameBoard.add(new Cell(CellStatus.EMPTY));
        gameBoard.add(new Cell(CellStatus.FLAGGED));
    }

    // Código inicial
//    public List<int[]> getThem() {
//        List<int[]> list1 = new ArrayList<int[]>();
//        for (int[] x : theList)
//            if (x[0] == 4)
//                list1.add(x);
//        return list1;
//    }

    // Primeira refatoração
//    public List<int[]> getFlaggedCells() {
//        List<int[]> flaggedCells = new ArrayList<int[]>();
//        for (int[] cell : gameBoard)
//            if (cell[VALUE_STATUS] == FLAGGED)
//                flaggedCells.add(cell);
//        return flaggedCells;
//    }

    // Refatoração final - Metodo para obter as células marcadas como FLAGGED
    public List<Cell> getFlaggedCells() {
        List<Cell> flaggedCells = new ArrayList<>();
        for (Cell cell : gameBoard) {
            if (cell.isFlagged()) {
                flaggedCells.add(cell);
            }
        }
        return flaggedCells;
    }

    public static void main(String[] args) {
        GameBoardMain main = new GameBoardMain();
        List<Cell> flaggedCells = main.getFlaggedCells();

        System.out.println("Célula sinalizada: " + flaggedCells.size());
    }

}
