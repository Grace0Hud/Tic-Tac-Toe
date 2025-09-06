/**
 * Options: X, O, EMPTY
 */
package edu.cpp.tictactoe;

public enum Mark {
    X, O, EMPTY;

    @Override
    public String toString() {
        return switch (this) {
            case X -> "X";
            case O -> "O";
            case EMPTY -> " ";
        };
    }


}
