package edu.cpp.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GameTest
{
	Game game;
	Player player1, player2;
	@BeforeEach
    	public void setUp()
	{
	    Scanner input = new Scanner(System.in);
	    player1 = new ScriptedPlayer("Human", Mark.X, new Move(0,-1, Mark.X));
	    player2 = new ScriptedPlayer("CPU", Mark.O, new Move(1,-1,Mark.O));
	    game = new Game(player1, player2, input, 3);
	}

	@Test
    	public void testGame()
	{
	    game.run();
	}
}