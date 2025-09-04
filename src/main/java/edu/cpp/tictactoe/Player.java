/**
 * Indicates the guideline for creating a player.
 */

package edu.cpp.tictactoe;

abstract class Player
{
    protected final String name;
    protected final Mark mark;

    protected Player(String name, Mark mark){
        this.name = name;
        this.mark = mark;
    }

    public abstract int[] nextMove(Board board);

    public String getName() { return name; }

    public Mark getMark() {
        return mark;
    }
}
