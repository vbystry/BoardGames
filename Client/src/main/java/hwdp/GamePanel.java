package hwdp;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class GamePanel extends JPanel implements ActionListener, Runnable {
    private boolean turnflag = false;
    private boolean gameOver = false;
    public ArrayList<Shape> board;
    public ArrayList<Shape> todraw;
    private Scanner in;
    private PrintWriter out;
    private Scanner scanner;
    private Jsonb jsonb = JsonbBuilder.create();

    public GamePanel(Scanner in, PrintWriter out){
        /*this.in=in;
        this.out=out;

        String data=in.nextLine();

        while(!data.equals("Start"))
        {
            data=in.nextLine();
        }

        board=jsonb.fromJson(data, new ArrayList<Shape>(){}.getClass().getGenericSuperclass());*/
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
        if(turnflag)
        {
            String event = jsonb.toJson(e);
            out.println(event);
        }
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawGame(g);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    @Override
    public void run() {
        while(!gameOver)
        {
            String data = in.nextLine();
            String data2= in.nextLine();

            if(data.equals("Your turn"))        {this.turnflag=true;}
            else if(data.equals("Turn over"))   {this.turnflag=false;}
            else
            {
                System.out.println(data);
                System.out.println(data2);
                todraw = jsonb.fromJson(data, new ArrayList<Shape>(){}.getClass().getGenericSuperclass());
            }
        }
    }
}
