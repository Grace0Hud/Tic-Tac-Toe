/**
 * Used to simulate game interactions.
 */
package edu.cpp.tictactoe;

public class Game
{
    private final Player playerOne;
    private final Player playerTwo;
    private finalBoard board= new Board();;

    Game (Player playerOne, Player playerTwo){
        this.playerOne = playerOne;
        this.playerTwo= playerTwo;
    }

    public void run(){
        Player current = playerOne;
        while (true) {
            board.print();
            int[] move = current.chooseMove(board); // polymorphism!
            board.place(move[0], move[1], current.mark());
            if (board.winner() != Mark.EMPTY) {
                board.print();
                System.out.println("Winner: " + current.name());
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
