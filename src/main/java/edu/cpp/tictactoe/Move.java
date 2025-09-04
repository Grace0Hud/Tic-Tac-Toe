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

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public Mark getMark() {
        return mark;
    }
    private void validate(int row, int col){

    }
}
