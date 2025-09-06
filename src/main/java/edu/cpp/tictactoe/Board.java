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

    /**
     * Default constructor to create a Board instance
     * with a grid size of three
     * sets all board mark values to EMPTY
     */
    public Board(){
        grid = new Mark[size][size];
        reset();
    }
    /**
     * Constructor to create a Board instance.
     * Creates a grid of the correct size and
     * sets all board mark values to EMPTY
     * @param size the number of rows and columns in the board.
     */
    public Board(int size){

        this.size = size;
        grid = new Mark[size][size];
        reset();
    }

    /**
     * @return size of the board's grid.
     */
    public int getSize() {
        return size;
    }

    /**
     * Set the size of the board.
     * @param size the size to set the board to.
     */
    public void setSize(int size)
    {
        this.size = size;
    }
    /**
     *  gets mark from the given cell
     * @param r row of the cell
     * @param c column of the cell
     * @return the value at the specified row and column of the grid
     *  */
    public Mark getCell(int r, int c){
        return grid [r][c];
    }

    /**
     * Checks if a specified cell has an empty value
     * @param r the row of the cell
     * @param c the column of the cell
     * @return if the cell is empty or not.
     */
    public boolean isEmpty(int r, int c) {
        if (r < 0 || r >= size || c < 0 || c >= size) return false;
        return grid[r][c] == Mark.EMPTY;
    }

    /**
     * Places a mark at the specified cell of the board grid
     * @param r the row of the cell
     * @param c the column of the cell
     * @param current the current player (the one placing the mark).
     * @return if the mark was placed successfully.
     */
    public boolean place (int r, int c, Player current){
        if (!isEmpty(r, c)) return false;
        grid[r][c] = current.getMark();
        moves++;
        if(current.getName().equals("You")){
            moveHistory.push(new Move(r, c, current.getMark()));
        }
        return true;
    }

    /**
     * @return the last move logged.
     */
    public Move getLastMove()
    {
        return moveHistory.getLast();
    }

    /**
     * get last move and reverse
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

    /**
     * Checks if all grid Values are not EMPTY
     * @return If the number of moves has filled the board grid.
     * */
    public boolean isFull(){ return moves == (size*size); }

    /**
     * Decision tree for checking if a player has won
     * @return the starting cell of the winning streak, or empty
     * if there is no winner.
     */
    public Mark winner(){
        for (int i = 0; i < size; i++) {
            if (line(grid[i])) return grid[i][0];
            if (lineColumn(i)) return grid[0][i];
        }
        if (lineDiagonal()) return grid[0][0];
        if (lineAntiDiagonal()) return grid[0][size - 1];
        return Mark.EMPTY;
    }

    /**
     * Checks for a win through a row.
     * @param row to check for a line through
     * @return if there is a win of a line.
     */
    private boolean line(Mark[] row) {
        Mark first = row[0];
        if (first == Mark.EMPTY) return false;
        for (Mark m : row) {
            if (m != first) return false;
        }
        return true;
    }

    /**
     * Checks for a win through a column.
     * @param col to check for a line through.
     * @return if there is a win through a column.
     */
    private boolean lineColumn(int col) {
        Mark first = grid[0][col];
        if (first == Mark.EMPTY) return false;
        for (int r = 0; r < size; r++) {
            if (grid[r][col] != first) return false;
        }
        return true;
    }

    /**
     * Checks for a win through a diagonal left-right
     * @return if there is a win.
     */
    private boolean lineDiagonal() {
        Mark first = grid[0][0];
        if (first == Mark.EMPTY) return false;
        for (int i = 0; i < size; i++) {
            if (grid[i][i] != first) return false;
        }
        return true;
    }

    /**
     * Checks for a win through a diagonal right-left
     * @return if there is a win.
     */
    private boolean lineAntiDiagonal() {
        Mark first = grid[0][size - 1];
        if (first == Mark.EMPTY) return false;
        for (int i = 0; i < size; i++) {
            if (grid[i][size - 1 - i] != first) return false;
        }
        return true;
    }

    /**
     * prints out the to string to the console.
     */
    public void print() {
        System.out.println(toString());
    }

    /**
     *  set all the values in grid to Empty
     *  */
    public void reset(){

        for (Mark[] row : grid) {
            Arrays.fill(row,Mark.EMPTY);
        }
        moves= 0;
        moveHistory.clear();
    }

    /**
     * Organizes the board into a visual form.
     * @return output the organized string output of the grid.
     */
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
