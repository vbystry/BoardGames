package hwdp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class GamePanel extends JPanel implements Runnable{
    public int turnflag;
    public ArrayList<Shape> board;
    public ArrayList<Shape> todraw;
    private Scanner in;
    private PrintWriter out;
    private Scanner scanner;

    public GamePanel(Scanner in, PrintWriter out){
        this.in=in;
        this.out=out;
    }
    public Shape[][] readBoardFromBuffer(){


        return null;
    }
    public Shape[][] readToDrawFromBuffer(){

        return null;
    }
    private void drawGame(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(new Color(20,50,70));
        Rectangle2D rec = new Rectangle2D.Double(100,100,20,50);
        g2d.fill(rec);


    }
    public void sendClickInfo(MouseEvent e){

    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawGame(g);

    }

    @Override
    public void run() {

    }
}
