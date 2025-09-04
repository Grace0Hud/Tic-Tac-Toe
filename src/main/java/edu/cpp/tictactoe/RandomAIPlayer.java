/**
 * Simulates an AI player which takes random moves according
 * to the open sections on the board.
 */

package edu.cpp.tictactoe;
import java.util.*;

public class RandomAIPlayer extends Player
{
    private final Move strategy;

    public RandomAIPlayer(String name, Mark mark, Move strategy){
        super(name, mark);
        this.strategy = strategy;
    }

    @Override
    public int[] nextMove(Board board) {
        return strategy.pickMove(board, mark);
    }
}
