/**
 * Used to simulate a move by a player
 * @param int row, int col, Mark mark
 */

package edu.cpp.tictactoe;

public class Move
{
    int row ;
    int col ;
    Mark mark ;

    public Move (int row,int col, Mark mark){
        this.row = row;
        this.col = col;
        this.mark = mark;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setMark(Mark mark) {
            this.mark = mark;
    }

    public Mark getMark() {
        return mark;
    }

}
