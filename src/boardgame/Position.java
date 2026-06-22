package boardgame;

/**
 * Representa uma posição coordenada (linha e coluna) numa matriz bidimensional de tabuleiro.
 * @author Antonio Andrade Trauthman
 * @author Igor Anicezio Oliveira
 */
public class Position {
    
    private int row;
    private int column;
    
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }
    
    public int getRow() {
        return row;
    }
    
    public void setRow(int row) {
        this.row = row;
    }
    
    public int getColumn() {
        return column;
    }
    
    public void setColumn(int column) {
        this.column = column;
    }
    
    @Override
    public String toString() {
        return row + ", " + column;
    }
}