package student.tictactoe;

import student.tictactoe.Evaluation;

public class TicTacToe {
    static int numberOfTiles = 9;
    public static Evaluation evaluateBoard(String boardState) {
        boardState = boardState.toLowerCase();
        if (boardState.length() != numberOfTiles) {
            return Evaluation.InvalidInput;
        }
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
    public static boolean checkWinner(String boardState, char player) {
        return checkVertical(boardState, player) || checkHorizontal(boardState, player)
                || checkDiagonal(boardState, player);
    }

    public static boolean checkVertical(String boardState, char player) {
        for (int i = 0; i < 3; i++) {
            if (boardState.charAt(i) == player && boardState.charAt(i + 3) == player &&
                    boardState.charAt(i + 6) == player) {
                return true;
            }
        }
        return false;
    }
    public static boolean checkHorizontal(String boardState, char player) {
        for (int i = 0; i < 9; i+=3) {
            if (boardState.charAt(i) == player && boardState.charAt(i + 1) == player &&
                    boardState.charAt(i + 2) == player) {
                return true;
            }
        }
        return false;
    }

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
