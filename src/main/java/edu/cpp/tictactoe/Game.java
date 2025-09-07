/**
 * Used to simulate game interactions.
 */
package edu.cpp.tictactoe;
import java.util.Scanner;

public class Game
{
    private final Player playerOne;
    private final Player playerTwo;
    private Board board;
    private final Scanner input;

    public Game(Player playerOne, Player playerTwo, Scanner input, int boardSize) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.input = input;
        board = new Board(boardSize);
    }

    public void run(){
        Player current = playerOne;
        while (true) {
            board.print();
            Move move;
            do
            {
                move = current.nextMove(board, board.getSize()); // polymorphism!
            }while(!board.place(move.getRow(), move.getCol(), current));

            if (board.winner() != Mark.EMPTY) {
                board.print();
                System.out.println("Winner: " + current.getName());
                break;
            }
            if (board.isFull()) {
                board.print();
                System.out.println("Draw!");
                break;
            }
            current = (current == playerOne) ? playerTwo : playerOne;
        }

    }
}
