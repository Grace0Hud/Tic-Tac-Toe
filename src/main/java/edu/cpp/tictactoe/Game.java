/**
 * Used to simulate game interactions.
 */
package edu.cpp.tictactoe;

public class Game
{
    private final Player playerOne;
    private final Player playerTwo;
    private final Board board = new Board();;

    Game (Player playerOne, Player playerTwo){
        this.playerOne = playerOne;
        this.playerTwo= playerTwo;
    }

    public void run(){
        Player current = playerOne;
        while (true) {
            board.print();
            Move move = current.nextMove(board); // polymorphism!
            board.place(move.getRow(), move.getCol(), current.getMark());
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
