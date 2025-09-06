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
        Player human = new HumanPlayer("You", Mark.X, input);
        Player ai = new RandomAIPlayer("Computer", Mark.O);
        Game game = new Game(human, ai, input);
        game.run();
    }
}
