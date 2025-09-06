/**
 * Used to simulate the board in a game of tick tac toe
 * @param : final int size (of board), final Mark[size][size].
 */

/* Class Notes
* -isEmpty
* -isFull
* -Winner -> decision tree or MiniMax()
* -placing */
package edu.cpp.tictactoe;
import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Deque;

public class Board
{
    private int size = 3;
    private final Mark[][] grid;
    private int moves = 0;

    private final Deque<Move> moveHistory = new ArrayDeque<>();

/* set all board values to EMPTY*/
    public Board(){

        grid = new Mark[size][size];
        reset();
    }

    public Board(int size){

        this.size = size;
        grid = new Mark[size][size];
        reset();
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(int r, int c) {
        if (r < 0 || r >= size || c < 0 || c >= size) return false;
        return grid[r][c] == Mark.EMPTY;
    }

    /* Checks if all grid Values are not EMPTY*/
    public boolean isFull(){ return moves == (size*size); }

    public boolean place (int r, int c, Mark mark, Player current){
        if (!isEmpty(r, c)) return false;
        grid[r][c] = mark;
        moves++;
        if(current.getName().equals("You")){
            moveHistory.push(new Move(r, c, mark));
        }
        return true;
    }

    /* Decision Tree*/
    public Mark winner(){
        for (int i = 0; i < size; i++) {
            if (line(grid[i])) return grid[i][0];
            if (lineColumn(i)) return grid[0][i];
        }
        if (lineDiagonal()) return grid[0][0];
        if (lineAntiDiagonal()) return grid[0][size - 1];
        return Mark.EMPTY;
    }

    private boolean line(Mark[] row) {
        Mark first = row[0];
        if (first == Mark.EMPTY) return false;
        for (Mark m : row) {
            if (m != first) return false;
        }
        return true;
    }

    private boolean lineColumn(int col) {
        Mark first = grid[0][col];
        if (first == Mark.EMPTY) return false;
        for (int r = 0; r < size; r++) {
            if (grid[r][col] != first) return false;
        }
        return true;
    }

    private boolean lineDiagonal() {
        Mark first = grid[0][0];
        if (first == Mark.EMPTY) return false;
        for (int i = 0; i < size; i++) {
            if (grid[i][i] != first) return false;
        }
        return true;
    }
    private boolean lineAntiDiagonal() {
        Mark first = grid[0][size - 1];
        if (first == Mark.EMPTY) return false;
        for (int i = 0; i < size; i++) {
            if (grid[i][size - 1 - i] != first) return false;
        }
        return true;
    }
    public void print() {
        System.out.println(toString());
    }

    /* gets mark from the given cell*/
    public Mark getCell(int r, int c){
        return grid [r][c];
    }

    /* set all the values in grid to Empty*/
    public void reset(){

        for (Mark[] row : grid) {
            Arrays.fill(row,Mark.EMPTY);
        }
        moves= 0;
        moveHistory.clear();
    }

    /* get last move and reverse
    * Store moves in stack
    * using pop get last r and c value
    * setting value to "empty"
    * */

    public void undoMove() {
        if (!moveHistory.isEmpty()) {
            Move last = moveHistory.pop();
            grid[last.getRow()][last.getCol()] = Mark.EMPTY;
            moves--;
            print();
        } else {
            System.out.println("No moves to undo!");
        }
    }

    public String toString()
    {
        String output = "";
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                output += " " + grid[r][c];
                if (c < size - 1) output += (" |");
            }
            output += "\n";
            if (r < size - 1) {
                for (int i = 0; i < size; i++) output += "---" + (i < size - 1 ? "+" : "");
                output += "\n";
            }
        }
        output += "\n\n";
        return output;
    }
}
