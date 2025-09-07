package edu.cpp.tictactoe;

public class ScriptedPlayer extends Player
{
    private Move lastMove;

    public ScriptedPlayer(String name, Mark mark, Move startingMove)
    {
	  super(name, mark);
	  this.lastMove = startingMove;
    }

    @Override
    public Move nextMove(Board board, int size)
    {
	  lastMove = new Move(this.lastMove.getRow(), this.lastMove.getCol()+1, this.mark);
	  return lastMove;
    }
}
