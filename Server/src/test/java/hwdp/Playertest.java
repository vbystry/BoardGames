package hwdp;

import org.junit.Test;

import java.net.Socket;

public class Playertest {
    @Test
    public void playertest(){
        App app = new App();
        Socket socket = new Socket();
        Player testplayer = new Player(socket, app);
        testplayer.startGame(new ChineseCheckers(2));
    }
}
