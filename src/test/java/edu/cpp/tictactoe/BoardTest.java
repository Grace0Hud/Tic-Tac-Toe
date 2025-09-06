package edu.cpp.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest
{
    @Test
    void BoardConstructor()
    {
	  Board defaultBoard = new Board();
	  assertEquals("   |   |  \n---+---+---\n   |   |  \n---+---+---\n   |   |  \n\n\n",
		    defaultBoard.toString());

	  Board board = new Board(4);
	  assertEquals("   |   |   |  \n---+---+---+---\n   |   |   |  \n---+---+---+---\n   |   |   |  \n---+---+---+---\n   |   |   |  \n\n\n",
		    board.toString());
    }
}