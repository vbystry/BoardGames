package hwdp;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    protected JPanel panel;

    public GameFrame(String title){
        super(title);
        setSize(1300, 900);
        panel = new GamePanel();
        add(panel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
