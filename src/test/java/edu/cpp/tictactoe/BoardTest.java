package edu.cpp.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest
{
    private Board defaultBoard;
    private Player player1;
    @BeforeEach
    void setUp()
    {
	  defaultBoard = new Board();
	  player1 = new HumanPlayer("You", Mark.X, new Scanner(System.in));
    }
    @Test
    void BoardConstructorTest()
    {
	  assertEquals("   |   |  \n---+---+---\n   |   |  \n---+---+---\n   |   |  \n\n\n",
		    defaultBoard.toString());

	  Board board = new Board(4);
	  assertEquals("   |   |   |  \n---+---+---+---\n   |   |   |  \n---+---+---+---\n   |   |   |  \n---+---+---+---\n   |   |   |  \n\n\n",
		    board.toString());
    }

    @Test
    void sizeTest()
    {
	  assertEquals(3, defaultBoard.getSize());
	  defaultBoard.setSize(10);
	  assertEquals(10, defaultBoard.getSize());
    }

    @Test
    void cellPlacementTest()
    {
	  assertTrue(defaultBoard.isEmpty(1,2));
	  assertSame(Mark.EMPTY, defaultBoard.getCell(1, 2));
	  defaultBoard.place(1,2,player1);
	  assertEquals(Mark.X, defaultBoard.getCell(1,2));
    }

    @Test
    void moveHistoryTest()
    {
	  defaultBoard.place(1,2,player1);
	  Move expectedMove = new Move(1, 2, Mark.X);
	  assertEquals(expectedMove, defaultBoard.getLastMove());
    }

    @Test
    void undoMoveTest()
    {
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
	  for (int i = 0; i < defaultBoard.getSize(); i++)
	  {
		for(int j = 0; j < defaultBoard.getSize(); j++)
		{
		    defaultBoard.place(i,j,player1);
		}
	  }
	  assertTrue(defaultBoard.isFull());
	  defaultBoard.undoMove();
	  assertFalse(defaultBoard.isFull());
    }

    @Test
    void winnerFromRow()
    {
	  for(int i = 0; i < defaultBoard.getSize(); i++)
	  {
		defaultBoard.place(0,i,player1);
	  }
	  assertNotEquals(Mark.EMPTY,defaultBoard.winner());
    }

    @Test
    void winnerFromCol()
    {
	  for(int i = 0; i < defaultBoard.getSize(); i++)
	  {
		defaultBoard.place(i,2,player1);
	  }
	  assertNotEquals(Mark.EMPTY,defaultBoard.winner());
    }

    @Test
    void winnerFromDiagonal()
    {
	  for(int i = 0; i < defaultBoard.getSize(); i++)
	  {
		defaultBoard.place(i,i,player1);
	  }
	  assertNotEquals(Mark.EMPTY,defaultBoard.winner());
    }

    @Test
    void winnerFromAntiDiag()
    {
	  for(int i = defaultBoard.getSize(); i > -1; i--)
	  {
		defaultBoard.place(i,i,player1);
	  }
	  assertNotEquals(Mark.EMPTY,defaultBoard.winner());
    }

    @Test
    void noWinDiffMarksTest()
    {
	  Player player2 = new HumanPlayer("me", Mark.O, new Scanner(System.in));
	  defaultBoard.place(0,0,player1);
	  defaultBoard.place(0,1,player2);
	  defaultBoard.place(0,2,player1);
	  assertEquals(Mark.EMPTY, defaultBoard.winner());
    }
} //end BoardTest class.