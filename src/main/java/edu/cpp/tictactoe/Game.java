/**
 * Used to simulate game interactions.
 */
package edu.cpp.tictactoe;

public class Game
{
    Player playerOne;
    Player playerTwo;
    Board board;

    Game (Player p1, Player p2, Board board){
        playerOne = p1;
        playerTwo= p2;
         this.board = board;
    }

    public void run(){

    }
}
