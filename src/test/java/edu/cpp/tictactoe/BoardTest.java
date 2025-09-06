package edu.cpp.tictactoe;

import org.junit.jupiter.api.Test;

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
}