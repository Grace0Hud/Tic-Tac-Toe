/**
 * Simulates a human player, including prompting for input
 * to make moves accordingly.
 */

package edu.cpp.tictactoe;

import java.util.Scanner;

public class HumanPlayer extends Player
{
    private final Scanner input;

    public HumanPlayer (String name , Mark mark, Scanner input){
        super(name,mark);
        this.input = input;
    }

    @Override
    public Move nextMove(Board board, int size){
        while (true) {
            System.out.print("Would you like to undo your last move, (Y or N): ");
            String undo = input.next();
                if(undo.equals("Y")){
                    board.undoMove();
                }
            System.out.printf("%s (%s), enter row and col [1-%s 1-%s]: ", name,
                    mark,size, size);
            int r = input.nextInt() - 1;
            int c = input.nextInt() - 1;
            if (board.isEmpty(r, c)) return new Move(r, c, mark);
            System.out.println("Invalid move, try again.");
        }

    }

}
