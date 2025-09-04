/**
 * Indicates the guideline for creating a player.
 */

package edu.cpp.tictactoe;

abstract class Player
{
    final Mark mark;

    public abstract Move nextMove(Board board){

    }

    public Mark getMark() {
        return mark;
    }
}
