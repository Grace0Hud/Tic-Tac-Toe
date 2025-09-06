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
import java.util.Scanner;

public class Board
{
    private int size = 3;
    private final Mark[][] grid;
    private int moves = 0;
    private final Stack<Move> moveHistory = new Stack<>();

/* set all board values to EMPTY*/
    public Board(){
        reset();
        grid = new Mark[size][size];
    }

    public Board(int size){
        reset();
        this.size = size;
        grid = new Mark[size][size];
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

    public boolean place (int r, int c, Mark mark){
        if (!isEmpty(r, c)) return false;
        grid[r][c] = mark;
        moves++;
        moveHistory.push(new Move(r, c, mark));
        return true;
    }

    /* Decision Tree*/
    public Mark winner(){
        for (int i = 0; i < size; i++) {
            if (line(grid[i][0], grid[i][1], grid[i][2])) return grid[i][0];
            if (line(grid[0][i], grid[1][i], grid[2][i])) return grid[0][i];
        }
        if (line(grid[0][0], grid[1][1], grid[2][2])) return grid[0][0];
        if (line(grid[0][2], grid[1][1], grid[2][0])) return grid[0][2];
        return Mark.EMPTY;
    }

    private boolean line(Mark a, Mark b, Mark c) {
        return a != Mark.EMPTY && a == b && b == c;
    }

    public void print() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                System.out.print(" " + grid[r][c]);
                if (c < size - 1) System.out.print(" |");
            }
            System.out.println();
            if (r < size - 1) {
                for (int i = 0; i < size; i++) System.out.print("---" + (i < size - 1 ? "+" : ""));
                System.out.println();
            }
        }
        System.out.print("\n\n");
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

    public void undoMove(){

    }
}
