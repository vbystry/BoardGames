package hwdp;
import static org.junit.Assert.*;
import org.junit.Test;

public class ChineseBoardTest {
    @Test

    public void shouldGenereate()
    {
        Board board = new ChineseCheckersBoard();
        board.generateBoard();

    }
    @Test
    public void shoulNotBeNull(){
        Board board = new ChineseCheckersBoard();
        assertNotNull(board.fields[12][0]);
        assertNotNull(board.fields[12][16]);
        assertNotNull(board.fields[2][4]);
        assertNotNull(board.fields[24][4]);
        assertNotNull(board.fields[0][12]);
        assertNotNull(board.fields[24][12]);
        //AssertNotNull

    }

}
