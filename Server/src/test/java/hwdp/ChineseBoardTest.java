package hwdp;

import org.junit.Test;

public class ChineseBoardTest {
    @Test
    public void shouldGenereate()
    {
        Board board = new ChineseCheckersBoard();
        board.generateBoard();

    }
    public void shoulNotBeNull(){
        //AssertNotNull

    }
}
