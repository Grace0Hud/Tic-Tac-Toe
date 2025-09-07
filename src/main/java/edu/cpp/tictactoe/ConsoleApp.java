/**
 * Class used as a Driver for the program.
 */

package edu.cpp.tictactoe;
import java.util.Scanner;

public class ConsoleApp
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Board size (3 or more): ");
        int size = input.nextInt();
        Player human = new HumanPlayer("You", Mark.X, input);
        Player ai = new RandomAIPlayer("Computer", Mark.O);
        Game game = new Game(human, ai, input, size);
        game.run();
    }
}
