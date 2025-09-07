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

    /**
     * Compares two moves to check if they are the same.
     * @param obj the object to compare two
     * @return if the objects have the same row,col, and mark.
     */
    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Move)
        {
            Move m = (Move)obj;
            return (row == m.row && col == m.col && mark == m.mark);
        }
        return false;
    }

    public String toString()
    {
        return row+","+col+","+mark;
    }

}
