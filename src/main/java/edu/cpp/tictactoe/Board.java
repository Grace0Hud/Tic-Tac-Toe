/**
 * Used to simulate the board in a game of tick tac toe
 * @param : final int size (of board), final Mark[size][size].
 */

package edu.cpp.tictactoe;

public class Board
{
    String[] board;
    private final int size = 3;
    private final Mark[][] grid = Mark.EMPTY;


    private void makeBoard(int size){
        board = new String[size];
        for (int i = 0; i < size; i++){
            board[i] = String.valueOf(i+1);
        }
    }

    public Optional<Mark> winner(){
        Mark win = Mark.X;
        return win;
    }

    public boolean isFull(){
        for (int i = 0; i < size; i++){
            board[i] = String.valueOf(i+1);
            if(getCell() = Mark.EMPTY){
                return False;
            }
        }
            return True;

    }
    public Mark getCell(int r, int c){
        Mark value = Mark.EMPTY;
        return value;
    }

    public void reset(){

    }

    public void place (Move mv){

    }

    public void undoMove(){

    }
}
