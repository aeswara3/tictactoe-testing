package student.tictactoe;

import student.tictactoe.TicTacToe;
import student.tictactoe.Evaluation;

import org.junit.Test;
import static org.junit.Assert.*;


public class TicTacToeTest {
    @Test
    public void simpleNoWinnerBoard() throws Exception {
        assertEquals(Evaluation.NoWinner, TicTacToe.evaluateBoard("O...X.X.."));
    }
    @Test
    public void simpleXWins() throws Exception {
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard("XO.OX...X"));
    }
    @Test
    public void simpleOWins() throws Exception {
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard("XOXXO..O."));
    }
}