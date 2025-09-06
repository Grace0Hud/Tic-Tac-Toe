/**
 * Simulates an AI player which takes random moves according
 * to the open sections on the board.
 */

package edu.cpp.tictactoe;
import java.util.*;

public class RandomAIPlayer extends Player
{
    private final Random random = new Random();

    public RandomAIPlayer(String name, Mark mark){
        super(name,mark);
    }

    @Override
    public Move nextMove(Board board) {
        int row, col;

        do {
            row = random.nextInt(board.getSize());
            col = random.nextInt(board.getSize());
        } while (!board.isEmpty(row, col));

        return new Move(row, col, this.mark);
    }
}
