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

    /**
     * Gets the next move for a computer player.
     * Chooses a random empty row/column.
     * @param board
     * @param size
     * @return the chosen move. 
     */
    @Override
    public Move nextMove(Board board, int size) {
        int row, col;

        do {
            row = random.nextInt(board.getSize());
            col = random.nextInt(board.getSize());
        } while (!board.isEmpty(row, col));

        return new Move(row, col, this.mark);
    }
}
