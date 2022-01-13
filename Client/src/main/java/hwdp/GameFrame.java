package hwdp;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public GameFrame(String title){
        super(title);
        setSize(1300, 900);
        JPanel panel = new GamePanel();
        add(panel);

        setDefaultCloseOperation(3);
        setVisible(true);
    }
}
