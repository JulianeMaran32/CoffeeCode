package br.com.juhmaran.cleancode;

public class Cell {

    private int status;

    public Cell(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isFlagged() {
        return this.status == CellStatus.FLAGGED;
    }

}
