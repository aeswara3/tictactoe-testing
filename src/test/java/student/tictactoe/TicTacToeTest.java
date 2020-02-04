package student.tictactoe;

import student.tictactoe.TicTacToe;
import student.tictactoe.Evaluation;

import org.junit.Test;
import static org.junit.Assert.*;


public class TicTacToeTest {
    @Test
    public void invalidInput() throws Exception {
        assertEquals(Evaluation.InvalidInput, TicTacToe.evaluateBoard("abcxyz"));
    }

    @Test
    public void tooManyX() throws Exception {
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("XX.....XO"));
    }

    @Test
    public void tooManyO() throws Exception {
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("OXO...OX."));
    }

    @Test
    public void TwoWinners() throws Exception {
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("XXX...OOO"));
    }

    @Test
    public void OTurnAfterXWins() throws Exception {
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("XXX.OO..O"));
    }

    @Test
    public void XTurnAfterOWins() throws Exception {
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("XXOXXO..O"));
    }

    @Test
    public void verticalWinnerXWins() throws Exception {
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard("OXO.X.OXX"));
    }

    @Test
    public void verticalWinnerOWins() throws Exception {
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard("OXXO..OX."));
    }

    @Test
    public void horizontalWinnerXWins() throws Exception {
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard("XXXOO...."));
    }

    @Test
    public void horizontalWinnerOWins() throws Exception {
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard("..XOOOXX."));
    }

    @Test
    public void diagonalWinnerXWins() throws Exception {
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard("XO.OX...X"));
    }

    @Test
    public void diagonalWinnerOWins() throws Exception {
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard("XXOXO.O.."));
    }

    @Test
    public void NoWinner() throws Exception {
        assertEquals(Evaluation.NoWinner, TicTacToe.evaluateBoard("XO.XO...."));
    }
}