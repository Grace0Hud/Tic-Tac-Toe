package edu.cpp.tictactoe;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest
{
    @Test
    void BoardConstructorTest()
    {
	  Board defaultBoard = new Board();
	  assertEquals("   |   |  \n---+---+---\n   |   |  \n---+---+---\n   |   |  \n\n\n",
		    defaultBoard.toString());

	  Board board = new Board(4);
	  assertEquals("   |   |   |  \n---+---+---+---\n   |   |   |  \n---+---+---+---\n   |   |   |  \n---+---+---+---\n   |   |   |  \n\n\n",
		    board.toString());
    }

    @Test
    void sizeTest()
    {
	  Board defaultBoard = new Board();
	  assertEquals(3, defaultBoard.getSize());
	  defaultBoard.setSize(10);
	  assertEquals(10, defaultBoard.getSize());
    }

    @Test
    void cellPlacementTest()
    {
	  Board defaultBoard = new Board();
	  assertTrue(defaultBoard.isEmpty(1,2));
	  assertSame(Mark.EMPTY, defaultBoard.getCell(1, 2));
	  Player player1 = new HumanPlayer("You", Mark.X, new Scanner(System.in));
	  defaultBoard.place(1,2,player1);
	  assertEquals(Mark.X, defaultBoard.getCell(1,2));
    }

    @Test
    void moveHistoryTest()
    {
	  Board defaultBoard = new Board();
	  Player player1 = new HumanPlayer("You", Mark.X, new Scanner(System.in));
	  defaultBoard.place(1,2,player1);
	  Move expectedMove = new Move(1, 2, Mark.X);
	  assertEquals(expectedMove, defaultBoard.getLastMove());
    }

    @Test
    void undoMoveTest()
    {
	  Board defaultBoard = new Board();
	  Player player1 = new HumanPlayer("You", Mark.X, new Scanner(System.in));
	  defaultBoard.place(1,2,player1);
	  defaultBoard.place(2,2,player1);
	  assertEquals(Mark.X, defaultBoard.getCell(2,2));
	  defaultBoard.undoMove();
	  assertTrue(defaultBoard.isEmpty(2,2));
	  Move expectedMove = new Move(1, 2, Mark.X);
	  assertEquals(expectedMove, defaultBoard.getLastMove());
    }

    @Test
    void isFullTest()
    {
	  Board defaultBoard = new Board();
	  Player player1 = new HumanPlayer("You", Mark.X, new Scanner(System.in));
	  for (int i = 0; i < defaultBoard.getSize(); i++)
	  {
		for(int j = 0; j < defaultBoard.getSize(); j++)
		{
		    defaultBoard.place(i,j,player1);
		}
	  }
	  assertTrue(defaultBoard.isFull());
    }
}