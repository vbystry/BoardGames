package hwdp;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTests{
    @Test
    public void shouldCreateThePawns(){
        ChineseCheckers testgame = new ChineseCheckers(6);

        assertEquals(60, testgame.pawns.size());

    }
}
