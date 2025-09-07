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
        while (true)
        {
            System.out.println("Enter \'u\' to undo last move\nEnter \'e\' to exit the game.");
            System.out.printf("%s (%s), enter row and col [1-%s 1-%s]: ", name,
                    mark,size, size);
            String choice = input.next();
            if(choice.charAt(0) == 'u' || choice.charAt(0) == 'U')
            {
                board.undoMove();
            }else if(choice.charAt(0) == 'e' || choice.charAt(0) == 'E')
            {
                System.out.println("Exiting game");
                System.exit(0);
            }else if(Character.isDigit(choice.charAt(0)))
            {
                int r = Integer.parseInt(choice) - 1;
                int c = input.nextInt() - 1;
                if (board.isEmpty(r, c)) return new Move(r, c, mark);
                System.out.println("Invalid move, try again.");
            }else
            {
                System.out.println("Invalid input.");
            }
        }
    }
}
