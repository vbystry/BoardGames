package hwdp;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTests{
    @Test
    public void shouldCreateThePawns(){
        ChineseCheckers testgame = new ChineseCheckers(3);

        assertEquals(30, testgame.pawns.size());

        ChineseCheckers test2 = new ChineseCheckers(6);
        assertEquals(60, test2.pawns.size());

        assertEquals(10, test2.getWinningfields(1).size());
        assertEquals(10, test2.getWinningfields(2).size());
        assertEquals(10, test2.getWinningfields(3).size());
        assertEquals(10, test2.getWinningfields(4).size());
        assertEquals(10, test2.getWinningfields(5).size());
        assertEquals(10, test2.getWinningfields(6).size());
        assertEquals(2, test2.getWinningfields(1).get(0).length);
        assertEquals(10, test2.getWinningfields(2).size());

        assertEquals(12, test2.getWinningfields(1).get(0)[0]);
        assertEquals(21, test2.getWinningfields(4).get(0)[0]);

        assertEquals(40, test2.getForbiddenFields(2).size());

        //assertEquals(0, test2.winningfields[1].get(0)[0]);






    }
}
