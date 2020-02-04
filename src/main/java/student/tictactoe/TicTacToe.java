package student.tictactoe;

import student.tictactoe.Evaluation;

public class TicTacToe {
    static int numberOfTiles = 9;

    /**
     * Evaluate the state of the board
     * @param boardState The state of the board
     * @return The board evaluation
     */
    public static Evaluation evaluateBoard(String boardState) {
        boardState = boardState.toLowerCase();
        if (boardState.length() != numberOfTiles) {
            return Evaluation.InvalidInput;
        }
        // Check if the number of X's and O's violate TicTacToe rules
        int numX = 0;
        int numO = 0;
        for (int i = 0; i < numberOfTiles; i++) {
            if (boardState.charAt(i) == 'x') {
                numX++;
            } else if (boardState.charAt(i) == 'o') {
                numO++;
            }
        }
        if ((numX - numO) != 0 && (numX - numO) != 1) {
            return Evaluation.UnreachableState;
        }
        //Check if the winners violate TicTacToe rules and return the evaluation accordingly
        if (checkWinner(boardState, 'x') && checkWinner(boardState, 'o')) {
            return Evaluation.UnreachableState;
        }
        if (checkWinner(boardState, 'x') && numX == numO) {
            return Evaluation.UnreachableState;
        }
        if (checkWinner(boardState, 'o') && numX > numO) {
            return Evaluation.UnreachableState;
        }
        if (checkWinner(boardState, 'x')) {
            return Evaluation.Xwins;
        }
        if (checkWinner(boardState, 'o')) {
            return Evaluation.Owins;
        }
        return Evaluation.NoWinner;
    }

    /**
     * Check if the player has won in any manner
     * @param boardState The state of the board
     * @param player The player to check
     * @return Return true if the player has won in any manner
     */
    public static boolean checkWinner(String boardState, char player) {
        return checkVertical(boardState, player) || checkHorizontal(boardState, player)
                || checkDiagonal(boardState, player);
    }

    /**
     * Check if the player has won by a vertical
     * @param boardState The state of the board
     * @param player The player to check
     * @return Return true if the player has won by a vertical
     */
    public static boolean checkVertical(String boardState, char player) {
        for (int i = 0; i < 3; i++) {
            if (boardState.charAt(i) == player && boardState.charAt(i + 3) == player &&
                    boardState.charAt(i + 6) == player) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if the player has won by a horizontal
     * @param boardState The state of the board
     * @param player The player to check
     * @return Return true if the player has won by a horizontal
     */
    public static boolean checkHorizontal(String boardState, char player) {
        for (int i = 0; i < 9; i+=3) {
            if (boardState.charAt(i) == player && boardState.charAt(i + 1) == player &&
                    boardState.charAt(i + 2) == player) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if the player has won by a diagonal
     * @param boardState The state of the board
     * @param player The player to check
     * @return Return true if the player has won by a diagonal
     */
    public static boolean checkDiagonal(String boardState, char player) {
        if (boardState.charAt(0) == player && boardState.charAt(4) == player &&
                boardState.charAt(8) == player) {
            return true;
        }
        if (boardState.charAt(2) == player && boardState.charAt(4) == player &&
                boardState.charAt(6) == player) {
            return true;
        }
        return false;
    }
}
